package personal.trainings.java8.Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread02 {

    public static void main(String[] args){
        Executor e = Executors.newCachedThreadPool();
        e.execute(new Thread());
        ThreadPoolExecutor pool = (ThreadPoolExecutor) e;
        pool.shutdown();
    }

    static class Thread implements Runnable{
        @Override
        public void run() {
            try {
                Long duration  = (long) (Math.random() * 5);
                System.out.println("Running Thread");
                TimeUnit.SECONDS.sleep(duration);
                System.out.println("Thread Completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
