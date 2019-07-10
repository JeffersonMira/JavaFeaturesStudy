package personal.trainings.java8.Threads.MergeSort;

import java.util.Random;

public class ComparingSorts {

    public static void main(String[] args) throws Throwable {

        int numOfThreads  = Runtime.getRuntime().availableProcessors();

        System.out.println("Number of threads/cores: " + numOfThreads);
        System.out.println("");

        int[] numbers1 = createRandomArray(10000);
        int[] numbers2 = new int[numbers1.length];

        for(int i=0;i<numbers1.length;i++)
            numbers2[i] = numbers1[i];



        // run the algorithm and time how long it takes
        long startTime1 = System.currentTimeMillis();
        MergeSortParallel parallelSorter = new MergeSortParallel(numbers1);
        parallelSorter.mergeArray(numOfThreads);
        long endTime1 = System.currentTimeMillis();

        System.out.printf("Time taken for 10 000 000 elements parallel =>  %6d ms \n", endTime1 - startTime1);
        System.out.println("");

        startTime1 = System.currentTimeMillis();
        MergeSort sequentisalSorted = new MergeSort(numbers2);
        sequentisalSorted.mergeArray();
        endTime1 = System.currentTimeMillis();

        System.out.printf("Time taken for 10 000 000 elements sequential =>  %6d ms \n", endTime1 - startTime1);
        System.out.println("");

    }

    public static int[] createRandomArray(int n) {
        Random random = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(10000);
        }

        return a;
    }
}
