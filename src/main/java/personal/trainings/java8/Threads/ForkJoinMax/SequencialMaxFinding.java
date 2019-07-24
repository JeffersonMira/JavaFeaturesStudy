package personal.trainings.java8.Threads.ForkJoinMax;

public class SequencialMaxFinding {

    // O(N) -> typical  linear running time algorithm
    public int maxFindng(int[] num, int highIndex){

        int max = num[0];

        for(int i =0; i<highIndex;i++){
            if(num[i] > max)
                max = num[i];
        }

        return max;
    }
}
