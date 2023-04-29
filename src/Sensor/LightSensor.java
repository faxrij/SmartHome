package Sensor;

import Interface.ISensor;
import Mediator.Mediator;
import State.LightState;


public class LightSensor implements ISensor {
    private final Mediator mediator;

    public LightSensor(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendReading() {
        LightState currentLightState = mediator.getLightState();
        mediator.getRandomAndChangeLightState();
        LightState newLightState = mediator.getLightState();

        if (currentLightState.name().equals(newLightState.name())){
            System.out.println("Wanted state is already on for LightBulb");
        }
        else if (newLightState.equals(LightState.OFF)){
            System.out.println("Turning lights ON");
        }
        else if (newLightState.equals(LightState.ON)){
            System.out.println("Turning lights OFF");
        }
    }
}
