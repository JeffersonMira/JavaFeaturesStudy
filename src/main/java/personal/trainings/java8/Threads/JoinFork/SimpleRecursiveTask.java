package personal.trainings.java8.Threads.JoinFork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {

    public static void main(String[] args){
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveTask task1 = new SimpleRecursiveTask(250);
        System.out.println(pool.invoke(task1));
    }


    public int simulatedWork;

    public SimpleRecursiveTask(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected Integer compute() {

        if(simulatedWork> 100){
            System.out.println("Parallel needed..");
            SimpleRecursiveTask task1 = new SimpleRecursiveTask(simulatedWork/2);
            SimpleRecursiveTask task2 = new SimpleRecursiveTask(simulatedWork/2);

            //Basically it is the same as the start() method of a given thread.
            task1.fork();
            task2.fork();

            int solution = 0;
            //need to join as it is going to perform some calculation..
            solution += task1.join();
            solution += task2.join();

            return solution;
        }else{
            System.out.println("No need for parallel computing.. ");
            return 2*simulatedWork;
        }
    }

}
