package personal.trainings.java17;

/**
 * https://medium.com/javarevisited/java-17-vs-java-11-exploring-the-latest-features-and-improvements-6d13290e4e1a
 */
public class Tests {

    public static void main(String[] args) {
        textBlockExample();
        improvedSwitchExample(Fruit.APPLE);
        exampleRecord();
        examplePatchMatchingInstanceOf();
    }

    private static void textBlockExample() {
        String sql = """
                SELECT id, firstName, lastName\s\
                FROM Employee
                WHERE departmentId = "IT" \
                ORDER BY lastName, firstName""";
        System.out.println(sql);
    }

    /**
     * Switch Expressions will allow you to return values from the switch case and use these return values in assignments, etc.
     * Java allows use of operator ->(arrow) instead of : (colon) to denote the return expression. break keyword will not be needed when
     * returning using switch in this expression, but default case is required.
     * In case of multiple operations done inside a switch case, we can have a case block and denote the return value using the yield keyword.
     * yield here is a context dependent keyword i.e. you can have a variable name yield somewhere else inside the function.
     * @param fruit
     */
    private static void improvedSwitchExample(Fruit fruit) {
        String text = switch (fruit) {
            case APPLE, PEAR -> {
                System.out.println("the given fruit was: " + fruit);
                yield "Common fruit";
            }
            case ORANGE, AVOCADO -> "Exotic fruit";
            default -> "Undefined fruit";
        };

        System.out.println(text);
    }


    public static void exampleRecord() {
        /**
         * The following code will replace an entire class, just like can be done for kotlin:
         * public class Fruit {
         *     private String name;
         *     private int price;
         *     //getters, setters, equals and hashcode methods
         * }
         */
        record Fruit(String name, int price) {}

        Fruit fruit = new Fruit("Apple", 100);
        System.out.println(fruit.price());
    }

    public static void examplePatchMatchingInstanceOf(){
        record Fruit(String name, int price) {}
        Object o = new Fruit("grape", 2);

        //JAVA 11 Implementation
        if(o instanceof Fruit){
            Fruit f = (Fruit) o; // cast is needed
            System.out.println("The price of "+f.name()+" is "+f.price());
        }

        //Java 17
        if(o instanceof Fruit fruit){ // no cast is needed, however any other condition has to use an && and not ||
            System.out.println("The price of "+fruit.name()+" is "+fruit.price());
        }

    }

}

enum Fruit{
    APPLE, PEAR, ORANGE, AVOCADO
}


