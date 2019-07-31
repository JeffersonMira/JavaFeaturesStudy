package personal.trainings.DesignPattern.Behavioral.Visitor;

public interface ShoppingItem {
	public double accept(ShoppingCardVisitor visitor);
}
