package java8practice.misc;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

//https://stackoverflow.com/questions/49195841/how-to-group-values-from-a-list-with-java-stream-api-groupingby-collector
//https://ideone.com/4MwwHk
public class GroupByDateDemo
{
    public static void main (String[] args) throws Exception{

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<Entry> list = Arrays.asList(
                new Entry(sdf.parse("2011-03-21 09:00"), "VALUE1")
                , new Entry(sdf.parse("2011-03-21 09:00"), "VALUE2")
                , new Entry(sdf.parse("2011-03-22 09:00"), "VALUE3")
                , new Entry(sdf.parse("2011-03-22 09:00"), "VALUE4")
                , new Entry(sdf.parse("2011-03-21 09:00"), "VALUE5")
        );

        Map<Date, List<Entry>> entries = list.stream().collect(groupingBy(e ->
                // easier way to truncate the date
                Date.from(e.getDate().toInstant().truncatedTo(ChronoUnit.DAYS)), TreeMap::new, toList()) //added treemap to sort by keys
        );

        //--- printing---
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));     // using GMT timezone to avoid inconsistencies when printing

        entries.forEach((date, entries1) -> {
            System.out.println(format.format(date));
            entries1.forEach(entry -> System.out.println("\t" + entry.getValue()));
        });
    }
}
class Entry {
    private final Date date;
    private final String value;

    public Entry(Date date, String value) {
        this.date = date;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "date=" + date +
                ", value='" + value + '\'' +
                '}';
    }

}
