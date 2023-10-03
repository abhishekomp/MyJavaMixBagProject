package optionaldemocat;

import java.util.Optional;

/**
 * Created by sca820 on 05 nov., 2022
 * This is a class that mimics fetching object from DB
 */
public class CatDAO {
    public Cat fetchCatByName(String name) {
        if("FRED".equals(name)) {
            Cat cat = new Cat(name, 3);
            return cat;
        }
        return null;
    }

    public Optional<Cat> fetchCatByNameJava8Way(String name) {
        if("FRED".equals(name)) {
            Cat cat = new Cat(name, 3);
            return Optional.ofNullable(cat);
        }
        return Optional.empty();
    }
}
