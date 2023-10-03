package corefundamentals.collectionshipment;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnmodifiableMapDemo {
    public static void main(String[] args) {

        Map<String, Integer> mutableCountryToPopulation = new HashMap<>();
        mutableCountryToPopulation.put("UK", 67);
        mutableCountryToPopulation.put("USA", 467);

        Map<String, Integer> unModifiableCountryToPopulation = Collections.unmodifiableMap(mutableCountryToPopulation);
        System.out.println("unModifiableCountryToPopulation = " + unModifiableCountryToPopulation);
        //unModifiableCountryToPopulation.put("Sweden", 110);
        mutableCountryToPopulation.put("Sweden", 110);
        System.out.println("unModifiableCountryToPopulation = " + unModifiableCountryToPopulation);

    }
}
