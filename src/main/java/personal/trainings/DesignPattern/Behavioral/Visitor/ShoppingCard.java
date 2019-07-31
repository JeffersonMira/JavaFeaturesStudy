package personal.trainings.DesignPattern.Behavioral.Visitor;

public class ShoppingCard implements ShoppingCardVisitor {

	public double visit(Table item) {
		return item.getPrice();
	}

	public double visit(Chair item) {
		return item.getPrice();
	}

}
