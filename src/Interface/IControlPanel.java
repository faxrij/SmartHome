package Interface;

public interface IControlPanel {
    void setTemperature(int temperature);
    void turnLightOn();
    void turnLightOff();

    void lockDoors();
    void unlockDoors();
}
