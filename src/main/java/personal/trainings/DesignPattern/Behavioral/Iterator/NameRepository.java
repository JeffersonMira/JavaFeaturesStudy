package personal.trainings.DesignPattern.Behavioral.Iterator;

public class NameRepository {

	private String[] names = {"Joe", "Adam","Tadeu", "Mario"};
	
	public Iterator getIterator() {
		return new NameIterator(names);
	}
}
