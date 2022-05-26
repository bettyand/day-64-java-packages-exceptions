package sensorsAndTemperature;

public class StandardSensor implements Sensor {
    private int sensor;
    private boolean on;

    public StandardSensor(int sensor) {
        this.sensor = sensor;
        this.on = true;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void setOn() {
        return;
    }

    @Override
    public void setOff() {
        return;
    }

    @Override
    public int read() {
        if (this.on == false) {
            throw new IllegalStateException();
        }
        return this.sensor;
    }
    
}
