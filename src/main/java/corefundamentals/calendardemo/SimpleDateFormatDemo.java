package corefundamentals.calendardemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sca820 on 21 nov., 2022
 */
public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        String dateOfBirth = "2020-05-0";
        try {
            //String dateOfBirth = "2020-05-20";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateOfBirthAsDate = sdf.parse(dateOfBirth);
            System.out.println(dateOfBirthAsDate);
        } catch (ParseException e) {
            System.out.println("Error parsing date: '" + dateOfBirth + "'");
            e.printStackTrace();
        }
    }
}
