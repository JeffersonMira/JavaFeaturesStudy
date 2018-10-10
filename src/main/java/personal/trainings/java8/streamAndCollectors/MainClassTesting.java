package personal.trainings.java8.streamAndCollectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by e068582 on 4/12/2018.
 */

// TODO check streams and predicates
public class MainClassTesting {

    //WHAT IS A STREAM :
    // 1) a typed interface
    // 2) can process data in parallel
    // 3) An object on which one can define operations
    // 4) does not hold any data
    // 5) should not change the data in processes
    // WHY CANT A COLLECTION BE A STREAM? To avoid retrocompatibility with Collection API

    //WHAT DO i HAVE IN THIS NEW STREAM
    //simple answer : the filtered data (not - it doesnt have any data)
    //right answer is : nothing.
    public static void main(String[] args){

            reductionTesting();

    }

    public void testning(){
        List<Person> list = Arrays.asList(new Person(10), new Person(30), new Person(20));

        //Filtering the list based on some criteria
        Stream<Person> stream = list.stream();
        Stream<Person> filtered = stream.filter(person -> person.getAge() > 20);

        //All this can be changed for the user of parameter
        Predicate<Person> p = person -> person.getAge() > 20;
        Predicate<Person> p2 = person -> person.getAge() < 5 ;

        Stream<Person> filtered2 = stream.filter(p.and(p2.negate()));

        //Intermediate operations
        List<Person> result = new ArrayList<>();

        list.stream()
                .peek(System.out::println)   //intermediate operation .. returns something. lazy
                .filter(person -> person.getAge() > 20)  //intermediate operation .. returns something. lazy
                //.peek(result::add);   //intermediate operation .. it cant be the last one because the last one  MUST be a final.
                .forEach(list::add); //final operation, will trigger the stream operation. not lazy
    }

    public static void reductionTesting(){
        //this code sums all the elements in the list
        List<Integer> ages = Arrays.asList(20,10,30,40);
        Stream<Integer> streamAges = ages.stream();

        Integer sum = streamAges.reduce(0, (num1, num2) -> num1 + num2);
    }

    public static Optional<Integer> comparatorTesting(){
        //This code gets the biggest value in the list
        List<Integer> ages = Arrays.asList(20,10,30,40);
        Stream<Integer> streamAges = ages.stream();

        Optional<Integer> max = streamAges.max(Comparator.naturalOrder());

        return max;
    }

    public static void usingOptional() throws Exception {
        Optional<Integer> max = comparatorTesting();
        if(max.isPresent()){
            System.out.println(max.get());
        }else{
            System.out.println("No value to be shown");
        }

        //The following code will return the character or return the error if it is not
        Integer value = max.orElseThrow(Exception::new); //lazy initialization
    }


    public static void doingItAll() throws Exception {
        List<Person> list = Arrays.asList(new Person(10), new Person(30), new Person(20));

        //This will get the yongest age from the list of people.
        Optional<Integer> yongerAge =
                list.stream()
                        .map(person ->person.getAge())
                        .filter(age -> age > 20)
                        .min(Comparator.naturalOrder());
    }



    public static void getingAllNamesYongestThan20() throws Exception {
        List<Person> list = Arrays.asList(new Person(10), new Person(30), new Person(20));

        //This will get the yongest age from the list of people.
        String response =
                list.stream()
                        .filter(person -> person.getAge() > 20)
                        .map(Person::getName)
                        .collect(
                                Collectors.joining(", ")
                        );
    }
}