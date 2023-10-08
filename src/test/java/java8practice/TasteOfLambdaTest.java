package java8practice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TasteOfLambdaTest {

    TasteOfLambda tasteOfLambda = new TasteOfLambda();

    @Test
    void test_createAListOfIntegerGivenTheBoundaries_should_generate_a_list_of_integers_given_the_start_and_end_element() {
        List<Integer> expectedIntegerList = List.of(5, 6, 7, 8, 9, 10);
        List<Integer> actualList = tasteOfLambda.createAListOfIntegerGivenTheBoundaries(5, 10);
        System.out.println("actualList = " + actualList);
        assertIterableEquals(expectedIntegerList, actualList);
    }

    @Test
    void getNextNOddNumbers() {
        List<Integer> expectedList = List.of(7, 9, 11, 13);

        int start = 7;
        int count = 4;
        List<Integer> actualList = tasteOfLambda.getNextNOddNumbers(start, count);
        System.out.println("actualList = " + actualList);
        assertIterableEquals(expectedList, actualList);
    }
}