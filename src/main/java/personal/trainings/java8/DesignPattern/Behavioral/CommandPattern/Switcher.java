package personal.trainings.java8.DesignPattern.Behavioral.CommandPattern;

import java.util.ArrayList;
import java.util.List;

// invoker - class that control the actions and commands
// however the invoker knows nothing about the concrete implementation.
// so there is no strong relationship between the invoker and the commands
public class Switcher {

    public List<Command> commands;

    public Switcher() {
        commands = new ArrayList<>();
    }

    public void addCommand(Command command){
        this.commands.add(command);
    }

    public void execute(){
        commands.forEach(c -> c.execute());
    }
}
