package Mediator;

import Command.DoorCommand;
import Command.LightCommand;
import Command.TemperatureCommand;
import Entity.DoorLock;
import Entity.LightBulb;
import Entity.Thermostat;

public class Mediator {
    private final Thermostat thermostat;
    private final DoorLock doorLock;
    private final LightBulb lightBulb;

    public Mediator(Thermostat thermostat, DoorLock doorLock, LightBulb lightBulb) {
        this.thermostat = thermostat;
        this.doorLock = doorLock;
        this.lightBulb = lightBulb;
    }

    public void readTemperature(int temperature) {
        if (temperature < 20) {
            thermostat.receiveCommand(TemperatureCommand.HIGHER);
        }
        else {
            thermostat.receiveCommand(TemperatureCommand.LOWER);
        }
    }

    public void readMotion(DoorCommand doorCommand) {
        doorLock.receiveCommand(doorCommand);
    }

    public void turnLightOn() {
        lightBulb.receiveCommand(LightCommand.ON);
    }

    public void turnLightOff() {
        lightBulb.receiveCommand(LightCommand.OFF);
    }

    public void lockDoors() {
        doorLock.receiveCommand(DoorCommand.LOCK);
    }

    public void unlockDoors() {
        doorLock.receiveCommand(DoorCommand.UNLOCK);
    }


    public void setTemperature(int temperature) {
        thermostat.setCurrentTemperature(temperature);
    }

    public void readLight(LightCommand lightCommand) {
        lightBulb.receiveCommand(lightCommand);
    }
}