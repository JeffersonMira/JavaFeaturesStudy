package personal.trainings.java8.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * semaphore maintains a set of permits
 * acquire() -> if a permit is available then takes it;
 * releases() -> adds a permit.
 * 
 *  semaphore just keeps a count of the number available
 *  new semaphore(int permits, boolean fair) !!
 *
 */

//Using enum to create a singleton. 
enum Download{
	INSTANCE;
	
	// It is going to execute just 3 threads in the same time. 
	private Semaphore s = new Semaphore(3, true);
	
	public void downloadData() {
		
		try {
			s.acquire();
			download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			s.release();
		}
		
	}

	private void download() {
		
		System.out.println("Downloading data from web...");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class SemaphoreTesting {
	public static void main(String[] args) {

		ExecutorService es = Executors.newCachedThreadPool();
		
		// You will see 3 threads executing 4 times. 
		for(int i = 0; i < 12 ; i++) {
			//execute() receives a Runnable implementation. I'm using lambda to create an 
			//anonimous implementation of it, passing just the implementation of 'run()'. 
			es.execute( () -> Download.INSTANCE.downloadData() );
		}
	}
}
