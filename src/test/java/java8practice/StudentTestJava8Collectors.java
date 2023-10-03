package java8practice;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import static java.util.stream.Collectors.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentTestJava8Collectors {

    List<Student> students = Arrays.asList(
            new Student("John", "Smith", "Miami", 7.6, 19),
            new Student("John", "Smith", "New York", 8.4, 21),
            //new Student("John", "Smith", "Miami", 5.0, 20),
            new Student("Mike", "Miles", "New York", 8.4, 21),
            new Student("Michael", "Peterson", "New York", 7.5, 20),
            new Student("James", "Robertson", "Miami", 9.1, 20),
            new Student("Kyle", "Miller", "Miami", 9.8, 20)
    );

    @Test
    //toMap
    public void demo_toMap_to_create_a_Map_name_to_AvgGrade_when_no_duplicateKeys() {
        final Map<String, Double> nameToAvgGrade = students.stream()
                .collect(toMap(Student::getName, Student::getAvgGrade));
        System.out.println("nameToAvgGrade = " + nameToAvgGrade);
    }

    @Test
    //toMap
    public void demo_toMap_to_create_a_Map_name_to_Student_when_no_duplicateKeys() {
        final Map<String, Student> nameToStudent = students.stream()
                .collect(toMap(Student::getName, Function.identity()));
        System.out.println("nameToStudentMap = " + nameToStudent);
    }

    @Test
    //toMap
    public void demo_toMap_to_create_a_Map_name_to_AvgGrade_when_duplicateKeys_present() {
        final Map<String, Double> nameToAvgGrade = students.stream()
                .collect(toMap(
                        Student::getName,       //keyMapper
                        Student::getAvgGrade,    //ValueMapper
                        (a, b) -> {return (a + b)/2;}   //MergeFunction is a Binary Operator
                ));
        System.out.println("nameToAvgGrade = " + nameToAvgGrade);
    }

    @Test
    //toMap
    public void demo_toMap_to_create_a_Map_name_to_AvgGrade_when_duplicateKeys_present_with_Supplier() {
        final Map<String, Double> nameToAvgGrade = students.stream()
                .collect(toMap(
                        Student::getName,       //keyMapper
                        Student::getAvgGrade,    //ValueMapper
                        (a, b) -> {return (a + b)/2;},  //MergeFunction is a Binary Operator
                        LinkedHashMap::new      //SupplierFunction Linked HashMap maintains the order of the key
                ));
        System.out.println("nameToAvgGrade = " + nameToAvgGrade);
    }

    @Test
    //toSet
    public void demo_toSet(){
        Stream<String> stream =
                Stream.of("This", "forms", "forms", "a", "short", "a", "sentence", "sentence");
        Set<String> sentenceSet = stream.collect(toSet());
        System.out.println("sentenceSet = " + sentenceSet);
        System.out.println(sentenceSet.getClass());
    }

    @Test
    //flatMap
    //Objective: Generate a list of characters from a list of words
    public void generate_list_of_characters_from_list_of_words() {
        Stream<String> words = Stream.of(
                "lorem", "ipsum", "dolor", "sit", "amet"
        );

        List<String> collect = words.flatMap(e -> Arrays.stream(e.split("")))
                .collect(toList());

        System.out.println("collect = " + collect);
    }

    @Test
    //flatMap
    //Objective: Method 2: Generate a list of characters from a list of words
    //Ref: https://stackabuse.com/java-8-streams-definitive-guide-to-flatmap/
    public void generate_list_of_characters_from_list_of_words_Method2() {
        Stream<String> words = Stream.of(
                "lorem", "ipsum", "dolor", "sit", "amet"
        );
        Function<String, IntStream> intF = CharSequence::chars;
        Function<IntStream, Stream<Character>> charF = s -> s.mapToObj(num -> (char)num);

        Stream<Character> characterStream = words.map(intF)
                .flatMap(charF);

        List<Character> characterList = characterStream.collect(toList());
        System.out.println("characterList = " + characterList);
    }
}