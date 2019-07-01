package personal.trainings.java8.Threads.StudEntLibrary;

import java.util.Random;

public class Student implements Runnable{
	public int id;
	public Book[] books;
	
	public Student(int id, Book[] books) {
		super();
		this.id = id;
		this.books = books;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		
		while(true) {
			int book = random.nextInt(Constants.NUMBER_OF_BOOKS);
			
			try {
				books[book].read(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString() {
		return "Student #"+id;
	}

}
