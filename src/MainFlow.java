import Entity.ControlPanel;
import Entity.DoorLock;
import Entity.LightBulb;
import Entity.Thermostat;
import Interface.ISensor;
import Mediator.Mediator;
import Sensor.LightSensor;
import Sensor.MotionSensor;
import Sensor.TemperatureSensor;
import State.DoorState;
import State.LightState;

import java.util.Timer;
import java.util.TimerTask;

public class MainFlow {
    public void start() {

    Thermostat thermostat = new Thermostat();

    DoorLock doorLock = new DoorLock(DoorState.UNLOCKED);
    LightBulb lightBulb = new LightBulb(LightState.OFF);

    Mediator mediator = new Mediator(thermostat, doorLock, lightBulb);

    ControlPanel controlPanel = new ControlPanel();
    controlPanel.setMediator(mediator);

    ISensor motionSensor = new MotionSensor(mediator);
    ISensor lightSensor = new LightSensor(mediator);
    ISensor temperatureSensor = new TemperatureSensor(mediator);

    Timer timer = new Timer();
    SensorTask sensorTask = new SensorTask(motionSensor, lightSensor, temperatureSensor, controlPanel, timer);
        timer.schedule(sensorTask, 0, 1000);
}

    static class SensorTask extends TimerTask {
        private final ISensor motionSensor;
        private final ISensor lightSensor;
        private final ISensor temperatureSensor;
        private final Timer timer;
        private final ControlPanel controlPanel;
        private int count;

        public SensorTask(ISensor motionSensor, ISensor lightSensor, ISensor temperatureSensor, ControlPanel controlPanel, Timer timer) {
            this.motionSensor = motionSensor;
            this.lightSensor = lightSensor;
            this.temperatureSensor = temperatureSensor;
            this.timer = timer;
            this.controlPanel = controlPanel;
        }

        public void run() {
            System.out.println("Run: " + (count+1));
//            motionSensor.sendReading();
//            lightSensor.sendReading();
            temperatureSensor.sendReading();
            controlPanel.chooseRandomEventForLight();
            controlPanel.chooseRandomEventForMotion();

            System.out.println();

            count++;
            if (count >= 20) {
                timer.cancel();
                System.out.println("Timer stopped after 20 runs.");
            }
        }
    }
}
