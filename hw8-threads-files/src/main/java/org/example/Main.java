package org.example;

import org.example.filemanager.FileReader;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final Scanner scanner = new Scanner(System.in);
    private static final FileReader reader = new FileReader();
    public static void main(String[] args) {
        getHelpMenu();
        readCommand();
    }

    private static void readCommand() {
        String line = scanner.nextLine();
        var command = Arrays.stream(line.split(" ")).toList();

        while (command.size() != 0 && !"/exit".equals(command.get(0))) {
            switch (command.get(0)) {
                case "/load" -> reader.loadFiles(command.subList(1, command.size()));
                case "/dest" -> reader.setDestinationPath(command.get(1));
                case "/help" -> getHelpMenu();
                default -> logger.log(Level.WARNING, "Wrong command!");
            }
            line = scanner.nextLine();
            command = Arrays.stream(line.split(" ")).toList();
        }
    }

    private static void getHelpMenu() {
        System.out.println("""
                /help - Показать все комманды
                /dest <Path> - Ввести путь сохранения файлов
                /load <Url_1> <Url_2> ... <Url_N> - Ввести ссылки на файлы
                """);
    }
}