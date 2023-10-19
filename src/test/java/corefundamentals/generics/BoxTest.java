package corefundamentals.generics;

import org.junit.jupiter.api.Test;

class BoxTest {

    @Test
    void displayArr() {
        Box<Integer> runner = new Box<>(1);
        Integer[] intArr = {1, 2, 3};
        runner.displayArr(intArr);
    }

    @Test
    void inspect() {
        Box<String> strBox = new Box<>("myBox");
        strBox.inspect(4.5f);

    }
}