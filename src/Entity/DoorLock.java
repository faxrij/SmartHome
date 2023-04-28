package Entity;

import Command.DoorCommand;
import Interface.IActuator;
import Interface.ICommand;
import State.DoorState;

public class DoorLock implements IActuator {
    private DoorState currentDoorState;

    public DoorLock(DoorState doorState) {
        this.currentDoorState = doorState;
    }

    public DoorState getCurrentDoorState() {
        return currentDoorState;
    }

    @Override
    public void receiveCommand(ICommand command) {
        if (!(command instanceof DoorCommand)) {
            throw new IllegalArgumentException("Invalid command type");
        }

        if (command.equals(DoorCommand.LOCK) && currentDoorState.equals(DoorState.UNLOCKED)){
            currentDoorState = DoorState.LOCKED;
        }

        else if (command.equals(DoorCommand.UNLOCK) && currentDoorState.equals(DoorState.LOCKED)){
            currentDoorState = DoorState.UNLOCKED;
        }
    }
}
