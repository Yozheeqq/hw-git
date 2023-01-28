package strategy;

import color.Color;

import java.util.Random;

public class PrinterXerox implements PrintStrategy{
    Printer printer;

    public PrinterXerox(Color color) {
        printer = new Printer(color);
    }

    @Override
    public void print(int numberOfPages) {
        if (printer == null) {
            throw new IllegalArgumentException("Printer is not set");
        }
        // Больше чернил, ура
        double percentageOfInkToPrint = numberOfPages / 300.0;
        double leftInk = printer.getAmountOfInk();
        if (leftInk < percentageOfInkToPrint) {
            throw new IllegalArgumentException("Not enough ink!");
        }
        printer.setAmountOfInk(leftInk - percentageOfInkToPrint);
        System.out.println("Xerox's printed " + numberOfPages + " pages");
    }

    @Override
    public void dyeCase(Color newColor) {
        if (printer == null) {
            throw new IllegalArgumentException("Printer is not set");
        }
        Random random = new Random();
        // Потому что Xerox сломан(
        printer.setColor(Color.values()[random.nextInt(0, 5)]);
        System.out.println("New xerox color is " + printer.getColor());
    }
}
