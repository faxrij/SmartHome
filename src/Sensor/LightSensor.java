package Sensor;

import Command.LightCommand;
import Interface.ISensor;
import Mediator.Mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LightSensor implements ISensor {
    private final Mediator mediator;
    private final List<LightCommand> lightCommandList;

    public LightSensor(Mediator mediator) {
        this.mediator = mediator;
        lightCommandList = new ArrayList<>();
        lightCommandList.add(LightCommand.ON);
        lightCommandList.add(LightCommand.OFF);
    }

    @Override
    public void sendReading() {
        Random random = new Random();
        LightCommand lightCommand = lightCommandList.get(random.nextInt(2));
        mediator.readLight(lightCommand);
    }
}
