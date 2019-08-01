package personal.trainings.DesignPattern.Creational.Factory;

public class Algorithmfactory {

	public enum Alg{ SHORTEST, SPANNING }
	
	public static Algorithm createAlgorithm(Alg alg) {
		
		switch (alg) {
		case SHORTEST:
			return new ShortestPath();
		case SPANNING:
			return new SpanningTree();
		default:
			return null;
		}
		
	}
}
