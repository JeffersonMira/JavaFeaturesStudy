package personal.trainings.DesignPattern.Structural.Facade;

public class SortingManager {

	private Algorithm bubble;
	private Algorithm merge;
	private Algorithm quick;
	
	public SortingManager() {
		this.bubble = new BubbleSort();
		this.merge = new MergeSort();
		this.quick = new QuickSort();
	}
	
	public void doBubbleSort() {
		bubble.sort();
	}
	
	public void doMergeSort() {
		merge.sort();
	}
	
	public void doQuickSort() {
		quick.sort();
	}
	
}
