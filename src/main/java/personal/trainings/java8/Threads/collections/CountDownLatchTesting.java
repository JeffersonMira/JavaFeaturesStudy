package personal.trainings.java8.Threads.collections;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This is used to synchronize one or more tasks to force them to to wait for the completion of a set of operations
 * 	being performed by other tasks;
 * 
 *  - You give an initial count to a CountDownLauch object, and any task that calls await() on that object will
 *  	block until the count reaches zero;
 *  
 * 	- Other tasks may call countDown() on the object to reduce the count, presumably when a task finishes its job.
 * 
 *  - A CountDownLauch --> the count cannot be reset! If you need a version that resets the count, you can use the 
 *  	CycleBarrier instead;
 *  
 *  - the tasks that call countDonw() are not blocked when they make that call;
 *  	only the call to await() is blocked until the count reaches zero. 
 *  
 *  A Typical use is to divide a problem into N independently solutions and create a CountDownLaunch with a value of N
 *  	when each task is finished it calls countDown() on the latch. Tasks waiting for the problem to be solved call await()
 *  		on the latch to hold themselves back until it is completed. 
 *  
 *   For example: you want a trigger something after 10 000 users download an image. 
 *
 */

public class CountDownLatchTesting {

	public static void main(String[] args) {
		ExecutorService es = Executors.newSingleThreadExecutor();
		CountDownLatch latch = new CountDownLatch(5);
		
		for(int i = 0; i<5; i++) {
			es.execute(new Worker2(i+1, latch));
		}
		
		try {
			// This await is necessary to make the current thread to await the completion of countDonw. 
			// Seems like a join with a controller number. 
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All the prerequisites are done....");
		es.shutdown();
		
	}
}

class Worker2 implements Runnable{
	
	private CountDownLatch latch;
	private int id;
	
	Worker2(int id, CountDownLatch latch){
		this.id = id;
		this.latch = latch;
	}

	@Override
	public void run() {
		doWork();
		latch.countDown();
	}

	private void doWork() {
		System.out.println("Thread with id =  "+ id + " started working...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
