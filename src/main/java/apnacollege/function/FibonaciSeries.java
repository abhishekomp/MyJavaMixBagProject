package apnacollege.function;

import java.util.ArrayList;
import java.util.List;

public class FibonaciSeries {
    public static void main(String[] args) {
        FibonaciSeries fibonaciSeries = new FibonaciSeries();
        final List<Long> list = fibonaciSeries.generateFibonacciSequence(5);
        System.out.println("list = " + list);
    }

    public List<Long> generateFibonacciSequence(int n) {
        //int n = 5;
        final List<Long> list = new ArrayList<>(List.of(0L, 1L));

        for(int i = 1; i <= n-2; i++) {
            long nextElement = getNextElement(list);
            list.add(nextElement);
        }
        return list;
    }

    private static long getNextElement(List<Long> list) {
        final int size = list.size();
        final long nextVal = list.get(size - 1) + list.get(size - 2);
        return nextVal;
    }

    public long getNthNumber(int n) {
        final Long aLong = generateFibonacciSequence(n).get(n - 1);
        return  aLong;
    }
}
