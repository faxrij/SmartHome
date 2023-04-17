package Entity;

import Interface.IControlPanel;
import Mediator.Mediator;

public class ControlPanel implements IControlPanel {

    private Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
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
}
