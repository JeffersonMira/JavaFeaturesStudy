package personal.trainings.java8.Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker{
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

    public void producer() throws InterruptedException {
    	lock.lock();
    	
    	//It needs to be in the try - finally to make sure that the unlock is called in some point. 
    	try {
			System.out.println("Producer here...");
			condition.await();
			System.out.println("Producer here again...");
		} finally {
			lock.unlock();
		}
    }

    public void consumer() throws InterruptedException {
    	lock.lock();
    	try {
    		Thread.sleep(2000);
			System.out.println("consumer here...");
			condition.signal(); // the same as notify
		} finally {
			lock.unlock();
		}
    }

}

public class ProducerConsumerLock {

    public static void main(String[] args){
    	
    	Worker worker = new Worker();
    	
        Thread t1 = new Thread(()->{
        	try {
				worker.producer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        });
        Thread t2 = new Thread(()->{
        	try {
				worker.consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("Finishing..");
    }
}
