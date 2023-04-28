package Sensor;

import Interface.ISensor;
import Mediator.Mediator;
import State.DoorState;


public class MotionSensor implements ISensor {
    private final Mediator mediator;

    public MotionSensor(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendReading() {
        DoorState currentDoorState = mediator.getDoorState();
        mediator.changeDoorState();
        DoorState newDoorState = mediator.getDoorState();

        if (currentDoorState.name().startsWith(newDoorState.name())){
            System.out.println("Wanted state is already on for DoorLock");
        }
        else if (newDoorState.equals(DoorState.UNLOCKED)){
            System.out.println("Doors are closing");
        }
        else if (newDoorState.equals(DoorState.LOCKED)){
            System.out.println("Doors are opening");
        }
    }
}
