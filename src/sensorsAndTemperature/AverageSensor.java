package sensorsAndTemperature;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors = new ArrayList<>();
    private boolean on;
    private List<Integer> readings = new ArrayList<>();

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return this.readings;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }

    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            if (sensor.isOn() == false) {
                sensor.setOn();
            }
            this.on = true;
        }
    }

    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            if (sensor.isOn() == false) {
                this.on = false;
            } else {
                this.on = true;
            }
        }
    }

    @Override
    public int read() {
        if (this.on == false || this.sensors.size() < 1) {
            throw new IllegalStateException();
        } else {
            double average = sensors.stream()
            .mapToInt(s -> s.read())
            .average()
            .getAsDouble();

            this.readings.add((int)average);
            return (int)average;
        }
    }
    
}
