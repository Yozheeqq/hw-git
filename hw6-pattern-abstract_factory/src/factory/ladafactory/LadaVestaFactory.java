package factory.ladafactory;

import cars.lada.Lada;
import cars.lada.LadaVesta;

public class LadaVestaFactory implements LadaFactory{
    @Override
    public Lada createCar() {
        return new LadaVesta();
    }
}
