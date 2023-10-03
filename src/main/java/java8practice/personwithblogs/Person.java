package java8practice.personwithblogs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sca820 on 08 dec., 2022
 */
public class Person {
    private final String name;
    private final String fromCountry;
    private List<Blog> blogs;

    public Person(String name, String fromCountry) {
        this.name = name;
        this.fromCountry = fromCountry;
        this.blogs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getFromCountry() {
        return fromCountry;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }
}
