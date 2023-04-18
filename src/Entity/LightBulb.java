package Entity;

import Command.LightCommand;
import Interface.IActuator;
import Interface.ICommand;

public class LightBulb implements IActuator {

    @Override
    public void receiveCommand(ICommand command) {
        if (command.equals(LightCommand.ON)) {
            System.out.println("Turning lights ON");
        }
        else {
            System.out.println("Turning lights OFF");
        }
    }
}
