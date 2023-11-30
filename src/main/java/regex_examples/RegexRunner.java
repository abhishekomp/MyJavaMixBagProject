package regex_examples;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexRunner {

    public boolean matches(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
