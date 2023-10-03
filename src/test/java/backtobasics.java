import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

//import static org.hamcrest.Matchers.hasSize;

import static org.assertj.core.api.Assertions.assertThat;

public class backtobasics {

    @Test
    public void
    givenListContainsDuplicates_whenRemovingDuplicatesPreservingOrderWithPlainJava_thenCorrect() {
        //List<Integer> listWithDuplicates = Lists.newArrayList(5, 0, 3, 1, 2, 3, 0, 0);
        List<Integer> listWithDuplicates = List.of(5, 0, 3, 1, 2, 3, 0, 0);
        List<Integer> listWithoutDuplicates = new ArrayList<>(
                new LinkedHashSet<>(listWithDuplicates));

        //assertThat(listWithoutDuplicates, hasSize(5));
        //assertThat(listWithoutDuplicates, containsInRelativeOrder(5, 0, 3, 1, 2));
        assertThat(listWithoutDuplicates.size()).isEqualTo(5);
    }

    @Test
    public void comparingStringUsingEqualOperator() {
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2);
    }

}
