package org.example.filemanager;

import java.io.*;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader extends Manager{

    private void loadFile(String path) {
        if (destinationPath == null) {
            logger.log(Level.WARNING, "destination path is empty");
        }
        try {
            // TODO Декомпозиция
            URL url = new URL(path);
            InputStream inputStream;
            try {
                inputStream = url.openStream();
            } catch (IOException exc) {
                logger.warning("openStream is wrong!");
                return;
            }
            FileOutputStream outputStream;
            try {
                // TODO Заменить file на название файла, получать из метода getFileName
                // WARNING Если в файле есть символы ? и тп, то будет эксепшн
                outputStream =new FileOutputStream(destinationPath + "\\" + "file");
            } catch (FileNotFoundException exc) {
                logger.warning("FileOutputStream is wrong!");
                return;
            }

            byte[] buffer = new byte[2048];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            inputStream.close();
            outputStream.close();
        } catch (FileNotFoundException exc) {
            logger.log(Level.WARNING, "Cannot find the file");
        } catch (IOException exc) {
            logger.log(Level.WARNING, "Cannot open the file");
        }
    }

    private static String getFileName(String absolutePath) {
        int lastSlashIndex = absolutePath.lastIndexOf("/");
        if (lastSlashIndex != -1 && lastSlashIndex < absolutePath.length() - 1) {
            return absolutePath.substring(lastSlashIndex + 1);
        } else {
            throw new IllegalArgumentException("Неверный URL файла: " + absolutePath);
        }
    }

    public void loadFiles(List<String> paths) {
        if (destinationPath == null) {
            logger.log(Level.WARNING, "destination path is empty");
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
}
