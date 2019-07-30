package personal.trainings.java8.DesignPattern.Behavioral.Observable;

public interface Observer {
    public void update(int pressure, int temperature, int humidity);
}
