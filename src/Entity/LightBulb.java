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

    @Override
    public void receiveCommand(ICommand command) {
        if (command.getClass()!= LightCommand.class) {
            throw new RuntimeException();
        }
        if (currentLightState.name().equals(((LightCommand) command).name())){
            System.out.println("Wanted state is already on for LightBulb");
        }
        else if (command.equals(LightCommand.ON) && currentLightState.equals(LightState.OFF)){
            System.out.println("Turning lights ON");
            currentLightState = LightState.ON;
        }
        else if (command.equals(LightCommand.OFF) && currentLightState.equals(LightState.ON)){
            System.out.println("Turning lights OFF");
            currentLightState = LightState.OFF;
        }
    }
}
