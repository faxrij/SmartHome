package Sensor;

import Entity.ControlPanel;
import Interface.ISensor;
import Mediator.Mediator;

import java.util.Random;

public class TemperatureSensor implements ISensor {
    private final Mediator mediator;
    private int firstTemperature;

    public TemperatureSensor(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendReading() {
        Random rand = new Random();
        int value = rand.nextInt(45);
        firstTemperature = value;
        System.out.println("Current Temperature: " + value);
        mediator.readTemperature(value);
    }

    public void newTemp() {
        int temperature = mediator.readNewTemperature();
        if (firstTemperature != temperature) {
            System.out.println("New temperature is " + temperature);
        }
    }
}
