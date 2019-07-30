package personal.trainings.DesignPattern.Behavioral.Strategy;

public class Manager  implements Strategy{
    private Strategy strategy;

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    //Just calling the concrete implementation
    public void operation(int num1, int num2) {
        strategy.operation(num1, num2);
    }
}
