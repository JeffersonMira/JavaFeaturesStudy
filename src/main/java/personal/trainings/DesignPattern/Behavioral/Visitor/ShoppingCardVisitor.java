package personal.trainings.DesignPattern.Behavioral.Visitor;

public interface ShoppingCardVisitor {

	public double visit(Table item);
	public double visit(Chair item);

}
