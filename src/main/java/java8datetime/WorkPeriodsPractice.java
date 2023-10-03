package java8datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class WorkPeriodsPractice {

    public static WorkPeriod createFirstWorkPeriod() {
        LocalDateTime startDateTime;
        startDateTime = LocalDateTime.of(1970, 1, 1, 9, 0);
        LocalDate startDate = LocalDate.of(1970,1,1);
        LocalTime startTime = LocalTime.of(9,0);
        startDateTime = LocalDateTime.of(startDate, startTime);

        Duration morningLength = Duration.ofHours(3).plusMinutes(30);
        LocalDateTime endDateTime;
        endDateTime = startDateTime.with(LocalTime.of(12,30));
        endDateTime = startDateTime.plus(morningLength);

        WorkPeriod workPeriod = WorkPeriod.of(startDateTime, endDateTime);
        return workPeriod;
    }
}
