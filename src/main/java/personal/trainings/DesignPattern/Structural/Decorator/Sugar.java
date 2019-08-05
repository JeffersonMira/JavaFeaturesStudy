package personal.trainings.DesignPattern.Structural.Decorator;

public class Sugar extends BeverageDecorator {

	private Beverage beverage;

	public Sugar(Beverage beverage) {
		super(beverage);
		this.beverage = beverage;
	}

	@Override
	public int getCost() {
		return beverage.getCost() + 2;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + "sugar ";
	}
	
	
}
