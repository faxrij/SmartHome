package Entity;

import Interface.ISensor;
import Mediator.Mediator;

import java.util.Random;

public class TemperatureSensor implements ISensor {
    private final Mediator mediator;

    public TemperatureSensor(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendReading() {
        Random rand = new Random();
        int value = rand.nextInt(45);
        mediator.readTemperature(value);
    }
}
