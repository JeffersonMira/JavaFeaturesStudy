package personal.trainings.java8.Threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class TestForkJoin {
    public static void main(String[] varargs){
        ForkJoinPool commonPool = ForkJoinPool.commonPool();

    }
}

class CustomRecursiveAction extends RecursiveAction{

    @Override
    protected void compute() {

    }
}
