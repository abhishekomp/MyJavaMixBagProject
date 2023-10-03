package java8datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class OffSetDateTimeDemo {
    public static void main(String[] args) {
        Clock testClock = Clock.fixed(Instant.EPOCH, ZoneOffset.UTC);
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now(testClock));

        final int maxLength = MonthDay.now().getMonth().maxLength();
        System.out.println("maxLength = " + maxLength);

//        LocalDateTime landingLocalTime = LocalDateTime.of(LocalDate.now(testClock).plusDays(1), LocalTime.of(17,55));
//        System.out.println("landingLocalTime = " + landingLocalTime);
//
//        OffsetDateTime landingWithDestOffset = OffsetDateTime.of(landingLocalTime, ZoneOffset.of("+8"));
//        System.out.println("landingWithDestOffset = " + landingWithDestOffset);
//
//        OffsetDateTime landingWithOrigOffset = landingWithDestOffset.withOffsetSameInstant(ZoneOffset.of("+0"));
//        System.out.println("landingWithOrigOffset = " + landingWithOrigOffset);
//
//        LocalDateTime originLocalLandingTime = landingWithOrigOffset.toLocalDateTime();
//        System.out.println("originLocalLandingTime = " + originLocalLandingTime);
//
//        //System.out.println(ZoneId.getAvailableZoneIds());
//        System.out.println(ZoneId.systemDefault());
    }
}
