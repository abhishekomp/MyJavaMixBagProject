package corefundamentals.generics;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoxWithWildCardTest {

    @Test
    void calculateArea() {
        BoxWithWildCard<Integer> boxWithWildCard = new BoxWithWildCard<>(4, 5);
        Double area = boxWithWildCard.calculateArea();
        System.out.println(area);
        assertEquals(20.0, area);
    }

    @Test
    void calculateAreaAgain() {
        //BoxWithWildCard<Integer> runner = new BoxWithWildCard<Integer>(10, 10);
        Double area = BoxWithWildCard.calculateAreaAgain(10, 10);
        System.out.println(area);
        assertEquals(100.0, area);
    }

    @Test
    void calculateAreaAgain_using_double_values() {
        //BoxWithWildCard<Integer> runner = new BoxWithWildCard<Integer>(10, 10);
        Double area = BoxWithWildCard.calculateAreaAgain(20.0, 15.0);
        System.out.println(area);
        assertEquals(300.0, area);
    }

    @Test
    void sumOfNumbers() {
        List<Integer> numbers = List.of(1, 2, 3);
        BoxWithWildCard<Integer> myBoxRunner = new BoxWithWildCard<>(10, 10);
        Double sumOfNumbers = myBoxRunner.sumOfNumbers(numbers);
        System.out.println(sumOfNumbers);
        assertEquals(6.0, sumOfNumbers);

    }

    @Test
    void sumOfNumbers_using_question_mark() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        BoxWithWildCard<Integer> myBoxRunner = new BoxWithWildCard<>(10, 10);
        Double sumOfNumbers = myBoxRunner.sumOfNumbersQuestionMark(numbers);
        System.out.println(sumOfNumbers);
        assertEquals(10.0, sumOfNumbers);

    }
}