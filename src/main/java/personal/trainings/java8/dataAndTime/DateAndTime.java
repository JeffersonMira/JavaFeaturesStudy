package personal.trainings.java8.dataAndTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by e068582 on 10/6/2018.
 */
public class DateAndTime {

    public static void main(String[] args){
        List<Person> people = new ArrayList<>();


        try(
        //getClass().getResourceAsStream(): procura o resource no mesmo diretorio do .class.
        //getClass().getClassLoader().getResourceAsStream(): procura no CLASSPATH.

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            DateAndTime.class.getResourceAsStream("people.txt")
                    )
            );
        Stream<String> stream = reader.lines();
        ){

            stream.map(
                    line -> {
                        String[] s = line.split(" ");
                        String name = s[0].trim();
                        int year = Integer.parseInt(s[1]);
                        Month month = Month.of(Integer.parseInt(s[3]));
                        int day = Integer.parseInt(s[2]);
                        Person p = new Person(LocalDate.of(year, month, day), name);
                        people.add(p);
                        return p;
                    }
            ).forEach(System.out::println);
        }catch(IOException e){
            System.out.print(e);
        }

        LocalDate now = LocalDate.now();

        people.stream().forEach(
                p -> {
                    Period period = Period.between(p.getDateOfBirth(), now);
                    System.out.println(p.getName() + " was born "+period.getYears() + " years ago");
                }
        );
    }
}
