package personal.trainings.java8.Threads.MergeSort;

public class MergeSortParallel {

	private int[] num;
	private int[] tempNum;
	
	public MergeSortParallel(int[] num) {
		this.num = num;
		tempNum = new int[num.length];
	}

	public void mergeArray(int numberOfThreads) {
		this.mergeSortParallel(0, num.length-1, numberOfThreads);
	}

	public Thread mergeSortParallel(int low, int high, int numberOfThreads) {
		
		//Creating the first thread for the sorting
		return new Thread( () -> parallelMergeSort(low, high, numberOfThreads/2) );
	}
	
	private void parallelMergeSort(int low, int high, int numberOfThreads) {
		
		if(numberOfThreads <= 1) {
			this.mergeSort(low, high);
			return;
		}
		
		int middleIndex = (low + high ) / 2;
		
		//Split and conquer!!
		Thread leftSort = mergeSortParallel(low, middleIndex, numberOfThreads);
		Thread righSort = mergeSortParallel(middleIndex+1, high, numberOfThreads);
		
		leftSort.start();
		righSort.start();
		
		
		//Making the current thread wait until the lower threads finish the sorting
		try {
			leftSort.join();
			righSort.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//the same process as the sequencial
		merge(low, middleIndex, high);
	}


	private void mergeSort(int low, int high) {
		
		if(low >= high)
			return;
		
		int middle = (low + high) / 2;
					
		mergeSort(low, middle);
		mergeSort(middle+1, high);
		
		merge(low, middle, high);
	}
	
	private void merge(int low, int middle, int high) {
		
		
		/** 
		 * 1) Creating a temp array with the same values. 
		 * It is going to be used to compare the values 
		 * and then assigning it to the original array;
		 */
		for(int i = low; i <= high; i++) {
			tempNum[i] = num[i];
		}
		
		int i = low;         // index for the left sub array
		int j = middle + 1;  // index for the right sub array
		int k = low;         // index for the ordered array
		
		
		/** 
		 * 2) Now it is necessary to copy the smallest value from either left of
		 * right back to the original array. Basically this is the place where 
		 * the actual sort is done
		 */
		while((i <= middle) && (j <= high)) {
			if(tempNum[i] <= tempNum[j]) {
				num[k] = tempNum[i];
				i++;
			}else {
				num[k] = tempNum[j];
				j++;
			}
			k++;
		}
		
		/** 
		 * 3) In some cases there are values left of the right or left sub array. 
		 * As the sub array is already ordered by previous iteration, there is no 
		 * need to compare the values anymore. So it needs just to copy the values. 
		 */
		//coping the last items from left to the ordered array
		while(i <= middle) {
			num[k] = tempNum[i];
			k++; i++;
		}
		
		//coping the last items from right to the ordered array
		while(j <= high) {
			num[k] = tempNum[j];
			k++; j++;
		}
	}
	
	public void showResults() {
		for (int i : num) {
			System.out.print(i + " ");
		}
	}
}
