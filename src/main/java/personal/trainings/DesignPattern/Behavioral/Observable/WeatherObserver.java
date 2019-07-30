package personal.trainings.DesignPattern.Behavioral.Observable;

import java.util.List;

public class WeatherObserver implements Observer {

    private int pressure;
    private int temperature;
    private int humidity;
    private Subject subject;

    public WeatherObserver(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    @Override
    public void update(int pressure, int temperature, int humidity) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.humidity = humidity;

        showDate();
    }

    private void showDate() {
        System.out.println("---- Weather has Changed ----");
        System.out.println("Pressure : " + this.pressure);
        System.out.println("Temperature : " + this.temperature);
        System.out.println("Humidity : " + this.humidity);
    }
}
