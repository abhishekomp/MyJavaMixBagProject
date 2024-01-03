package readtextfile;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeedNumberFetcher {
    public List<Long> fetchSeedNumbers(String dirName, String fileName){
        ReadTextFile readTextFile = new ReadTextFile();
        //List<String> strings = readTextFile.readTextFileFromResources("readtextfile", "SeedFile.txt");
        List<String> strings = readTextFile.readTextFileFromResources("SeedFile.txt");
        String seedLine = strings.get(0);
        String seedNumbersAsStr = seedLine.split(":")[1].trim(); //"79 14 55 13"
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(seedNumbersAsStr);
        List<Long> seedNumbers = new ArrayList<>();
        while(matcher.find()){
            //seedNumbers.add(Integer.parseInt(matcher.group(1).trim()));
            seedNumbers.add(Long.parseLong(matcher.group(1).trim()));
        }
        return seedNumbers;
    }

    public static void main(String[] args) {
        SeedNumberFetcher seedNumberFetcher = new SeedNumberFetcher();
        List<Long> seedNumbers = seedNumberFetcher.fetchSeedNumbers("day5", "Day5Part1Input.txt");
        seedNumbers.forEach(System.out::println);
    }
}
