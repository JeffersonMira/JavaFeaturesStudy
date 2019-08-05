package personal.trainings.DesignPattern.Structural.Decorator;


/**
 * 	<bold>It attaches additional responsibilities to an object dynamically<bold>
 * 	
 *  In this pattern, you create an interface with the basic methods (in this case the Beverage)
 *  Then you have to create a Decorator class, that is abstract and have the call of the Interface, and the constructor that 
 *  	receives a Beverage, in order to 'force' it in all the Decorator classes;
 *  After that you create all the classes needed that are part of the 'all', all of them extending the decorator abstract class,
 *  	receiving the interface as constructor too and overriding the methods adding its values;
 *  The last part is the 'Plain' value, which is the first call in the chain. It doesn't receives anything in the constructor.
 *  
 *  With all this structure you can have classes that can be added in each other (like adding sugar to milk), building a bigger
 *  	structure. 
 *
 *
 */
public class App {
	public static void main(String[] args) {
		
		Beverage b = new Sugar(new Sugar(new Milk(new PlainBeverage())));
		
		System.out.println("Cost: "+b.getCost()+"$");
		System.out.println("Description: "+b.getDescription());
	}
}
