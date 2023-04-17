package Entity;

import Interface.ISensor;
import Mediator.Mediator;

public class MotionSensor implements ISensor {
    private final Mediator mediator;

    public MotionSensor(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendReading() {
        mediator.readMotion();
    }
}
