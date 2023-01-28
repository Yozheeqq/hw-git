package app;

import cars.lada.Lada;
import factory.ladafactory.LadaFactory;

public class Application {
    private Lada lada;

    public Application(LadaFactory factory) {
        lada = factory.createCar();
    }

    public void makeSound() {
        lada.makeSound();
    }
}
