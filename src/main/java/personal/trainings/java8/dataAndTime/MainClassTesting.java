package personal.trainings.java8.dataAndTime;

import personal.trainings.java8.streamAndCollectors.Person;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClassTesting {


    //instant is about exact moment of something.
//    public static void main(String[] args) throws InterruptedException {
//
//        //Instant is not mutable in order to avoid the necessity to use the defencive pattern when using this values.
//        Instant start = Instant.now();
//        Thread.sleep(1000);
//        Instant end = Instant.now();
//
//        Duration elapsed = Duration.between(start, end);
//        long milis = elapsed.toMillis();
//        System.out.print("Duration - "+ milis);
//
//    }

    //local date is about just the date, not the millisecond and whatever
//    public static void main(String[] args){
//        LocalDate now = LocalDate.now();
//        LocalDate dateOfBirth = LocalDate.of(1990, Month.DECEMBER, 20);
//
//
//        //Period is the same as Duration but it is used for LocalDate
//        System.out.print("Date of Birth - "+ dateOfBirth);
//
//        Period p = dateOfBirth.until(now);
//        System.out.print("#Years - "+ p.getYears());
//
//        long days = dateOfBirth.until(now, ChronoUnit.DAYS);
//        System.out.print("#days - "+ days);
//
//

//    }



    public static void main(String[] args){

        //Creating a meeting and adding 1 month to it - which is the next meeting.
        ZonedDateTime currentMeeting = ZonedDateTime.of(LocalDate.of(2014,Month.DECEMBER, 12),
                LocalTime.of(9,30),
                ZoneId.of("Europe/London"));

        ZonedDateTime nextMeeting = currentMeeting.plus(Period.ofMonths(1));

        //Chaging timezone
        ZonedDateTime nextMeetingUs = nextMeeting.withZoneSameInstant(ZoneId.of("US/Central"));

        //Printing this ship
        System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(nextMeetingUs));
    }

}