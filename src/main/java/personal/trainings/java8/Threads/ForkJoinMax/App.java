package personal.trainings.java8.Threads.ForkJoinMax;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {

    public static int TREASHOLD = 0;

    public static void main(String[] args){
        int[] nums = initializeNums();

        //basically it will divide the number of items in the array by the number of
        //possible threads to be run parallel.
        TREASHOLD = nums.length / Runtime.getRuntime().availableProcessors();

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ParallelMaxFinding maxFinding = new ParallelMaxFinding(nums, 0, nums.length);

        System.out.println("Max: "+pool.invoke(maxFinding));
    }

    private static int[] initializeNums() {
        Random random = new Random();

        int[] nums = new int[10000];
        for(int i=0; i<10000; i++){
            nums[i] = random.nextInt(1000);
        }

        return nums;

    }
}
