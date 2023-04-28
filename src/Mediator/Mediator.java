package Mediator;

import Command.DoorCommand;
import Command.LightCommand;
import Command.TemperatureCommand;
import Entity.ControlPanel;
import Entity.DoorLock;
import Entity.LightBulb;
import Entity.Thermostat;
import Interface.ICommand;

public class Mediator {
    private final Thermostat thermostat;
    private final DoorLock doorLock;
    private final LightBulb lightBulb;
    private final ControlPanel controlPanel;

    public Mediator(Thermostat thermostat, DoorLock doorLock, LightBulb lightBulb, ControlPanel controlPanel) {
        this.thermostat = thermostat;
        this.doorLock = doorLock;
        this.lightBulb = lightBulb;
        this.controlPanel = controlPanel;
    }

    public void readTemperature(int temperature) {
        controlPanel.readTemperature(temperature, thermostat);
    }

    public int readNewTemperature() {
        return thermostat.getCurrentTemperature();

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