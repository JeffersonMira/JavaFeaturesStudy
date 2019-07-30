package personal.trainings.DesignPattern.Behavioral.Strategy;

/**
 * Basically you create an interface that is going to be used as base for the
 * action you want. This action can change depending on some logic, so you
 * create concrete implementation for that interface, and uses a 'MAnager' to control that.
 */
public class App {

    public static void main(String[] args){
        Manager m = new Manager();

        //Will execute the add, so you can control the implementation that is going to be used
        //without changing the concrete implementation of the operation
        m.setStrategy(new Add());
        m.operation(1,2);
    }

}
