package personal.trainings.DesignPattern.Behavioral.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * <cote>What the Visitor pattern actually does is create an external class 
 * that uses data in the other classes. 
 * If you need to perform operations across a dispate set of objects, 
 * Visitor might be the pattern for you. </cote>
 * 
 * TODO check this guy in the book Use a Cabeça
 */
public class App {
	public static void main(String[] args) { 
		List<ShoppingItem> items = new ArrayList<ShoppingItem>();
		items.add(new Chair("chair 1", 50));
		items.add(new Table("table 1", 1050));
		items.add(new Table("table 2", 50));
		
		double sum = 0;
		ShoppingCard card = new ShoppingCard();
		
		for (ShoppingItem shoppingItem : items) {
			sum = sum + shoppingItem.accept(card);
		}
		
		System.out.println("The sum is this: " + sum);
		
	}
}
