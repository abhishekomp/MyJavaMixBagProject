package corefundamentals.string_use_cases;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sca820 on 28 okt., 2022
 */
class ConvertStringToJavaUtilDateTest {

    ConvertStringToJavaUtilDate converter = new ConvertStringToJavaUtilDate();

    @Test
    void convertStringToDate() throws ParseException {
        final Date date = converter.convertStringToDate("2022-10-28");
        System.out.println("date = " + date);
    }
}