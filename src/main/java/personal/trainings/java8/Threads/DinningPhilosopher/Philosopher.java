package personal.trainings.java8.Threads.DinningPhilosopher;

import java.util.Random;

public class Philosopher implements Runnable{
	
	private int id;
	private Chopstick left;
	private Chopstick right;
	private Random randon;
	private int eatingCounter;
	private volatile boolean isFull = false;
	
	public Philosopher(int id, Chopstick left, Chopstick right) {
		super();
		this.id = id;
		this.left = left;
		this.right = right;
		this.randon = new Random();
	}
	
	@Override
	public void run() {


		try {
			while(!isFull) {

				think();
				
				if(left.pickUp(this, State.LEFT)) {
					if(right.pickUp(this, State.RIGHT)) {
						eat();
						right.putDown(this, State.RIGHT);
					}
					left.putDown(this, State.LEFT);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void eat() throws InterruptedException {
		System.out.println(this + " is eating...");
		this.eatingCounter++;
		Thread.sleep(randon.nextInt(1000));
	}

	private void think() throws InterruptedException {
		System.out.println(this + " is thinking....");
		Thread.sleep(randon.nextInt(1000));
	}

	public String toString() {
		return "Philosopher "+id;
	}
	
	public void setIsFull(boolean isFull) {
		this.isFull = isFull;
	}
	
	public int getCounter() {
		return this.eatingCounter;
	}

}
