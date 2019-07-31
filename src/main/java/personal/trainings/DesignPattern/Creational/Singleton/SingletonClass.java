package personal.trainings.DesignPattern.Creational.Singleton;

/**
 * Using ENUM to create a singleton pattern. It is going to be thread-safe.
 * It is not needed to create any synchronization to make it thread-safe. 
 */
public enum SingletonClass {

	INSTANCE;
	
	private int counter;

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
}
