package personal.trainings.java8.Threads.DinningPhilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

	private int id;
	private Lock lock;
	
	public Chopstick(int id) {
		super();
		this.id = id;
		this.lock = new ReentrantLock();
	}
	
	public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException {
		if(lock.tryLock(10, TimeUnit.MILLISECONDS)) {
			System.out.println(philosopher + " picked up "+state+" "+this);
			return true;
		}
		return false; 
	}
	
	public void putDown(Philosopher philosopher, State state) {
		lock.unlock();
		System.out.println(philosopher + " put up "+state+" "+this);
	}
	
	@Override
	public String toString() {
		return "ChopStick "+ id;
	}
	
}
