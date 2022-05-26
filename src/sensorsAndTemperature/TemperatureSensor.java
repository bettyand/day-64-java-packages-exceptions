package sensorsAndTemperature;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean on = false;

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void setOn() {
        this.on = true;        
    }

    @Override
    public void setOff() {
        this.on = false;
    }

    @Override
    public int read() {
        if (this.on == true) {
            return new Random().nextInt(61) - 30;
        } else {
            throw new IllegalStateException();
        }
    }
    
}
