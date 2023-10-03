package adventofcode2021.seconddecember;

import readtextfile.ReadTextFile;

import java.util.List;

public class SecondDecember {
    public void partOne() {
        ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\2-Dec\\input_partone.txt");
        List<String> strings = readTextFile.readTextFile();

        strings.forEach(System.out::println);

        int horizontal = 0;
        int depth = 0;

        for(String str : strings) {
            String[] split = str.split(" ");
            if("forward".equals(split[0])) {
                horizontal = horizontal + Integer.parseInt(split[1]);
            }
            if("down".equals(split[0])) {
                depth = depth + Integer.parseInt(split[1]);
            }
            if("up".equals(split[0])) {
                depth = depth - Integer.parseInt(split[1]);
            }
        }
        System.out.println("Final depth = " + depth);
        System.out.println("Final horizontal = " + horizontal);
        System.out.println("After multiplying = " + (depth * horizontal));
    }

    public static void main(String[] args) {
        SecondDecember secondDecember = new SecondDecember();
        //secondDecember.partOne();
        secondDecember.partTwo();
    }

    public void partTwo() {
        //ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\2-Dec\\input_example.txt");
        ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\2-Dec\\input_partone.txt");
        List<String> strings = readTextFile.readTextFile();

        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for(String str : strings) {
            String[] split = str.split(" ");
            if("forward".equals(split[0])) {
                horizontal = horizontal + Integer.parseInt(split[1]);
                depth = depth + (aim * Integer.parseInt(split[1]));
            }
            if("down".equals(split[0])) {
                aim = aim + Integer.parseInt(split[1]);
            }
            if("up".equals(split[0])) {
                aim = aim - Integer.parseInt(split[1]);
            }
        }

        System.out.println("Final depth = " + depth);
        System.out.println("Final horizontal = " + horizontal);
        System.out.println("Final aim = " + aim);
        System.out.println("After multiplying = " + (depth * horizontal));

    }


}
