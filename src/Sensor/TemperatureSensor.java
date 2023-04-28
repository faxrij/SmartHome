package Sensor;

import Interface.ISensor;
import Mediator.Mediator;


public class TemperatureSensor implements ISensor {
    private final Mediator mediator;

    public TemperatureSensor(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendReading() {
        int value = mediator.generateRandomTemperature();
        System.out.println("Current temperature is: " + value);

        checker(value);
    }

    private void checker(int value) {
        mediator.checkTemperature(value);

        int temperature = mediator.readNewTemperature();
        if (value != temperature) {
            System.out.println("Temperature will be " + temperature);
        }
    }
}
