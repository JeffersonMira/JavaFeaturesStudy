package personal.trainings.java8.Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTesting {
	
	/**
	 * 1.) ExecutorService es = Executors.newCachedThreadPool();
	 * 		- going to return an executorService that can dynamically reuse threads;
	 * 		- before start a job it is going to check whether there are any threads
	 * 			that finished the job.. reuse them
	 * 		- if there are no waiting threads it is going to create a new one;
	 * 		- good for processor... effective solution.
	 * 
	 * 2.) ExecutorService es = Executors.newFixedThreadPool(N);
	 * 		- Maximize the number of threads;
	 * 		- If we want to start a job and all the threads a busy, it is going to wait for one to terminate;
	 * 	
	 * 3.) ExecutorService es = Executors.newSingleThreadExecutor();
	 * 		- It is a single thread for the job. 
	 * 	
	 * 		executor() -> Runnable + Callable
	 * 		submit()   -> Runnable
	 * 
	 */
	public static void main(String[] args) {
		
		// Just 2 threads at time
		//ExecutorService es = Executors.newFixedThreadPool(2); 
		
		// Creates how many threads it needs - Seems the more useful. 
		// ExecutorService es = Executors.newCachedThreadPool();
		
		// Just a single thread.
		ExecutorService es = Executors.newSingleThreadExecutor();
		
		for(int i = 0; i < 5 ; i++) {
			
			es.submit(new Worker1());
		}
	}

}

class Worker1 implements Runnable{

	@Override
	public void run() {
		
		for(int i = 0; i < 10 ; i++) {
			System.out.println("Count - " + i);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}