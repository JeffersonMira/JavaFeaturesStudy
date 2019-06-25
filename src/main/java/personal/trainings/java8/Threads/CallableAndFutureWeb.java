package personal.trainings.java8.Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//Study was based on the following tutorial:
//https://www.baeldung.com/java-executor-service-tutorial
public class CallableAndFutureWeb {

    static int cont = 0;
    public static void main(String[] args){

    }

    public static void testScheduledExecutorService(){
        //Runnable but ussing lambda.
        Runnable runnable = () ->{
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        //Creating the Callable. It is basically the same as the Runnable, however it can have a return
        //and also can return a checked exception.
        Callable<String> callable = ()->{
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task "+(cont++)+" execution!!!";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callable);
        callableTasks.add(callable);
        callableTasks.add(callable);
        callableTasks.add(callable);

        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor();

        //Creating the scheduled task to be executed in the specific time
        scheduledExecutorService.schedule(callable, 1, TimeUnit.SECONDS);

        //This one will execute the task every 450 milliseconds
        scheduledExecutorService.scheduleAtFixedRate(runnable, 100, 450, TimeUnit.MILLISECONDS);

    }

    public static void testExecutorService(){

        /*-----------------------*/
        /* CREATING THE EXECUTOR */
        /*-----------------------*/

        //Creating the guys that is going to execute the tasks. Basically it is
        //the same as threads.
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        /*------------------------------------*/
        /* CREATING THE TASKS - THE RUNNABLES */
        /*------------------------------------*/

        //Runnable but ussing lambda.
        Runnable runnable = () ->{
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        //Creating the Callable. It is basically the same as the Runnable, however it can have a return
        //and also can return a checked exception.
        Callable<String> callable = ()->{
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task "+(cont++)+" execution!!!";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callable);
        callableTasks.add(callable);
        callableTasks.add(callable);
        callableTasks.add(callable);

        /*---------------------*/
        /* EXECUTING THE TASKS */
        /*---------------------*/

        //The execute is the same as the method java Start. It doest return anything.
        executorService.execute(runnable);

        //The submit can execute a Runnable or a Callable and it returns a Future object.
        try{
            Future<String> future =  executorService.submit(callable);
            System.out.println("Submit : " + future.get());
            boolean canceled = future.cancel(true);
            boolean isCanceled = future.isCancelled();
        }catch(InterruptedException | ExecutionException e ){
            e.printStackTrace();
        }

        //this guy executes one by one, however returns the result of just one task
        // if there is any successfully executed.
        try{
            String result = executorService.invokeAny(callableTasks);
            System.out.println("InvokeAny : " + result);
        }catch(InterruptedException | ExecutionException e ){
            e.printStackTrace();
        }

        //this guy returns the result of all the threads executed.
        try {
            List<Future<String>> futures = executorService.invokeAll(callableTasks);

            futures.forEach((f) -> {
                try {
                    System.out.println("invokeAll : " + f.get());

                    //It is also possible to define the timeout of waiting process.
                    //After that, even if the thread didn't finish yet, the timeout exception will be thrown
                    String result = f.get(200, TimeUnit.MILLISECONDS);
                }catch(InterruptedException | ExecutionException | TimeoutException e ){
                    e.printStackTrace();
                }
            });

        }catch(InterruptedException e ){
            e.printStackTrace();
        }

        //This guy is needed in order to close the program and not keeping it running.
        executorService.shutdown();
    }
}
