package personal.trainings.DesignPattern.Behavioral.Iterator;


/**
 * In this pattern you have the interface <code>Iterator</code> with two methods:
 * 	hasNext and next. This interface is implemented in some kind of list manager.
 * 	This 'List manager' is going to help you when dealing with lists.
 * 
 *  Personal Note - Not sure when to use it. Java has all the Collection package to 
 *  help dealing with all kind of lists. 
 */
public class App {

	public static void main(String[] args) {
		NameRepository repository = new NameRepository();
		
		for(Iterator it = repository.getIterator(); it.hasNext(); /*handled by Iterator*/) {
			System.out.println((String) it.next());
		}

	}

}
