package personal.trainings.java8.DesignPattern.Behavioral.CommandPattern;

public class TurnOnCommand  implements Command{

    private Light light;

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

}
