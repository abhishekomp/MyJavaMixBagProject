package adventofcode2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class SolutionAdventOfCode13Dec2020 {
    public static void main(String[] args) {
        SolutionAdventOfCode13Dec2020 solutionAdventOfCode13Dec2020 = new SolutionAdventOfCode13Dec2020();
        //solutionAdventOfCode13Dec2020.solve_adventOfCode2020_13Dec_part1();

        solutionAdventOfCode13Dec2020.solve_adventOfCode2020_13Dec_part2();
    }

    public void solve_adventOfCode2020_13Dec_part1() {
        int base = 1003055;
        List<Integer> busList = List.of(37, 41, 433, 23, 17, 19, 29, 593, 13);

        int nearestFactorAheadBy = 0;
        Map<Integer, Integer> nearestMap = new HashMap<>();

        for(Integer i : busList) {
            nearestFactorAheadBy = i - (base % i);
            nearestMap.put(i, nearestFactorAheadBy);
        }

        final Map<Integer, Integer> collect = nearestMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> newVal,
                        LinkedHashMap::new
                ));
        System.out.println("nearestMap = " + nearestMap);
        System.out.println("Final sorted Map = " + collect);
        final Integer key = collect.entrySet().iterator().next().getKey();
        System.out.println("key = " + key);
    }

    public void solve_adventOfCode2020_13Dec_part2() {

        List<String> strings = readFile("./input13Dec.txt");

//        List<String> strings = List.of("17", "x", "13", "19");
//        List<String> strings = List.of("67", "7", "59", "61");
//        List<String> strings = List.of("67", "7", "x", "59", "61");
//        List<String> strings = List.of("1789", "37", "47", "1889");

        Map<Integer, Integer> ruleMap = new LinkedHashMap<>();
        for(int i = 0; i < strings.size(); i++) {
            if(isNumeric(strings.get(i))) {
                ruleMap.put(Integer.valueOf(strings.get(i)), i);
            }
        }
        System.out.println("ruleMap = " + ruleMap);
        Integer seed = ruleMap.keySet().stream().findFirst().get();

        //Create a sub map which contains all entries except the 1st entry of ruleMap
        final Map<Integer, Integer> residualMap = ruleMap.entrySet().stream()
                .filter(x -> !x.getKey().equals(seed))
                .collect(toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new
                    )
                );
        System.out.println("residualMap = " + residualMap);

        long first = Stream.iterate(100000000000000L, n -> n + 37)
                .parallel()
                .filter(number -> checkNumber(number, residualMap))
                .findFirst()
                .orElse(0L);

        System.out.println("first = " + first);


//        for(Map.Entry<Integer, Integer> entry : residualMap.entrySet()) {
//            Function<Map.Entry<Integer,Integer>, Predicate<Integer>> function = e -> number -> ((number + e.getValue()) % e.getKey() == 0);
//        }

        //BiFunction<Integer, Integer, Predicate<Integer>> biFunction = (multiple, )

    }

    List<String> readFile(String fileName) {
        List<String> strings = new ArrayList<>();

        try(BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            String line = reader.readLine();
            line = reader.readLine();
            line.split(",");
            strings.addAll(Arrays.asList(line.split(",")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    //the real magic
    private boolean checkNumber(long n, Map<Integer, Integer> residualMap) {
        boolean passesCondition = true;

        for(Map.Entry<Integer, Integer> entry : residualMap.entrySet()) {
            if((n + entry.getValue()) % entry.getKey() != 0) {
                passesCondition = false;
                break;
            }
        }
        System.out.println("For " + n + " result of checkNumber = " + passesCondition);
        return passesCondition;
    }

    //https://stackabuse.com/java-check-if-string-is-a-number/
    private static boolean isNumeric(String string) {
        int intValue;

        //System.out.println(String.format("Parsing string: \"%s\"", string));

        if (string == null || string.equals("")) {
            //System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            //System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }
}
