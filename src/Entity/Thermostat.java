package Entity;

import Command.TemperatureCommand;
import Interface.IActuator;
import Interface.ICommand;

public class Thermostat implements IActuator {
    private int currentTemperature;
    @Override
    public void receiveCommand(ICommand command) {
        if (command.getClass()!= TemperatureCommand.class) {
            throw new RuntimeException();
        }
        if (command.equals(TemperatureCommand.HIGHER)) {
            currentTemperature += 5;
            System.out.println("Increasing temperature by 5 degrees");
        }
        else {
            currentTemperature -= 5;
            System.out.println("Decreasing temperature by 5 degrees");
        }
    }

    public void setCurrentTemperature(int temperature) {
        currentTemperature = temperature;
    }
}
