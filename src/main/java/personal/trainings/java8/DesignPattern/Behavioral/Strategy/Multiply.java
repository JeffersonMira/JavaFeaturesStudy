package personal.trainings.java8.DesignPattern.Behavioral.Strategy;

public class Multiply implements Strategy{
    @Override
    public void operation(int num1, int num2) {
        System.out.println("Multiplication : "+(num1*num2));
    }
}
