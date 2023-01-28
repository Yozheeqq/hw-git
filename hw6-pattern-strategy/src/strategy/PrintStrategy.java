package strategy;

import color.Color;

public interface PrintStrategy {
    void print(int numberOfPages);
    void dyeCase(Color newColor);
}
