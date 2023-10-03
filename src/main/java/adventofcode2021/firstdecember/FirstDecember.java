package adventofcode2021.firstdecember;

import readtextfile.ReadTextFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FirstDecember {
    public void partOne() {
        ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\1-Dec\\input_partone.txt");
        //ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\1-Dec\\input_example.txt");
        List<String> strings = readTextFile.readTextFile();

        strings.forEach(System.out::println);

        String baseValue = strings.get(0);
        int baseInt = Integer.parseInt(baseValue);
        int incrementCount = 0;

        for(int i = 1; i < strings.size(); i++) {
            if(Integer.parseInt(strings.get(i)) > baseInt) {
                incrementCount++;
                baseInt = Integer.parseInt(strings.get(i));
            }
            else {
                baseInt = Integer.parseInt(strings.get(i));
            }
        }
        System.out.println("incrementCount = " + incrementCount);
    }

    public static void main(String[] args) {
        FirstDecember firstDecember = new FirstDecember();
        //firstDecember.partOne();
        firstDecember.partTwo();
    }

    public void partTwo() {
        ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\1-Dec\\input_partone.txt");
        //ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\1-Dec\\input_example.txt");
        List<String> strings = readTextFile.readTextFile();

        int currentIndex = 1;
        int lastIndex = strings.size() - 1;
        int countofThree = 0;
        int sumOfGroupOfThree = 0;
        int[] groupOfThreeInitial = {Integer.parseInt(strings.get(0)), Integer.parseInt(strings.get(1)), Integer.parseInt(strings.get(2))};
        int sum = IntStream.of(groupOfThreeInitial).sum();
        System.out.println("The sum is " + sum);

        int incrementCount = 0;

        while(currentIndex <= lastIndex - 2) {
            int[] groupOfThree = {Integer.parseInt(strings.get(currentIndex)), Integer.parseInt(strings.get(currentIndex + 1)), Integer.parseInt(strings.get(currentIndex + 2))};
            int newSum = IntStream.of(groupOfThree).sum();
            if(newSum > sum) {
                incrementCount++;
            }
            sum = newSum;
            //System.out.println(Arrays.toString(groupOfThree));
            //System.out.println("currentIndex = " + currentIndex);
            countofThree++;
            currentIndex++;
        }
        System.out.println("countofThree = " + countofThree);
        System.out.println("incrementCount = " + incrementCount);
    }
}
