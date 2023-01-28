package strategy;

import color.Color;

import java.time.LocalDateTime;

public class Printer {
    private Color color;
    private final int year;
    private double amountOfInk;

    Printer(Color color) {
        this.color = color;
        this.year = LocalDateTime.now().getYear();
        amountOfInk = 100;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public void setAmountOfInk(double newAmount) {
        if (newAmount < 0 || newAmount > 100) {
            throw new IllegalArgumentException("Wrong amount!");
        }
        amountOfInk = newAmount;
    }

    public Color getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public double getAmountOfInk() {
        return amountOfInk;
    }
}
