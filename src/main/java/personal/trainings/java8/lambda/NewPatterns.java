package personal.trainings.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class NewPatterns {

    public static void main(String[] args){
        NewPatterns np = new NewPatterns();
        np.testConsumer();
    }

    public void testPredicate(){
        Predicate<String> p1 = s -> s.length() < 20;
        Predicate<String> p2 = s -> s.length() > 10;

        //Esse AND é um metodo implementado default na interface Predicate. Isso só é possível
        //devido as novas features do java8.
        //Basicamente essa
        Predicate<String> p3 = p1.and(p2);
    }

    public void testConsumer(){
        List<String> strings = Arrays.asList("one","two","three","four","five");
        List<String> results = new ArrayList<>();

        java.util.function.Consumer<String> c1 = System.out::println; //primeiro consumer foi implementado para apenas mostrar o valor passado, no metodo accept, usando lambda no caso
        java.util.function.Consumer<String> c2 = results::add; //segundo consumer foi implementado para adicionar o valor na lista results, no metodo accept, usando lambda method reference

        strings.forEach(c1.andThen(c2));  //executa o primeiro consumer e depois os segundo.
        System.out.println("size of result = " + results.size());
    }

}
