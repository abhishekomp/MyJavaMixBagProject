package java8datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

public class Java8DateTimeDemo {
    public static void main(String[] args) {

        //Constant for the 1970-01-01T00:00:00Z epoch instant. Instant represents continuous flow of time
        //This constant contains zero displacement from EPOCH
        final Instant epoch = Instant.EPOCH;

        //Creating a new Instant
        final Instant instant = Instant.ofEpochSecond(20);
        Instant.ofEpochSecond(9961199, 2500);

        final Duration between = Duration.between(instant, Instant.EPOCH);
        System.out.println("between = " + between);

        //LocalDate is a date without timezone information
        //LocalTime is a time of day without time zone information
        //LocalDateTime is combination of LocalDate and LocalTime
        //Time zone offset is modelled by an instance of ZoneOffset
        //All the four above combined is modelled by ZonedDateTime

        //Adding a Duration to a ZonedDateTime will take into consideration of DST. However, adding a Period will not consider the DST

        //Factory methods for creating Duration (Interface TemporalAmount)
//        System.out.println(Duration.ofSeconds(123));              //PT2M3S
//        System.out.println(Duration.ofNanos(456));                //PT0.000000456S
//        System.out.println(Duration.ofNanos(1_000_000_000));      //PT1S
//        System.out.println(Duration.ofSeconds(123,456));          //PT2M3.000000456S

//        System.out.println(Duration.ofMillis(1000));              //PT1S
//        System.out.println(Duration.ofMinutes(123));              //PT2H3M
//        System.out.println(Duration.ofHours(25));                 //PT25H
//
//        System.out.println(Duration.ofSeconds(123));              //PT2M3S
        System.out.println(Duration.of(123, ChronoUnit.SECONDS));   //PT2M3S  //The second argument is Temporal Unit
        System.out.println(Duration.of(123, ChronoUnit.HOURS));     //PT2H

        System.out.println(Duration.ofSeconds(62,1_000_000_000));

        //Creation of LocalDate using Factory methods (Interface Temporal) of
        LocalDate localDate = LocalDate.ofEpochDay(5);
        System.out.println("localDate = " + localDate);
        System.out.println(LocalDate.ofEpochDay(1).getDayOfWeek());

        Instant.EPOCH.plus(271_752, ChronoUnit.HOURS);

        LocalDateTime startDateTime = LocalDateTime.of(1970, 1, 1, 9, 0);
        System.out.println(startDateTime.toLocalDate());
        System.out.println(startDateTime.toLocalTime());

        LocalDate localDate1 = LocalDate.of(2022, Month.AUGUST, 15);
        localDate1 = LocalDate.of(2022, 8, 15);

        System.out.println(LocalDate.from(startDateTime));
        System.out.println(Month.from(startDateTime));
        System.out.println(DayOfWeek.from(LocalDate.now()));

        //Creation of LocalDate, LocalTime, LocalDateTime using now() method
        LocalDate todayDay = LocalDate.now();
        System.out.println("now = " + todayDay);

        final DayOfWeek dayOfWeek = DayOfWeek.from(todayDay);
        System.out.println("dayOfWeek = " + dayOfWeek);

        Locale locale = Locale.getDefault();
        final DayOfWeek dayOfWeekThreeDaysAhead = DayOfWeek.from(todayDay).plus(3);
        System.out.println("Day of Week 3 days ahead Locale = " + dayOfWeekThreeDaysAhead);

        final int dayOfMonth = todayDay.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);

        //Adjustment methods for Temporal class (LocalDate, LocalTime, LocalDateTime)

    }

    //Logical calendar days between 2 dates
    //https://stackoverflow.com/questions/27005861/calculate-days-between-two-dates-in-java-8
    //https://www.oracle.com/technical-resources/articles/java/jf14-date-time.html
    public long logicalCalendarDaysBetweenTwoDates(LocalDate dateBefore, LocalDate dateAfter) {
        long daysBetween = DAYS.between(dateBefore, dateAfter);
        return daysBetween;
    }

    public long logicalCalendarMonthsBetweenTwoDates(LocalDate dateBefore, LocalDate dateAfter) {
        long daysBetween = MONTHS.between(dateBefore, dateAfter);
        return daysBetween;
    }

    //If you want literal 24 hour days, (a duration), you can use the Duration class instead
    //https://stackoverflow.com/questions/27005861/calculate-days-between-two-dates-in-java-8
    public long literal24HourDaysBetweenTwoDates(LocalDate dateBefore, LocalDate dateAfter) {
        long toDays = Duration.between(dateBefore.atStartOfDay(), dateAfter.atStartOfDay()).toDays();
        return toDays;
    }

    /**
     * Given the PNR (SSN) for a fictitious (not real) person returns the age of the person
     *
     * @param ssn               the ssn
     * @return the age of the person in years
     */
    public int getAgeFromSSN(String ssn) {
        //ssn could be 202010118228;
        return Period.between(LocalDate.of(Integer.parseInt(ssn.substring(0,4)), Integer.parseInt(ssn.substring(4,6)), Integer.parseInt(ssn.substring(6,8))), LocalDate.now()).getYears();
    }

    /**
     * Given the PNR (SSN) for a fictitious (not real) person returns if the person is 16 years or younger
     *
     * @param pnr               the ssn
     * @return true if person's age <= 16 else false
     */
    private boolean isPersonSixteenYearsAndYounger(String pnr) {
        //pnr could be 202010118228;
        //LocalDate birthDate = LocalDate.of(Integer.parseInt(pnr.substring(0,4)), Integer.parseInt(pnr.substring(4,6)), Integer.parseInt(pnr.substring(6,8)));
        int years = Period.between(LocalDate.of(Integer.parseInt(pnr.substring(0,4)), Integer.parseInt(pnr.substring(4,6)), Integer.parseInt(pnr.substring(6,8))), LocalDate.now()).getYears();
        return Period.between(LocalDate.of(Integer.parseInt(pnr.substring(0, 4)), Integer.parseInt(pnr.substring(4, 6)), Integer.parseInt(pnr.substring(6, 8))), LocalDate.now()).getYears() <= 16;
    }
}
