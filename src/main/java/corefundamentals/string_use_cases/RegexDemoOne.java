package corefundamentals.string_use_cases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sca820 on 16 okt., 2022
 */
public class RegexDemoOne {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("\\d{2,3}-\\d{8,10}$");
        Pattern pattern = Pattern.compile(sb.toString());
        //Matcher matcher = pattern.matcher("91-9902225804"); //true
        Matcher matcher = pattern.matcher("914-9902225804");
        boolean matches = matcher.matches();
        System.out.println("matches = " + matches);
    }

    //Validating phone number in the format 2,3 digits followed by a dash and the 8 to 10 digits
    public boolean validatePhoneNumberString(String phoneString) {
        return Pattern.compile("\\d{2,3}-\\d{8,10}$").matcher(phoneString).matches();
    }
}
