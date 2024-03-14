package codility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTaskOneTest {

    private SolutionTaskOne solutionTaskOne;

    @BeforeEach
    void setUp() {
        solutionTaskOne = new SolutionTaskOne();
    }

    @Test
    void solution() {
        int[] A = { 1, 2, 3, 3, 1, 3, 1 };
        int M = 3;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        //System.out.println(String.format("result = %d", result));
        assertEquals(3, result);
    }

    @Test
    void solution_2() {
        int[] A = { 5, 5, 4, 4, 4, 2 };
        int M = 5;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(4, result);
    }

    @Test
    void solution_3() {
        int[] A = { 20, 20, 30, 40, 50, 30, 20 };
        int M = 50;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(20, result);
    }

    @Test
    void solution_4() {
        int[] A = { 1 };
        int M = 1;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(1, result);
    }

    @Test
    void solution_5() {
        int[] A = { 0, 0, 0, 0, 1, 1, 1 };
        int M = 1;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(0, result);
    }

    @Test
    void solution_6() {
        int[] A = { 0, 0, 0, 0, 0 };
        int M = 0;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(0, result);
    }

    @Test
    void solution_7() {
        int[] A = { 10 };
        int M = 10;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        int resultFromSol2 = solutionTaskOne.solution(A);
        System.out.println(String.format("result from map approach = %d", resultFromSol2));
        System.out.println(String.format("result = %d", result));
        assertEquals(10, result);
    }

    @Test
    void solution_8() {
        int[] A = { 0 };
        int M = 0;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(0, result);
    }

    @Test
    void solution_9() {
        int[] A = { 0, 0 };
        int M = 0;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(0, result);
    }

    @Test
    void solution_10() {
        int[] A = { 0, 1 };
        int M = 1;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(0, result);
    }

    // 40, [20, 10, 30, 30, 40] the failing test case from the result reported by
    // the codility tool
    @Test
    void solution_11() {
        int[] A = { 20, 10, 30, 30, 40 };
        int M = 40;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(30, result);
    }

    @Test
    void solution_12() {
        int[] A = { 2, 1, 3, 3, 4 };
        int M = 4;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(3, result);
    }

    @Test
    void solution_13() {
        int[] A = { 4, 4, 5, 5, 5 };
        int M = 5;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(5, result);
    }

    @Test
    void solution_14() {
        int[] A = { 5, 5, 5, 4, 4, 4 };
        int M = 5;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(5, result);
    }

    @Test
    void solution_15() {
        int[] A = { 40, 20, 40, 50, 40, 50, 50, 40 };
        int M = 50;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(40, result);
    }

    @Test
    void solution_16() {
        int[] A = { 8000, 0, 10, 2732, 2732 };
        int M = 8000;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(2732, result);
    }

    @Test
    void solution_17() {
        int[] A = { 1, 8, 7, 10, 11, 5, 3, 18, 7, 0 };
        int M = 20;
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(7, result);
    }

    @Test
    void solution_18() {
        int M = 20;
        int[] A = GenerateRandomIntArray.generateRandomIntArray(10, M);
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
    }

    @Test
    void solution_19() {
        int M = 20;
        int[] A = { 10, 0, 1, 17, 5, 16, 18, 0, 4, 3 };
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(0, result);
    }

    @Test
    void solution_20() {
        int M = 20;
        int[] A = { 10, 0, 19, 17, 5, 19, 18, 0, 19, 3 };
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(19, result);
    }

    @Test
    void solution_21() {
        int M = 99889;
        int[] A = { 99, 99889, 99889 };
        System.out.println(Arrays.toString(A));
        int result = solutionTaskOne.solution(M, A);
        System.out.println("result = " + result);
        assertEquals(99889, result);
    }
}