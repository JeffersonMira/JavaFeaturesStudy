package personal.trainings.DesignPattern.Behavioral.Observable;

public interface Subject {

    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyAllObserver();
}
