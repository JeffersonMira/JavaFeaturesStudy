package personal.trainings.DesignPattern.Structural.Decorator;

public class PlainBeverage implements Beverage {

	@Override
	public int getCost() {
		return 5;
	}

	@Override
	public String getDescription() {
		return "Plain Beverage ";
	}
	
}
