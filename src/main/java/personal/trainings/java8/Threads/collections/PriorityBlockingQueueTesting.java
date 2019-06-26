package personal.trainings.java8.Threads.collections;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * It implements the BlockingQueue interface
 *
 * - umbounded concurrent queue
 * - It uses the same ordering rules as the java.util.PriorityQueue -> have to implement the Comparable interface
 *      The comparable interface will define what will be the the order of the queue.
 *
 *      The priority can be the same as compare ==0 case
 *
 *  - no null items.
 */


/**
 * Add values to a blocking queue
 */
class FirstWorker01 implements Runnable{
    BlockingQueue<String> queue;

    public FirstWorker01(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.add("F");
            queue.add("J");
            queue.add("H");
            Thread.sleep(1000);
            queue.add("C");
            queue.add("A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//Remove values from a blocking queue
class SecondWorker01 implements Runnable{
    BlockingQueue<String> queue;

    public SecondWorker01(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
            Thread.sleep(1000);
            System.out.println(queue.take());
            System.out.println(queue.take());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class PriorityBlockingQueueTesting {

    public static void main(String[] args){
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread(new FirstWorker01(queue)).start();
        new Thread(new SecondWorker01(queue)).start();
    }
}
