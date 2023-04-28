package Entity;

import Command.TemperatureCommand;
import Interface.IActuator;
import Interface.ICommand;

public class Thermostat implements IActuator {
    private int currentTemperature;
    @Override
    public void receiveCommand(ICommand command) {
        if (!(command instanceof TemperatureCommand)){
            throw new IllegalArgumentException("Invalid command type");
        }
        if (command.equals(TemperatureCommand.HIGHER)) {
            currentTemperature = 20;
            System.out.println("Temperature increased");
        }
        else if (command.equals(TemperatureCommand.LOWER)) {
            currentTemperature = 25;
            System.out.println("Temperature decreased");
        }
    }

    public void setCurrentTemperature(int temperature) {
        currentTemperature = temperature;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }
}
