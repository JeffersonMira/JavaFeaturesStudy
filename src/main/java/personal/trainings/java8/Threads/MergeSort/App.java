package personal.trainings.java8.Threads.MergeSort;

import java.util.Random;

public class App {

	public static void main(String[] args) {

		Random randon = new Random();
		
		int[] nums = new int[30];
		for(int i =0; i < nums.length; i++)
			nums[i] = randon.nextInt(100) - 500;
		
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// complexity: O(n logn)
		MergeSort mergeSort = new MergeSort(nums);
		mergeSort.mergeArray();
		mergeSort.showResults();
	}

}
