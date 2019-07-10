package personal.trainings.java8.Threads.JoinFork;


import java.util.concurrent.ForkJoinPool;

public class App {

    /**
     * fork()- Asynchronously execute the task in the pool
     *          We call this in RecursiveAction and RecursiveTask<T>
     *
     * join()- Returns the result of the computation when it's done
     *
     * invoke()- execute the given task + return its result upon completion
     */

    public static void main(String[] args){

        //this will create the same number of threads as there are processors available.
        //if not doing that it is not going to be parallel.
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        SimpleRecursiveAction action = new SimpleRecursiveAction(120);
        pool.invoke(action);
    }
}
