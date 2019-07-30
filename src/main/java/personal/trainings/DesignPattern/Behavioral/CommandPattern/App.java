package personal.trainings.DesignPattern.Behavioral.CommandPattern;

public class App {

    public static void main(String[] args){

        Switcher switcher = new Switcher();
        Light light = new Light();
        TurnOffCommand off = new TurnOffCommand(light);
        TurnOnCommand on = new TurnOnCommand(light);

        switcher.addCommand(on);
        switcher.addCommand(off);

        switcher.execute();
    }

}
