package personal.trainings.java8.Threads;

import java.util.ArrayList;
import java.util.List;

class ExecutorLock{
    private final List<Integer> list = new ArrayList<>();
    private int value = 0;
    private final int TOP = 5;
    private final int BOTTON = 0;

    //This object is used to control the lock
    private final Object lock = new Object();

    public void producer() throws InterruptedException {

        //Instead of putting the lock in the method, which could make all the threads wait for it to be realleased,
        //it creates a synchronized block, which allows other methods to be executed while this block of code is locked.
        synchronized (lock){

            while(true){
                if(list.size() == TOP){
                    System.out.println("Waiting for consumer to remove...");

                    //The wait means: Another thread (in this case, the consumer) can take the lock and start working. I'll wait the execution.
                    lock.wait();
                }else{
                    System.out.println("Adding value to the list : " + value);
                    list.add(value);
                    ++value;

                    //Notify the other thread that the job was done. It is not going to release the lock until all the code
                    //is executed or it finds a method 'wait'.
                    lock.notify();
                }
                Thread.sleep(500);
            }

        }

    }

    public void consumer() throws InterruptedException {
        synchronized (lock){

            while(true){
                if(list.size() == BOTTON){
                    System.out.println("Waiting for producer to add...");
                    lock.wait();
                }else{
                    System.out.println("Removing value to the list : " + list.remove(--value));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

}

public class ProducerConsumerLock {

    public static void main(String[] args){

        Executor e = new Executor();

        Thread t1 = new Thread(()->{
            try {
                e.producer();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                e.consumer();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        try {
            //The main thread is going to wait these threads to finish before resume the execution. 
            t1.join();
            t2.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("Finishing..");
    }
}
