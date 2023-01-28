import color.Color;
import print.Print;
import strategy.PrintStrategy;
import strategy.PrinterCanon;
import strategy.PrinterXerox;

public class Main {
    private static PrintStrategy strategy;
    private static final Print print = new Print();

    public static void main(String[] args) {
        strategy = new PrinterCanon(Color.RED);
        print.printPaper(strategy, 100);
        try {
            print.printPaper(strategy, 50000);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
        print.dyePrinter(strategy, Color.BLUE);
        strategy = new PrinterXerox(Color.BLACK);
        print.dyePrinter(strategy, Color.WHITE);
        try {
            print.printPaper(strategy, 1000);
            print.printPaper(strategy, 1000);
            print.printPaper(strategy, 50000);
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}