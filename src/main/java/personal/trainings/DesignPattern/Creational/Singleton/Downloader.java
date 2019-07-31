package personal.trainings.DesignPattern.Creational.Singleton;


/**
 *  Simple implementation of Singleton is not thread-safe. 
 *  However if you use an ENUM it is going to be thread-safe.
 */
public class Downloader {
	
	//eager version (creates the instance in the creation of the class)
	//private static Downloader downloader = new Downloader();
	
	private static Downloader downloader;

	private  Downloader() {
		//no one is able to create a new instance
	}
	
	public static Downloader getInstance() {
	
		//Lazy version (Just creates the object when its needed)
		if(downloader == null) {
			downloader = new Downloader();
		}
		
		return downloader;
	}
	
	public void startDownload() {
		System.out.println("Starting downloading.... ");
	}
	
}
