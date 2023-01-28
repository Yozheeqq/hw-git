import app.Application;
import factory.ladafactory.LadaFactory;
import factory.ladafactory.LadaGrantaFactory;
import factory.ladafactory.LadaVestaFactory;

public class Main {
    public static void main(String[] args) {
        Application app = configureApplication("Granta");
        app.makeSound();
        app = configureApplication("Vesta");
        app.makeSound();
    }

    private static Application configureApplication(String carName) {
        LadaFactory factory;
        Application app;
        if ("Granta".equals(carName)) {
            factory = new LadaGrantaFactory();
        } else {
            factory = new LadaVestaFactory();
        }
        app = new Application(factory);
        return app;
    }
}