package Entity;

import Command.DoorCommand;
import Interface.IActuator;
import Interface.ICommand;
import Mediator.Mediator;

public class DoorLock implements IActuator {
    @Override
    public void receiveCommand(ICommand command) {
        if (command.equals(DoorCommand.LOCK)) {
            System.out.println("DOORS ARE LOCKED");
        }
    }
}
