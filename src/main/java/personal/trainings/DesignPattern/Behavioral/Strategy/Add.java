package personal.trainings.DesignPattern.Behavioral.Strategy;

public class Add implements Strategy{

    @Override
    public void operation(int num1, int num2) {
        System.out.println("result adding : " + (num1+num2));
    }
}
