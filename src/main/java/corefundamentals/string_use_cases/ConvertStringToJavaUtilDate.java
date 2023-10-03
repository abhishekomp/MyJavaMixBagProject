package corefundamentals.string_use_cases;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sca820 on 28 okt., 2022
 */
public class ConvertStringToJavaUtilDate {
    public static void main(String[] args) throws ParseException {
        ConvertStringToJavaUtilDate dateParser = new ConvertStringToJavaUtilDate();
        Date toDate = dateParser.convertStringToDate("2022-10-28");
        System.out.println("toDate = " + toDate);
    }

    public Date convertStringToDate(String s) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  //returns Fri Oct 28 00:00:00 CEST 2022 for string "2022-10-28"
        Date date = formatter.parse(s);
        return date;
    }

}
