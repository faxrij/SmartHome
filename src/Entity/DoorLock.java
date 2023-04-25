package Entity;

import Command.DoorCommand;
import Command.LightCommand;
import Interface.IActuator;
import Interface.ICommand;
import State.DoorState;
import State.LightState;

public class DoorLock implements IActuator {

    private DoorState currentDoorState;
    public DoorLock(DoorState doorState) {
        this.currentDoorState = doorState;
    }

    @Override
    public void receiveCommand(ICommand command) {
        if (command.getClass()!=DoorCommand.class) {
            throw new RuntimeException();
        }
        if (currentDoorState.name().startsWith(((DoorCommand) command).name())){
            System.out.println("Wanted state is already on for DoorLock");
        }
        else if (command.equals(DoorCommand.LOCK) && currentDoorState.equals(DoorState.UNLOCKED)){
            System.out.println("Doors are closing");
            currentDoorState = DoorState.LOCKED;
        }
        else if (command.equals(DoorCommand.UNLOCK) && currentDoorState.equals(DoorState.LOCKED)){
            System.out.println("Doors are opening");
            currentDoorState = DoorState.UNLOCKED;
        }
    }
}
