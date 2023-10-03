package extractText;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExtractTagValueFromStringTest {

    @Test
    public void test_Extract_String() {
        ExtractTagValueFromString service = new ExtractTagValueFromString();
        String value = service.findValue("Line of log <SDS>2021-11-10T20:00:00</SDS> and End of log line", "<SDS>", "</SDS>");
    }

    @Test
    public void test_date_String_are_equal() {
        String firstDate = "2021-11-10T20:00:00";
        String secondDate = "2021-11-10T20:00:00.0000000+01:00";

        String test = secondDate.substring(0,19);
        assertThat(secondDate.substring(0,19)).isEqualTo(firstDate);

    }

}