package adventofcode2021.sixthdecember;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sixthdecember {

    public static void main(String[] args) {
        Sixthdecember sixthdecember = new Sixthdecember();
        sixthdecember.partOne();
    }

    public void partOne() {
        //List<Integer> numList = List.of(3,4,3,1,2);
        List<Integer> numList = List.of(5,1,1,5,4,2,1,2,1,2,2,1,1,1,4,2,2,4,1,1,1,1,1,4,1,1,1,1,1,5,3,1,4,1,1,1,1,1,4,1,5,1,1,1,4,1,2,2,3,1,5,1,1,5,1,1,5,4,1,1,1,4,3,1,1,1,3,1,5,5,1,1,1,1,5,3,2,1,2,3,1,5,1,1,4,1,1,2,1,5,1,1,1,1,5,4,5,1,3,1,3,3,5,5,1,3,1,5,3,1,1,4,2,3,3,1,2,4,1,1,1,1,1,1,1,2,1,1,4,1,3,2,5,2,1,1,1,4,2,1,1,1,4,2,4,1,1,1,1,4,1,3,5,5,1,2,1,3,1,1,4,1,1,1,1,2,1,1,4,2,3,1,1,1,1,1,1,1,4,5,1,1,3,1,1,2,1,1,1,5,1,1,1,1,1,3,2,1,2,4,5,1,5,4,1,1,3,1,1,5,5,1,3,1,1,1,1,4,4,2,1,2,1,1,5,1,1,4,5,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,4,2,1,1,1,2,5,1,4,1,1,1,4,1,1,5,4,4,3,1,1,4,5,1,1,3,5,3,1,2,5,3,4,1,3,5,4,1,3,1,5,1,4,1,1,4,2,1,1,1,3,2,1,1,4);
        List<Integer> updatedList = new ArrayList<>();

        for(int i = 1; i < 257; i++) {
            System.out.println("Iteration " + i);
            if(i > 1) {
                numList = updatedList;
            }
            updatedList = createUpdatedList(numList);
            System.out.println("updatedList element count = " + updatedList.size());
        }
        //System.out.println("updatedList element count = " + updatedList.size());
    }

    private List<Integer> createUpdatedList(List<Integer> numList) {
        int numOfNewElementsToAdd = 0;
        //System.out.println("numList = " + numList);
        int zeroCount = numList.stream().filter(x -> x == 0).collect(Collectors.toList()).size();
        //System.out.println("zeroCount = " + zeroCount);

        List<Integer> updatedList = new ArrayList<>();

//        List<Integer> updatedList = numList.stream()
//                .map(x -> {
//            if(x > 0) {
//                x = x - 1;
//            }
//        return x;
//        }).collect(Collectors.toList());
//        int size = updatedList.size();

        for(Integer x : numList) {
            if(x > 0) {
                updatedList.add(x-1);
            }
            if(x==0) {
                updatedList.add(6);
            }
        }

//        updatedList = updatedList.stream().map(x -> {
//            if(x==0) {
//                x = 6;
//            }
//        return x;}).collect(Collectors.toList());

        for(int j = 1 ; j <= zeroCount; j++) {
            updatedList.add(8);
        }

        //System.out.println("updatedList = " + updatedList);
        return updatedList;
    }


}
