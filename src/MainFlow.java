import Entity.DoorLock;
import Entity.LightBulb;
import Entity.Thermostat;
import Interface.ISensor;
import Mediator.Mediator;
import Sensor.LightSensor;
import Sensor.MotionSensor;
import Sensor.TemperatureSensor;

import java.util.Timer;
import java.util.TimerTask;

public class MainFlow {
    public void start() {
    Thermostat thermostat = new Thermostat();
    DoorLock doorLock = new DoorLock();
    LightBulb lightBulb = new LightBulb();
    Mediator mediator = new Mediator(thermostat, doorLock, lightBulb);

//        ControlPanel controlPanel = new ControlPanel();
//        controlPanel.setMediator(mediator);

    ISensor motionSensor = new MotionSensor(mediator);
    ISensor lightSensor = new LightSensor(mediator);
    ISensor temperatureSensor = new TemperatureSensor(mediator);

    Timer timer = new Timer();
    SensorTask sensorTask = new SensorTask(motionSensor, lightSensor, temperatureSensor, timer);
        timer.schedule(sensorTask, 0, 1000);
}

    static class SensorTask extends TimerTask {
        private final ISensor motionSensor;
        private final ISensor lightSensor;
        private final ISensor temperatureSensor;
        private final Timer timer;
        private int count;

        public SensorTask(ISensor motionSensor, ISensor lightSensor, ISensor temperatureSensor, Timer timer) {
            this.motionSensor = motionSensor;
            this.lightSensor = lightSensor;
            this.temperatureSensor = temperatureSensor;
            this.timer = timer;
        }

        public void run() {
            motionSensor.sendReading();
            lightSensor.sendReading();
            temperatureSensor.sendReading();

            count++;
            if (count >= 20) {
                timer.cancel();
                System.out.println("Timer stopped after 20 runs.");
            }
        }
    }
}
