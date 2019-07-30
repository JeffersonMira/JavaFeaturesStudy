package personal.trainings.DesignPattern.Behavioral.Template;

public abstract class Algorithm {

	public abstract void initialize();
	public abstract void sorting();
	public abstract void printResult();
	
	//Don't care the implementation
	public void sort() {
		initialize();
		sorting();
		printResult();
	}
}
