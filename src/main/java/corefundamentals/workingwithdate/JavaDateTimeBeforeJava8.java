package corefundamentals.workingwithdate;

import org.apache.hadoop.hdfs.security.token.block.DataEncryptionKey;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by sca820 on 29 juni, 2022
 */
public class JavaDateTimeBeforeJava8 {
    public static void main(String[] args) {

        System.out.println("*****************PRE JAVA-8 DATE API*********************");

        Date now = new Date();
        System.out.println(now);    //Thu Jun 30 13:11:14 CEST 2022

        GregorianCalendar gc = new GregorianCalendar(2022, 1, 28);
        Date date1 = gc.getTime();
        System.out.println(date1);  //Mon Feb 28 00:00:00 CET 2022

        //Adding to a date
        gc.add(GregorianCalendar.DATE, 1);
        Date date2 = gc.getTime();
        System.out.println(date2);  //Tue Mar 01 00:00:00 CET 2022

        //Formatting a date
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println(df.format(date2));   //tisdag 1 mars 2022

        System.out.println("*****************JAVA-8 DATE API*********************");
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);    //2022-06-30T13:22:01.853349400
        LocalDate ld = LocalDate.of(2022, 1, 28);
        System.out.println(ld); //2022-01-28

        //Formatting a date using Java 8 DateTime API
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        System.out.println(dtf.format(ld)); //1/28/2022

    }
}
