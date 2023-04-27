package Mediator;

import Command.DoorCommand;
import Command.LightCommand;
import Command.TemperatureCommand;
import Entity.DoorLock;
import Entity.LightBulb;
import Entity.Thermostat;
import Interface.ICommand;

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
        ICommand command =  TemperatureCommand.LOWER;

        if (temperature >= 20 && temperature <= 25) {
            System.out.println("Temperature is fine");
            return;  // To PREVENT PRINTING LOWER FOR RANGE OF 20 - 25
        }

        else if (temperature < 20) {
            command = TemperatureCommand.HIGHER;
        }

        thermostat.receiveCommand(command);
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