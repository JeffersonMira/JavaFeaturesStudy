package personal.trainings.DesignPattern.Behavioral.Iterator;

public class NameIterator implements Iterator {

	private String[] names;
	private int index;
	
	
	
	public NameIterator(String[] names) {
		super();
		this.names = names;
	}

	public boolean hasNext() {
		return index < names.length;
	}

	public Object next() {
		
		if(hasNext()) {
			return names[index++];
		}
		
		return null;
	}

}
