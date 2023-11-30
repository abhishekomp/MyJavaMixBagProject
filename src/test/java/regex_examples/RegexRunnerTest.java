package regex_examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class RegexRunnerTest {

    RegexRunner regexRunner;

    @BeforeEach
    void setUp(){
        regexRunner = new RegexRunner();
    }

    @Test
    void matches_example_1() {
        Pattern pattern = Pattern.compile("Li(f|k)e");
        Matcher matcher = pattern.matcher("Life");
        assertTrue(matcher.matches());
    }

    @Test
    void matches_example_2() {
        Pattern pattern = Pattern.compile("Li(f|k)e");
        Matcher matcher = pattern.matcher("Like");
        assertTrue(matcher.matches());
    }

    @Test
    void matches_example_3_case_insensitive() {
        Pattern pattern = Pattern.compile("Li(f|k)e", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("LiKe");
        assertTrue(matcher.matches());
        assertTrue(pattern.matcher("LiFe").matches());
    }

    @Test
    void matches_example_4_case_insensitive() {
        Pattern pattern = Pattern.compile("(?i)Li(f|k)e");
        Matcher matcher = pattern.matcher("LiKe");
        assertTrue(matcher.matches());
        assertTrue(pattern.matcher("LiFe").matches());
    }

    @Test
    void matches_example_5_group() {
        // trying the pattern that will match a phone number in the format XX-XYZXYZXYZ and we will extract the country code and the phone number
        Pattern pattern = Pattern.compile("^([0-9]{2})(-)([0-9]{9})$");
        Matcher matcher = pattern.matcher("91-990222777");
        assertTrue(matcher.matches());
        if(matcher.matches()){
            System.out.println("Country code: " + matcher.group(1));
            System.out.println("Phone number: " + matcher.group(3));
        }
    }

    // Begins with, Starts with, Caret sign
    // Case insensitive search (case in-sensitive search)
    @Test
    void test_if_string_starts_with_given_string() {
        /*
        For a given input string, return a Boolean TRUE if the string starts with a given input word.
        So, for an input string of “hello world” and input word “hello,” the program should return TRUE.
         */
        String startsWith = "Hello";
        //String myRegExp = "^" + startsWith;
        //String myRegExp = String.format("^%s.*",startsWith);      //case sensitive search
        String myRegExp = String.format("(?i)^%s.*",startsWith);    //case in-sensitive search
        System.out.println("myRegExp = " + myRegExp);   //(?i)^Hello.*
        Pattern pattern = Pattern.compile(myRegExp);
        Matcher matcher = pattern.matcher("Hello World");
        assertTrue(matcher.matches());
        matcher = pattern.matcher("hello World");
        assertTrue(matcher.matches());
    }

    /*
    Count the number of occurrences of a string in a given string
    Create a program that returns the number of times a word appears in an input string.
    For example, given an input word "new" and an input string "I'm the new newt,"
    the program should return a value of 2.
     */
    @Test
    void test_count_the_number_of_occurrences_of_a_string_in_given_string(){
        //String searchStr = "(?i)new"; //works but searchString will be passed without ?i
        String searchStr = "new";
        String input = "I'm the new newt,";
        input = "I'm the new in the new town and newC, and NewW";   //should give 4 based on case in-sensitive match
        String myRegExp = String.format("(?i)(%s)", searchStr); //(?i) for case in-sensitive match
        //String myRegExp = searchStr;
        Pattern pattern = Pattern.compile(myRegExp);
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while(matcher.find()) {
            count++;
        }
        System.out.println("count = " + count);
    }
}