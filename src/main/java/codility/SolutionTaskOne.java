package codility;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class SolutionTaskOne {
    /**
     * Returns the number that occurs most number of times
     * @param M the max integer value
     * @param A the integer array
     * @return the integer that occurs more frequently
     */
    int solution(int M, int[] A) {
        int N = A.length;
        int[] count = new int[M + 1];
        for (int i = 0; i <= M; i++)
            count[i] = 0;
        int maxOccurence = 1;
        int index = 0;                      //1st change, can't be negative otherwise for all unique elements in the array otherwise the index returned at end will be -1
        for (int i = 0; i < N; i++) {
            if (count[A[i]] > 0) {
                int tmp = count[A[i]];
                if (tmp + 1 > maxOccurence) {   //2nd change, the element being visited will lead to its count getting incremented by 1.
                    maxOccurence = tmp + 1;     //3rd change, with the element being visited its maxOccurrence will increase by 1, so this is the maxOccurrence so far.
                    index = i;
                }
                count[A[i]] = tmp + 1;
            } else {
                count[A[i]] = 1;
            }
        }
        return A[index];
    }

    /**
     * Java stream approach to get the most frequent occurring integer from the given array
     * @param A integer array according to the problem definition
     * @return most frequent occurring integer in the array
     */
    public int solution(int[] A){
        LinkedHashMap<Integer, Long> collect = Arrays.stream(A)
                .boxed()
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        return collect.entrySet().iterator().next().getKey();
        //System.out.println(collect.entrySet().iterator().next().getKey());
    }
}
