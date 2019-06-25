package personal.trainings.java8.Threads.collections;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Latch --> multiple threads can wait for each other 
 * 
 * A CyclicBarrier is used in situations where you want to create a group of tasks
 * to perform work in parallel + wait until they are all finished before moving on to the next step
 * 		-> something like join()
 * 		-> something like CountDownLatch()
 * 
 * 		CountDownLatch: one-shot event
 * 		CyclicBarrier: It can be used over and over again
 * 		
 * 		+cyclicBarrier has a barrier action: a runnable that will run automatically when the count reachs 0;
 * 
 * 	new CyclicBarrier(N) -> N Threads will wait for each other
 * 
 * 	WE CAN NOT REUSE LATCHES BUT WE CAN REUSE CyclicBarriers --> reset() !!
 *
 */

class Worker3 implements Runnable{
	private int id;
	private Random random;
	private CyclicBarrier barrier;

	public Worker3(int id, CyclicBarrier barrier){
		this.barrier = barrier;
		this.random = new Random();
		this.id = id;
	}

	public void run() {
		doWork();
	}

	private void doWork() {
		System.out.println("Thread with ID "+id+" starts the task...");

		try {
			Thread.sleep(random.nextInt(3000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Thread with ID "+id+" finishes the task...");

		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return ""+this.id;
	}

}

public class CyclicBarrierTest {

	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(5);
		CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("All the tasks are finished....")) ;
		
		for(int i = 0; i <5; i++) 
			es.execute(new Worker3(i+1, barrier));
		
		es.shutdown();
	}

}
