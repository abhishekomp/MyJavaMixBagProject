package java8datetime.mypractice;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Stream;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.MONDAY;

public class GetAllWorkingDatesBetweenTwoDates {
    public static void main(String[] args) {

        LocalDate startDate = LocalDate.of(2022,05,01);
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("endDate = " + endDate);

        TemporalAdjuster nextWorkingDayAdjuster =
                d -> DayOfWeek.from(d) != FRIDAY
                        ? d.plus(1, ChronoUnit.DAYS)
                        : d.with(TemporalAdjusters.next(MONDAY));

        Stream.iterate(startDate, d -> d.with(nextWorkingDayAdjuster))
                .limit(8)
                .forEach(System.out::println);

    }
}
