package personal.trainings.DesignPattern.Behavioral.Template;


/**
 *  Very similar to Strategy, however you dont have a manager.
 *
 */
public class App {

	public static void main(String[] args) {

		int[] numbers = {1,5,3,8,2,-2,10};
		
		Algorithm sortAlgorithm = new InsertionSort(numbers);
		
		sortAlgorithm.sort();
	}

}
