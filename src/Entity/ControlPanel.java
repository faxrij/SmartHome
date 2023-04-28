package Entity;

import Command.DoorCommand;
import Command.LightCommand;
import Command.TemperatureCommand;
import Interface.ICommand;
import Mediator.Mediator;

import java.util.Random;

public class ControlPanel {

    public ICommand chooseRandomEventForLight() {
        ICommand command;
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            command = LightCommand.ON;
        }
        else {
            command = LightCommand.OFF;
        }
        return command;
    }

    public ICommand chooseRandomEventForMotion() {
        ICommand command;
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            command = DoorCommand.LOCK;
        }
        else {
            command = DoorCommand.UNLOCK;
        }
        return command;
    }



    public ICommand checkTemperature(int temperature) {
        ICommand command =  TemperatureCommand.LOWER;

        if (temperature >= 20 && temperature <= 25) {
            System.out.println("Temperature is fine");
            command = TemperatureCommand.STANDARD;  // To PREVENT PRINTING LOWER FOR RANGE OF 20 - 25
        }

        else if (temperature < 20) {
            command = TemperatureCommand.HIGHER;
        }
        return command;
    }
}
