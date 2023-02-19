package org.example;

import org.example.filemanager.FileReader;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReader();
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("Все ок");
        String line = scanner.nextLine();
        var command = Arrays.stream(line.split(" ")).toList();

        while (command.size() != 0 && !"/exit".equals(command.get(0))) {
            switch (command.get(0)) {
                case "/load":
                    reader.loadFiles(command.subList(1, command.size()));
                    break;
                case "/dest":
                    reader.setDestinationPath(command.get(1));
                    break;
                case "/help":
                    break;
                default:
                    logger.log(Level.WARNING, "Wrong command!");
                    break;
            }
            line = scanner.nextLine();
            command = Arrays.stream(line.split(" ")).toList();
        }
    }
}