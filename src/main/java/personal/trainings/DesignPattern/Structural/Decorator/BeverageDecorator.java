package personal.trainings.DesignPattern.Structural.Decorator;

public abstract class BeverageDecorator implements Beverage {

	protected Beverage beverage;
	
	public BeverageDecorator(Beverage beverage) {
		super();
		this.beverage = beverage;
	}

	@Override
	public int getCost() {
		return beverage.getCost();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription();
	}

}
