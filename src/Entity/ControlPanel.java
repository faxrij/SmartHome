package Entity;

import Interface.IControlPanel;
import Mediator.Mediator;

import java.util.Random;

public class ControlPanel implements IControlPanel {
    private Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void chooseRandomEventForLight() {
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            this.turnLightOn();
        }
        else {
            this.turnLightOff();
        }
    }

    public void chooseRandomEventForMotion() {
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            this.lockDoors();
        }
        else {
            this.unlockDoors();
        }
    }

    @Override
    public void setTemperature(int temperature) {
        mediator.setTemperature(temperature);
    }

    @Override
    public void turnLightOn() {
        mediator.turnLightOn();
    }

    @Override
    public void turnLightOff() {
        mediator.turnLightOff();
    }

    @Override
    public void lockDoors() {
        mediator.lockDoors();
    }

    @Override
    public void unlockDoors() {
        mediator.unlockDoors();
    }
}
