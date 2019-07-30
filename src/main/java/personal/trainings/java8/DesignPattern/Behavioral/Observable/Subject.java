package personal.trainings.java8.DesignPattern.Behavioral.Observable;

public interface Subject {

    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyAllObserver();
}
