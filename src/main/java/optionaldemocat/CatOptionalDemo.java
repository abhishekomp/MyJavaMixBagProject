package optionaldemocat;

import java.util.Optional;

/**
 * Created by sca820 on 05 nov., 2022
 * For demonstration, we have only 1 cat in our DB named FRED. Now if we try to fetch a cat by name LILY then our DAO will return a null object and we will try to invoke getAge()
 * and get NullPointerException. So the caller now need to perform null check on the returned cat object before invoking the getAge method on it.
 * A better way to avoid performing the null check is by returning an Optional to the caller.
 * With this approach, our DAO class method will return an Optinal object to the caller and caller can use the optional object to perform getAge
 */
public class CatOptionalDemo {
    public static void main(String[] args) {
        CatDAO catDAO = new CatDAO();

        String catName = "LILY";

        //Cat cat = catDAO.fetchCatByName("FRED");
        //Cat cat = catDAO.fetchCatByName("LILY");  //LILY doesn't exist in the DB

        //Optional<Cat> cat = catDAO.fetchCatByNameJava8Way("FRED");
        //Optional<Cat> cat = catDAO.fetchCatByNameJava8Way("LILY");  //LILY doesn't exist in the DB
        Optional<Cat> cat = catDAO.fetchCatByNameJava8Way(catName);  //LILY doesn't exist in the DB


        //System.out.println("Age of the cat = " + cat.getAge());
        //System.out.println("Age of the cat = " + cat.map(Cat::getAge).orElse(0));
        System.out.println("Age of the cat = " + cat.map(Cat::getAge).orElseThrow(() -> new RuntimeException(catName + " not found")));
    }
}
