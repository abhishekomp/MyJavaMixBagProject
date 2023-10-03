package adventofcode2021.thirddecember;

import readtextfile.ReadTextFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdDecember {

    public void partOne() {
        ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\3-Dec\\input_partone.txt");
        //ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\3-Dec\\input_example.txt");
        List<String> strings = readTextFile.readTextFile();
        //strings.forEach(System.out::println);
        getGammarate(strings);
        getEpsilonrate(strings);
    }

    private void getGammarate(List<String> strings) {

        int numOfBits = strings.get(0).split("").length;
        //System.out.println("numOfBits = " + numOfBits);

        StringBuilder binaryStr = new StringBuilder();
        for(int i = 0; i < numOfBits; i++) {
            int zeroCount = 0;
            int oneCount = 0;
            for(String str : strings) {
                String[] split = str.split("");
                //System.out.println(Arrays.toString(split));
                if(Integer.parseInt(split[i]) == 0) {
                    zeroCount++;
                }
                if(Integer.parseInt(split[i]) == 1) {
                    oneCount++;
                }
            }
            if(zeroCount > oneCount) {
                binaryStr.append("0");
            }
            else {
                binaryStr.append("1");
            }

            //System.out.println("oneCount = " + oneCount);
            //System.out.println("zeroCount = " + zeroCount);
        }
        System.out.println("Gamma binaryStr = " + binaryStr);

    }

    private void getEpsilonrate(List<String> strings) {

        int numOfBits = strings.get(0).split("").length;
        //System.out.println("numOfBits = " + numOfBits);

        StringBuilder binaryStr = new StringBuilder();
        for(int i = 0; i < numOfBits; i++) {
            int zeroCount = 0;
            int oneCount = 0;
            for(String str : strings) {
                String[] split = str.split("");
                //System.out.println(Arrays.toString(split));
                if(Integer.parseInt(split[i]) == 0) {
                    zeroCount++;
                }
                if(Integer.parseInt(split[i]) == 1) {
                    oneCount++;
                }
            }
            if(zeroCount > oneCount) {
                binaryStr.append("1");
            }
            else {
                binaryStr.append("0");
            }

            //System.out.println("oneCount = " + oneCount);
            //System.out.println("zeroCount = " + zeroCount);
        }
        System.out.println("Epsilon binaryStr = " + binaryStr);

    }

    public static void main(String[] args) {
        ThirdDecember thirdDecember = new ThirdDecember();
        //thirdDecember.partOne();
        thirdDecember.partTwo();
    }

    public void partTwo() {
        ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\3-Dec\\input_partone.txt");
        //ReadTextFile readTextFile = new ReadTextFile("C:\\MyJava\\AdventOfCode2021\\3-Dec\\input_example.txt");
        List<String> strings = readTextFile.readTextFile();
        //strings.forEach(System.out::println);
        oxygengeneratorrating(strings);
        cotwoscrubberrating(strings);
    }

    private void oxygengeneratorrating(List<String> strings) {

        int numOfBits = strings.get(0).split("").length;
        List<String> subList = strings;
        for(int position = 0; position < numOfBits; position++) {
            int mostCommonBitForPosition = getMostCommonBitForPosition(subList, position);
            subList = createSubListWithSpecifiedBitAtPosition(subList, mostCommonBitForPosition, position);
            if(subList.size() == 1)
                break;
        }
        System.out.println("Final list is ");
        subList.forEach(System.out::println);

    }

    private void cotwoscrubberrating(List<String> strings) {

        int numOfBits = strings.get(0).split("").length;
        List<String> subList = strings;
        for(int position = 0; position < numOfBits; position++) {
            int leastCommonBitForPosition = getLeastCommonBitForPosition(subList, position);
            subList = createSubListWithSpecifiedBitAtPosition(subList, leastCommonBitForPosition, position);
            if(subList.size() == 1)
                break;
        }
        System.out.println("Final co2 list is ");
        subList.forEach(System.out::println);

    }

    private List<String> createSubListWithSpecifiedBitAtPosition(List<String> strings, int mostCommonBitForPosition, int position) {
        List<String> newList = new ArrayList<>();
        for(String str : strings) {
            if(Integer.parseInt(str.split("")[position]) == mostCommonBitForPosition) {
               newList.add(str);
            }
        }
        //System.out.println("New list for position " + position);
        //newList.forEach(System.out::println);
        return newList;
    }

    private int getMostCommonBitForPosition(List<String> strings, int position) {
        int result = 1;
        int zeroCountFromList = getZeroCountFromList(strings, position);
        int onesCountFromList = getOnesCountFromList(strings, position);
        if(zeroCountFromList > onesCountFromList)
            result = 0;
        if(zeroCountFromList < onesCountFromList)
            result = 1;
        return result;
    }

    private int getLeastCommonBitForPosition(List<String> strings, int position) {
        int result = 0;
        int zeroCountFromList = getZeroCountFromList(strings, position);
        int onesCountFromList = getOnesCountFromList(strings, position);
        if(zeroCountFromList > onesCountFromList)
            result = 1;
        if(zeroCountFromList < onesCountFromList)
            result = 0;
        return result;
    }

    private int getZeroCountFromList(List<String> strings, int position) {
        int zeroCount = 0;
        int oneCount = 0;
        for(String str : strings) {
            String[] split = str.split("");
            //System.out.println(Arrays.toString(split));
            if(Integer.parseInt(split[position]) == 0) {
                zeroCount++;
            }
            if(Integer.parseInt(split[position]) == 1) {
                oneCount++;
            }
        }
        return zeroCount;
    }

    private int getOnesCountFromList(List<String> strings, int position) {
        int oneCount = 0;
        for(String str : strings) {
            String[] split = str.split("");
            //System.out.println(Arrays.toString(split));
            if(Integer.parseInt(split[position]) == 1) {
                oneCount++;
            }
        }
        return oneCount;
    }
}
