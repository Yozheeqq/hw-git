package factory.ladafactory;

import cars.lada.Lada;
import cars.lada.LadaGranta;

public class LadaGrantaFactory implements LadaFactory{
    @Override
    public Lada createCar() {
        return new LadaGranta();
    }
}
