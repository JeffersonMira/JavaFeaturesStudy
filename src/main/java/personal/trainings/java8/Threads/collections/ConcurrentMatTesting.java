package personal.trainings.java8.Threads.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class FirstWorker4 implements Runnable{

	ConcurrentMap<String, Integer> map;
	
	public FirstWorker4(ConcurrentMap<String, Integer> map) {
		this.map = map;
	}
	
	@Override
	public void run() {
		try {
			map.put("a", 1);
			map.put("c", 2);
			Thread.sleep(1000);
			map.put("b", 3);
			map.put("f", 4);
			Thread.sleep(1000);
			map.put("h", 5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class SecondWorker4 implements Runnable{

	ConcurrentMap<String, Integer> map;
	
	public SecondWorker4(ConcurrentMap<String, Integer> map) {
		this.map = map;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println(map.get("a"));
			System.out.println(map.get("c"));
			Thread.sleep(1000);
			System.out.println(map.get("z")); //it is going to return null 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class ConcurrentMatTesting {

	public static void main(String[] args) {
		ConcurrentMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		
		new Thread(new FirstWorker4(map)).start();
		new Thread(new SecondWorker4(map)).start();
		
		
		//You can also synchronize any collection using Collection.Synchronize...
		//However it makes the Collection much slower, so use it wisely 
		List<String> list = new ArrayList<String>();
		List<String> syncList = Collections.synchronizedList(list);
		
	}
}
