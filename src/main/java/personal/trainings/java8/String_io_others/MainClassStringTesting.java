package personal.trainings.java8.String_io_others;

import java.util.StringJoiner;

/**
 * Created by e068582 on 10/8/2018.
 */
public class MainClassStringTesting {

    public static void main(String[] args){
        //It is replacing the string builder and the concatenating - much better way of using it.
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("1").add("2").add("3");

        System.out.println(joiner.toString()); // prints 1, 2, 3


        //IT is also possible to do it in the String class, using the new method join
        String testing = String.join(", ", "one", "two", "three");
        System.out.println();
    }
}
