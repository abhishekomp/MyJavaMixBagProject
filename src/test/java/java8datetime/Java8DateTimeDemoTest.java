package java8datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by sca820 on 11 okt., 2022
 */
class Java8DateTimeDemoTest {

    Java8DateTimeDemo dateUtility = new Java8DateTimeDemo();

    @Test
    void logicalDaysBetweenTwoDates() {
        LocalDate dateBefore = LocalDate.of(2022, 10, 10);
        LocalDate dateAfter = LocalDate.of(2022, 10, 11);
        long betweenTwoDates = dateUtility.logicalCalendarDaysBetweenTwoDates(dateBefore, dateAfter);
        System.out.println("betweenTwoDates = " + betweenTwoDates);
    }

    @Test
    void literal24HourDaysBetweenTwoDates() {
        LocalDate dateBefore = LocalDate.of(2022, 10, 10);
        LocalDate dateAfter = LocalDate.of(2022, 10, 11);
        long betweenTwoDates = dateUtility.literal24HourDaysBetweenTwoDates(dateBefore, dateAfter);
        System.out.println("Literal betweenTwoDates = " + betweenTwoDates);
    }

    @Test
    void logicalCalendarMonthsBetweenTwoDates() {
        LocalDate dateBefore = LocalDate.of(2022, 10, 01);
        LocalDate dateAfter = LocalDate.of(2022, 11, 01);
        long betweenTwoDates = dateUtility.logicalCalendarMonthsBetweenTwoDates(dateBefore, dateAfter);
        System.out.println("Months betweenTwoDates = " + betweenTwoDates);
    }

    //calculate age of a person using java 8
    @Test
    void shouldGetAge() {
        LocalDate dateBefore = LocalDate.of(2005, 07, 17);
        LocalDate today = LocalDate.now();
        long betweenTwoDates = dateUtility.logicalCalendarMonthsBetweenTwoDates(dateBefore, today);
        System.out.println("Months betweenTwoDates = " + betweenTwoDates);
        int years = Period.between(dateBefore, today).getYears();
        System.out.println("years = " + years);
    }
}