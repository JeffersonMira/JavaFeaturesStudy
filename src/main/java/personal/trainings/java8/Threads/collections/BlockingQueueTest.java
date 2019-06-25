package personal.trainings.java8.Threads.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class FirstWorker implements Runnable{
	private BlockingQueue<Integer> blockingQueue;
	
	public FirstWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		int counter = 0;
		
		while(true) {
			try {
				blockingQueue.add(counter);
				System.out.println("Putting itens to the queue "+ counter);
				counter++;
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class SecondWorker implements Runnable{
	private BlockingQueue<Integer> blockingQueue;
	
	public SecondWorker(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		
		while(true) {
			try {
				int number = blockingQueue.take();
				System.out.println("Taking number from the thread "+ number);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class BlockingQueueTest {
	public static void main(String[] args) {
		
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
		
		FirstWorker firstWorker = new FirstWorker(blockingQueue);
		SecondWorker secondWorker = new SecondWorker(blockingQueue);
		
		new Thread(firstWorker).start();
		new Thread(secondWorker).start();
		
	}

}
