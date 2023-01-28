package strategy;

import color.Color;


public class PrinterCanon implements PrintStrategy{
    Printer printer;

    public PrinterCanon(Color color) {
        printer = new Printer(color);
    }

    @Override
    public void print(int numberOfPages) {
        if (printer == null) {
            throw new IllegalArgumentException("Printer is not set");
        }
        double percentageOfInkToPrint = numberOfPages / 100.0;
        double leftInk = printer.getAmountOfInk();
        if (leftInk < percentageOfInkToPrint) {
            throw new IllegalArgumentException("Not enough ink!");
        }
        printer.setAmountOfInk(leftInk - percentageOfInkToPrint);
        System.out.println("Canon's printed " + numberOfPages + " pages");
    }

    @Override
    public void dyeCase(Color newColor) {
        if (printer == null) {
            throw new IllegalArgumentException("Printer is not set");
        }
        printer.setColor(newColor);
        System.out.println("New canon color is " + printer.getColor());
    }
}
