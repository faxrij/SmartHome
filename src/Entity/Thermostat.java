package Entity;

import Command.TemperatureCommand;
import Interface.IActuator;
import Interface.ICommand;

public class Thermostat implements IActuator {
    private int currentTemperature;
    @Override
    public void receiveCommand(ICommand command) {
        if (command.equals(TemperatureCommand.HIGHER)) {
            currentTemperature += 5;
        }
        else {
            currentTemperature -= 5;
        }
    }

    public void setCurrentTemperature(int temperature) {
        currentTemperature = temperature;
    }

}
