package personal.trainings.java8.dataAndTime;

import java.time.LocalDate;

/**
 * Created by e068582 on 4/12/2018.
 */
public class Person {

    private LocalDate dateOfBirth;
    private String name;

    public Person() {
    }

    public Person(LocalDate dateOfBirth, String name) {
        this.dateOfBirth = dateOfBirth;
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dateOfBirth=" + dateOfBirth +
                ", name='" + name + '\'' +
                '}';
    }
}
