package personal.trainings.java8.DesignPattern.Behavioral.Observable;

import java.util.ArrayList;
import java.util.List;

public class WeatherStatition implements Subject {

    private int pressure;
    private int temperature;
    private int humidity;
    private List<Observer> observerList;

    public WeatherStatition() {
        observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observerList.remove(o);
    }

    @Override
    public void notifyAllObserver() {
        observerList.forEach(o -> o.update(pressure, temperature, humidity));
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
        notifyAllObserver();
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyAllObserver();
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        notifyAllObserver();
    }
}
