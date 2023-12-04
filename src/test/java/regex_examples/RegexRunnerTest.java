package regex_examples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    /*
    Two words are anagrams if they contain the same letters but in a different order. Here are a few examples of anagram pairs:
    "listen" and "silent"
    "binary" and "brainy"
    "Paris" and "pairs"
    For a given input of two strings, return a Boolean TRUE if the two strings are anagrams.
    */
    @Test
    void test_check_if_strings_are_anagrams(){
        String str1 = "listen";
        String str2 = "Silent";
        char[] chars = str1.toCharArray();

    }
    //V.IMP for find(), group(), start() and end() usage.
    @Test
    void test_demo_find_group_start_end_methods() {
        String searchMe = "The top of the mop is called a handle";
        Pattern pattern = Pattern.compile("[mt]op");
        Matcher matcher = pattern.matcher(searchMe);
        while(matcher.find()){
            //System.out.println("Matcher found " + matcher.group() + " at index " + matcher.start());
            System.out.println("Matcher found " + matcher.group() + " at index " + matcher.start() + " and end index " + matcher.end());
        }
    }

    @Test
    void test_lookbehind_example(){
        //Given the string extract the game number
        String input = "Game 799: 3 blue, 4 red";
        //(?<=USD)\d{3}
        //Pattern pattern = Pattern.compile("(?<=\\d)+:"); //cannot use quantifier in look behind
        Pattern pattern = Pattern.compile("(\\d+):");   //extracting the digits just before the colon.
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            System.out.println("Matcher found " + matcher.group(1) + " at index " + matcher.start());
        }
    }
    @Test
    void test_check_if_character_is_a_symbol_other_than_dot(){
        char ch = '#';
        // something that is not an alphabet, nor a digit and nor a period(dot)
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9.]");
        Matcher matcher = pattern.matcher(String.valueOf(ch));
        System.out.println(matcher.matches());
        assertTrue(matcher.matches());
    }
    @Test
    void test_check_if_character_is_a_symbol_other_than_dot_2(){
        char ch = '?';
        assertTrue(Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf('/')).matches());
        assertTrue(Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf('\\')).matches());
        assertTrue(Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf('?')).matches());
        assertTrue(Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf('+')).matches());
        assertFalse(Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf('.')).matches());
        assertTrue(Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf('-')).matches());
        assertTrue(Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf('#')).matches());
        assertTrue(Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf('$')).matches());
        assertTrue(Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf('*')).matches());
        assertFalse(Pattern.compile("[^a-zA-Z0-9.]").matcher(String.valueOf('9')).matches());
    }

    @Test
    void test_check_if_character_is_a_symbol_other_than_dot_3(){
        char ch = '.';
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9.]");
        Matcher matcher = pattern.matcher(String.valueOf(ch));
        System.out.println(matcher.matches());
        assertFalse(matcher.matches()); //ch is a dot hence it does not match the provided regex.
    }

    @Test
    void test_check_if_character_is_a_symbol_other_than_dot_4(){
        char ch = '$';  //dollar symbol
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9.]");
        Matcher matcher = pattern.matcher(String.valueOf(ch));
        System.out.println(matcher.matches());
        assertTrue(matcher.matches());
    }
    @Test
    void test_should_extract_all_instances_of_number_from_given_string(){
        String input = "100..101..*...$102...^...103...~.104";  //dollar, caret, tilda sign
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(input);
        List<String> strings = new ArrayList<>();
        while(matcher.find()){
            strings.add(matcher.group(1));
            System.out.println("Matcher found " + matcher.group(1) + " at index " + matcher.start() + " and end index " + matcher.end());
        }
        assertIterableEquals(List.of("100", "101", "102", "103", "104"), strings);
        System.out.println(strings);
        /*
        Matcher found 100 at index 0 and end index 3
        Matcher found 101 at index 5 and end index 8
        Matcher found 102 at index 15 and end index 18
        Matcher found 103 at index 25 and end index 28
        Matcher found 104 at index 33 and end index 36
         */
    }

}