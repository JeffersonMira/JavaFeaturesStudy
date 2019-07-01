package personal.trainings.java8.Threads.StudEntLibrary;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

	private int id;
	private Lock lock;
	
	public Book(int id) {
		this.id = id;
		lock = new ReentrantLock();
	}
	
	public void read(Student student) throws InterruptedException {
		// This guy would need to use an if statement
		 lock.tryLock(1000, TimeUnit.MILLISECONDS); 
		
//		lock.lock();
		System.out.println(student + " starts reading " + this);
		Thread.sleep(2000);
		lock.unlock();
		System.out.println(student + " has finished reading " + this);
	}
	
	@Override
	public String toString() {
		return "Book #"+id;
	}
}
