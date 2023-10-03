package java8practice.miscOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sca820 on 15 sep., 2022
 * Purpose of this class is to fetch N number of ICCIDs from the ICCID database. But there are some ICCIDs in the database that are not clean, we must pick only clean ICCIDs
 * How to know which ICCIDs are clean. There is another service that given an ICCID can tell if the ICCID is clean or not.
 */
public class ValidICCIDPicker {

    public static Map<String, String> getIccDb() {
        Map<String, String> iccFetchedStatusMap = new HashMap<>();
        iccFetchedStatusMap.put("11111", "FREE");
        iccFetchedStatusMap.put("22222", "FREE");
        iccFetchedStatusMap.put("33333", "FREE");
        iccFetchedStatusMap.put("44444", "FREE");
        iccFetchedStatusMap.put("55555", "FREE");
        iccFetchedStatusMap.put("66666", "FREE");
        return iccFetchedStatusMap;
    }

    public static Map<String, String> getIccStateMap() {
        Map<String, String> iccStateMap = new HashMap<>();
        iccStateMap.put("11111", "CLEAN");
        iccStateMap.put("22222", "DIRTY");
        iccStateMap.put("33333", "DIRTY");
        iccStateMap.put("44444", "CLEAN");
//        iccStateMap.put("55555", "FREE");
        iccStateMap.put("66666", "DIRTY");
        return iccStateMap;
    }

    public List<String> getICCs(int numOfICCNeeded) {
        List<String> fetchedICCList = new ArrayList<>();
        for(int i = 0; i < numOfICCNeeded; i++) {

        }
        return fetchedICCList;
    }
}
