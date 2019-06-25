package personal.trainings.java8.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ProcessorCallable implements Callable<String>{

	private int id;
	
	public ProcessorCallable(int id) {
		this.id = id;
	}
	
	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		return "ID - " + id;
	}
	
}

public class CallableAndFutureTraining {
	
	public static void main(String[] args) {
		
		// Executing 2 threads each time. 
		ExecutorService es = Executors.newFixedThreadPool(2);
		List<Future<String>> returnFromCallable = new ArrayList<Future<String>>();
		
		for(int i = 0; i < 10; i++) {
			Future<String> future = es.submit(new ProcessorCallable(i+1));
			returnFromCallable.add(future);
		}
		
		//Using the Java8 foreach from Iterable. It receives a future and then 'get'
		//the returned value, which is in this case, a String
		returnFromCallable.forEach((f) ->{
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		
		//Waits all the thrads to finish before shutdown.
		es.shutdown();
	}
}
