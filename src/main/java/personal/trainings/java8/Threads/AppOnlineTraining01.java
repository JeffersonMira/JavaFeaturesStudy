package personal.trainings.java8.Threads;

class Runner1 implements Runnable{
    public void run(){
        try {
            for (int i=0; i<10; i++) {
                Thread.sleep(100);
                System.out.println("Runner 1 "+ i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Runner2 implements Runnable{
    public void run(){
        try {
             for (int i=0; i<10; i++) {
                 Thread.sleep(100);
                 System.out.println("Runner 2 "+ i);
             }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class AppOnlineTraining01{

    public static void main(String[] args){
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());

        t1.start();
        t2.start();

        try {
            //The join method means that the current thread will wait the 'joined' thread to 'die'
            //before resume application. In this case, the 'Finishing the tasks' will not be printed
            //while the threads are executing. It doest happens without the join. 
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finishing the tasks");
    }
}
