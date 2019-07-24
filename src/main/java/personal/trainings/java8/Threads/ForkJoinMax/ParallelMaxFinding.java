package personal.trainings.java8.Threads.ForkJoinMax;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFinding extends RecursiveTask<Integer> {

    private int[] nums;
    private int lowIndex;
    private int highIndex;

    public ParallelMaxFinding(int[] nums, int lowIndex, int highIndex) {
        this.nums = nums;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    @Override
    protected Integer compute() {
        if(highIndex - lowIndex < App.TREASHOLD){
            return requencialMaxFinding();
        }else{
            int middleIndex = (highIndex + lowIndex) / 2;

            ParallelMaxFinding task1 = new ParallelMaxFinding(nums, lowIndex, middleIndex);
            ParallelMaxFinding task2 = new ParallelMaxFinding(nums, middleIndex+1, highIndex);

            //method inherited from RecursiveTask
            invokeAll(task1, task2);

            //returning the higher value from those two tasks created
            return Math.max(task1.join(), task2.join());
        }

    }

    // O(N) -> typical  linear running time algorithm
    public int requencialMaxFinding(){

        int max = nums[lowIndex];

        for(int i  =lowIndex+1; i < highIndex;i++){
            if(nums[i] > max)
                max = nums[i];
        }

        return max;
    }
}
