package personal.trainings.java8.Threads.collections;

import java.util.concurrent.Exchanger;

/**
 * With the help of exchanger two threads can exchange objects
 *
 * exchange() -> exchange is done using one of the two exchange methods
 * For example: generic algorithms, training neural networks
 */

class FirstThread implements Runnable{
	
	private Exchanger<Integer> exchanger;
	private int counter;
	
	public FirstThread(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		
		while(true) {
			counter = counter + 1;
			System.out.println("The counter was incremented : "+counter);
			try {
				counter = exchanger.exchange(counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

class SecondThread implements Runnable{
	
	private Exchanger<Integer> exchanger;
	private int counter;
	
	public SecondThread(Exchanger<Integer> exchanger) {
		this.exchanger = exchanger;
	}

	@Override
	public void run() {
		
		while(true) {
			counter =- 1;
			System.out.println("The counter was decremented : " + counter);
			try {
				counter = exchanger.exchange(counter);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

public class ExchangerTest {

	public static void main(String[] args) {
		
		Exchanger<Integer> exchanger = new Exchanger<Integer>();
		
		new Thread(new FirstThread(exchanger)).start();
		new Thread(new SecondThread(exchanger)).start();
		
	}
}
 