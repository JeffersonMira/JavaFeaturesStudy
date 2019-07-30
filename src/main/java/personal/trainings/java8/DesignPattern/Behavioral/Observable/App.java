package personal.trainings.java8.DesignPattern.Behavioral.Observable;

/**
 * You create two interfaces:
 *  - Observer: the class that is going to do something each time something happens to the
 *                  subject. It will have the method update
 *  - Subject:  the classes that are going to be observed.
 *              It will have methods to addObserver, removeObserver and NotifyAll
 *
 *   Everytime that the concrete implementation of subject calls the 'notifyAll' of its list of
 *          observables (could be more than one) they are going to do some action.
 *          In this example here they just print the changes.
 */

public class App {
    public static void main(String[] args){
        WeatherStatition subject = new WeatherStatition();
        WeatherObserver observer = new WeatherObserver(subject);

        subject.setHumidity(100);
        subject.setPressure(100);
        subject.setTemperature(100);
    }
}
