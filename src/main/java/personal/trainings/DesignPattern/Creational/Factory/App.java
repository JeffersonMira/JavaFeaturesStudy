package personal.trainings.DesignPattern.Creational.Factory;

import personal.trainings.DesignPattern.Creational.Factory.Algorithmfactory.Alg;

/**
 * The creation of the class is done by the factory, 
 * which uses some kind of logic to do it. In this case
 * I'm using some int values. It could be some enum...
 *
 */
public class App {
	public static void main(String[] args) {
		
		Algorithm alg = Algorithmfactory.createAlgorithm(Alg.SHORTEST);
		alg.solve();
	}
}
