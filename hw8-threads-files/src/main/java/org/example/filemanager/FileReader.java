package org.example.filemanager;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;

public class FileReader extends Manager {

    public void loadFiles(List<String> paths) {
        if (destinationPath == null) {
            logger.log(Level.WARNING, "destination path is empty");
            throw new UnsupportedOperationException("destination path is empty");
        }
        ExecutorService executor = Executors.newFixedThreadPool(paths.size());
        List<Future<?>> futures = new ArrayList<>();
        for (var path : paths) {
            futures.add(executor.submit(() -> loadFile(path)));
            loadFile(path);
        }
        try {
            for (Future<?> future : futures) {
                future.get();
            }
        } catch (ExecutionException exc) {
            logger.log(Level.WARNING, "Exception while executing");
        } catch (InterruptedException exc) {
            logger.log(Level.WARNING, "Thread was interrupted");
        }

        executor.shutdown();
    }

    private void loadFile(String path) {
        if (destinationPath == null) {
            logger.log(Level.WARNING, "destination path is empty");
            return;
        }
        try {
            InputStream inputStream = initializeInputStream(path);
            FileOutputStream outputStream = initializeOutputStream(path);

            byte[] buffer = new byte[2048];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            inputStream.close();
            outputStream.close();
            logger.info("File was downloaded successfully");
        } catch (FileNotFoundException exc) {
            logger.log(Level.WARNING, "Cannot find the file");
        } catch (IOException exc) {
            logger.log(Level.WARNING, "Cannot open the file");
        }
    }

    public static String getFileName(String absolutePath) {
        if (absolutePath == null) {
            throw new IllegalArgumentException("Пустой путь");
        }
        List<Character> forbiddenChars = List.of('/', '*', '?', ':', '"', '<', '>', '|');
        int lastSlashIndex = absolutePath.lastIndexOf("/");
        if (lastSlashIndex != -1 && lastSlashIndex < absolutePath.length() - 1) {
            String potentialPath = absolutePath.substring(lastSlashIndex + 1);
            for (Character c : forbiddenChars) {
                if (potentialPath.indexOf(c) != -1) {
                    potentialPath = potentialPath.replace(c.toString(), "%");
                }
            }
            return potentialPath;
        } else {
            throw new IllegalArgumentException("Неверный URL файла: " + absolutePath);
        }
    }

    private InputStream initializeInputStream(String path) throws IOException{
        URL url = new URL(path);
        return url.openStream();
    }

    private FileOutputStream initializeOutputStream(String path) throws FileNotFoundException{
        return new FileOutputStream(destinationPath + "\\" + getFileName(path));
    }
}
