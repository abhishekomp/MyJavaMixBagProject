package misc.teresiccdb;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sca820 on 02 nov., 2022
 */
public class TeresDBICCMaintainer {

    public static void main(String[] args) {
        TeresDBICCMaintainer teresDBICCMaintainer =  new TeresDBICCMaintainer();
        Set set = teresDBICCMaintainer.maintainICCCount();
        set.forEach(System.out::println);
    }

    /**
     * In Teres DB:
     * 1
     * 5
     * 6
     * 9
     * 10
     * 51
     * 52
     * 58
     *
     * Range we are allowed to pick from
     * 1-50 and then fill the teres db with new numbers not existing in db and from within the range
     *
     * Logic=?????
     *
     * fetch all icc from teres db in a Set
     * Can we check if an element exists in a Set?
     */
    public Set maintainICCCount() {
        //get the entire list of icc from the db (mimic)
        //this set mimics the entire list of icc from teres db
        Set<Integer> integersFromDB = Set.of(1, 5, 6, 9, 10, 51, 52, 58);
        return integersFromDB;
    }
}
