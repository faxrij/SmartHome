package MainFlow;

import Entity.ControlPanel;
import Entity.DoorLock;
import Entity.LightBulb;
import Entity.Thermostat;
import Mediator.Mediator;
import Sensor.LightSensor;
import Sensor.MotionSensor;
import Sensor.TemperatureSensor;
import State.DoorState;
import State.LightState;
import Interface.ISensor;

import java.util.Timer;
import java.util.TimerTask;

public class MainFlow {
    public void start() {

        Thermostat thermostat = new Thermostat();

        DoorLock doorLock = new DoorLock(DoorState.UNLOCKED);
        LightBulb lightBulb = new LightBulb(LightState.OFF);
        ControlPanel controlPanel = new ControlPanel();

        Mediator mediator = new Mediator(thermostat, doorLock, lightBulb, controlPanel);

        ISensor temperatureSensor = new TemperatureSensor(mediator);
        ISensor lightSensor = new LightSensor(mediator);
        ISensor motionSensor = new MotionSensor(mediator);

        Timer timer = new Timer();
        SensorTask sensorTask = new SensorTask(temperatureSensor, lightSensor, motionSensor, timer);
            timer.schedule(sensorTask, 0, 1000);
}

    static class SensorTask extends TimerTask {
        private final ISensor temperatureSensor;
        private final ISensor lightSensor;
        private final ISensor motionSensor;
        private final Timer timer;
        private int count;

        public SensorTask(ISensor temperatureSensor, ISensor lightSensor, ISensor motionSensor, Timer timer) {
            this.temperatureSensor = temperatureSensor;
            this.lightSensor = lightSensor;
            this.motionSensor = motionSensor;
            this.timer = timer;
        }

        public void run() {
            System.out.println("Run: " + (count+1));
            temperatureSensor.sendReading();
            lightSensor.sendReading();
            motionSensor.sendReading();

            System.out.println();

            count++;
            if (count >= 20) {
                timer.cancel();
                System.out.println("Timer stopped after 20 runs.");
            }
        }
    }
}
