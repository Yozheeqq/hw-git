package print;

import color.Color;
import strategy.PrintStrategy;

public class Print {

    public void printPaper(PrintStrategy strategy, int pages) {
        strategy.print(pages);
    }

    public void dyePrinter(PrintStrategy strategy, Color color) {
        strategy.dyeCase(color);
    }
}
