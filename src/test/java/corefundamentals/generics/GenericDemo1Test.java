package corefundamentals.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericDemo1Test {

    @Test
    void displayArray() {
        GenericDemo1 runner = new GenericDemo1();
        Integer[] ints = {1, 2, 3};
        runner.displayArray(ints);
    }

    @Test
    void displayArray_using_char_array() {
        GenericDemo1 runner = new GenericDemo1();
        Character[] charArr = {'H', 'E', 'L', 'L', 'O'};
        runner.displayArray(charArr);
    }

    @Test
    void displayArrayGeneric_using_char_array() {
        GenericDemo1 runner = new GenericDemo1();
        Character[] charArr = {'H', 'E', 'L', 'L', 'O'};
        runner.displayArrayGeneric(charArr);
    }

    @Test
    void displayArrayStaticGeneric_using_char_array() {
        Character[] charArr = {'H', 'E', 'L', 'L', 'O'};
        GenericDemo1.displayArrayStaticGeneric(charArr);
    }
}