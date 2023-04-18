package Sensor;

import Command.DoorCommand;
import Interface.ISensor;
import Mediator.Mediator;

import java.util.*;

public class MotionSensor implements ISensor {
    private final Mediator mediator;
    private final List<DoorCommand> doorCommandList;

    public MotionSensor(Mediator mediator) {
        this.mediator = mediator;
        doorCommandList = new ArrayList<>();
        doorCommandList.add(DoorCommand.LOCK);
        doorCommandList.add(DoorCommand.UNLOCK);
    }

    @Override
    public void sendReading() {
        Random random = new Random();
        DoorCommand randomDoorCommand = doorCommandList.get(random.nextInt(2));
        mediator.readMotion(randomDoorCommand);
    }
}
