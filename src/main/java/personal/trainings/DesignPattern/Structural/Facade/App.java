package personal.trainings.DesignPattern.Structural.Facade;

/**
 *	This pattern is very similar to Factory, but instead the manager return an instance of the method you want,
 *		the manager do the call of the method for your, holding all the instances of the implementations. 
 * 	This way you dont have to worry about the instantiation however you dont have control over the object, as the
 * 		manager do it for you.
 * 
 * Also it is different from the Strategy pattern as you dont have to pass the instance to the manager. You just call the 
 * 	method with the right implementation you want.
 */

public class App {
	public static void main(String[] args) {
		
		SortingManager manager = new SortingManager();
		
		manager.doBubbleSort();
		manager.doMergeSort();
		manager.doQuickSort();
		
	}
}
