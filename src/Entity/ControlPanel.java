package Entity;

import Command.DoorCommand;
import Command.LightCommand;
import Command.TemperatureCommand;
import Interface.ICommand;

import java.util.Random;

public class ControlPanel {

    public ICommand chooseRandomCommandForLight() {
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            return LightCommand.ON;
        }
        else {
            return LightCommand.OFF;
        }
    }

    public ICommand chooseRandomCommandForMotion() {
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            return DoorCommand.LOCK;
        }
        else {
            return DoorCommand.UNLOCK;
        }
    }

    public ICommand checkTemperature(int temperature) {
        if (temperature >= 20 && temperature <= 25) {
            System.out.println("Temperature is fine");
            return TemperatureCommand.STANDARD;  // To PREVENT PRINTING LOWER FOR RANGE OF 20 - 25
        }
        else if (temperature < 20) {
            return TemperatureCommand.HIGHER;
        }
        else {
            return TemperatureCommand.LOWER;
        }
    }
}
