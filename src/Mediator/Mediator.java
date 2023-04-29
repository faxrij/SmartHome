package Mediator;

import Entity.ControlPanel;
import Entity.DoorLock;
import Entity.LightBulb;
import Entity.Thermostat;
import Interface.ICommand;
import State.DoorState;
import State.LightState;

import java.util.Random;

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

    public int generateRandomTemperature(){
        Random rand = new Random();
        return rand.nextInt(45);
    }

    public void checkTemperature(int temperature) {
        ICommand command = controlPanel.checkTemperature(temperature);
        thermostat.setCurrentTemperature(temperature);
        thermostat.receiveCommand(command);
    }

    public int readNewTemperature() {
        return thermostat.getCurrentTemperature();

    }

    public void getRandomAndChangeLightState(){
        ICommand command = controlPanel.chooseRandomCommandForLight();
        lightBulb.receiveCommand(command);
    }

    public LightState getLightState() {
        return lightBulb.getCurrentLightState();
    }

    public void getRandomAndChangeDoorState() {
        ICommand command = controlPanel.chooseRandomCommandForMotion();
        doorLock.receiveCommand(command);
    }

    public DoorState getDoorState() {
        return doorLock.getCurrentDoorState();
    }
}