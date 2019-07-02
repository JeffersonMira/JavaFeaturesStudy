package personal.trainings.java8.Threads.MergeSort;

public class MergeSort {

	private int[] num;
	private int[] tempNum;
	
	public MergeSort(int[] num) {
		this.num = num;
		tempNum = new int[num.length];
	}
	
	public void mergeArray() {
		this.mergeSort(0, num.length-1);
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
