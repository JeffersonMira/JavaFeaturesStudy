package personal.trainings.java8.streamAndCollectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;


public class FlatMapExample {

//    public static void main(String... args){
//
//        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
//        List<Integer> list2 = Arrays.asList(2,4,6);
//        List<Integer> list3 = Arrays.asList(3,5,7);
//
//        List<List<Integer>> list = Arrays.asList(list1, list2, list3);
//
//        System.out.println(list);
//
//        Function<List<?>, Integer> size = List::size;
//        Function<List<Integer>, Stream<Integer>> flatmapper = l -> l.stream();
//
//        // it is just printed when ysing flatmapper
//        // it is just printed when ysing flatmapper
//        list.stream()
//                .flatMap(flatmapper)
//                .forEach(System.out::println);
//    }

//    public static void main(String... args){
//        List<Integer> ages = Arrays.asList(20,12,90,50,10,77);
//        Stream<Integer> stream = ages.stream();
//
//        //*****example 1*****
////        Integer sum = stream.reduce(0,Integer::sum);
//
//        //*****example 2*****
////        Integer sum = stream.reduce(0,(x,y)->x+y);
//
//        //*****example 3*****
//        BinaryOperator<Integer> op = (i1,i2) -> i1+i2;
//        Integer id = 0; //Identity element for the sum
//
//        Integer sum = stream.reduce(id, op);
//        System.out.print("A some foi "+ sum);
//    }

    public static void main(String... args){
        List<Integer> ages = Arrays.asList(20,12,90,50,10,77);
        Stream<Integer> stream = ages.stream();

        Optional<Integer> max = stream.max(Comparator.naturalOrder());

        if(max.isPresent()){
            Integer s = max.get();
            System.out.println(s);
        }else{
            System.out.println("nothing in the list");
        }
    }

}
