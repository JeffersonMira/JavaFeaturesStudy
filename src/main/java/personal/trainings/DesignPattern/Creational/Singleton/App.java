package personal.trainings.DesignPattern.Creational.Singleton;

public class App {
	public static void main(String[] args) { 
		
		/*
		 * Not thread-safe without using synchronization blocks 
		 */
		Downloader d = Downloader.getInstance();
		d.startDownload();
		
		Downloader d2 = Downloader.getInstance();
		
		//it is going to enter here, as they are the same instance. 
		if(d == d2) {
			System.out.println("They are the same instance");
		}
		
		/*
		 * Already thread-safe
		 */
		SingletonClass s = SingletonClass.INSTANCE;
		
		s.setCounter(100);
		System.out.println("The counter is (using enums): "+s.getCounter());
		
	}
}
