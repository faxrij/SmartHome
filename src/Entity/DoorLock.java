package Entity;

import Command.DoorCommand;
import Interface.IActuator;
import Interface.ICommand;

public class DoorLock implements IActuator {
    @Override
    public void receiveCommand(ICommand command) {
        if (command.equals(DoorCommand.LOCK)) {
            System.out.println("DOORS ARE LOCKED");
        }
        else {
            System.out.println("DOORS ARE UNLOCKED");
        }
    }
}
