package Entity;

import Command.LightCommand;
import Interface.IActuator;
import Interface.ICommand;
import State.LightState;

public class LightBulb implements IActuator {

    private LightState currentLightState;

    public LightBulb(LightState lightState) {
        this.currentLightState = lightState;
    }

    public LightState getCurrentLightState() {
        return currentLightState;
    }

    @Override
    public void receiveCommand(ICommand command) {
        if (!(command instanceof LightCommand)){
            throw new IllegalArgumentException("Invalid command type");
        }
        if (command.equals(LightCommand.ON) && currentLightState.equals(LightState.OFF)){
            currentLightState = LightState.ON;
        }
        else if (command.equals(LightCommand.OFF) && currentLightState.equals(LightState.ON)){
            currentLightState = LightState.OFF;
        }
    }
}
