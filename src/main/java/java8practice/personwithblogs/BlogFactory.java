package java8practice.personwithblogs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sca820 on 08 dec., 2022
 */
public class BlogFactory {
    public static List<Person> personList() {
        Person jack =   new Person("Jack", "UK");
        Person sara =   new Person("Sara", "USA");
        Person bob =    new Person("Bob", "IN");
        Person matt =   new Person("Matt", "UK");

        Blog javaBasics = new Blog.BlogBuilder().title("Java Constructor").type(BlogType.GUIDE).writer(jack).publishDate(LocalDate.of(2020, 12,30)).likes(100).build();
        Blog javaAnnotation = new Blog.BlogBuilder().title("Java Annotation").type(BlogType.GUIDE).writer(jack).publishDate(LocalDate.of(2021, 8,15)).likes(450).build();
        Blog javaEnum = new Blog.BlogBuilder().title("Java Enum").type(BlogType.GUIDE).writer(sara).publishDate(LocalDate.of(1983, 4,12)).likes(250).build();
        Blog javaException = new Blog.BlogBuilder().title("Java Exception").type(BlogType.GUIDE).writer(matt).publishDate(LocalDate.of(2022, 9,18)).likes(360).build();

        Blog iPhone12Review = new Blog.BlogBuilder().title("iPhone 12").type(BlogType.REVIEW).writer(matt).publishDate(LocalDate.of(2022, 4,18)).likes(450).build();
        Blog samsungS22Review = new Blog.BlogBuilder().title("Samsung S22").type(BlogType.REVIEW).writer(bob).publishDate(LocalDate.of(2022, 11,20)).likes(100).build();
        Blog iphone14Review = new Blog.BlogBuilder().title("iPhone 14").type(BlogType.REVIEW).writer(matt).publishDate(LocalDate.of(2022, 11,25)).likes(100).build();

        Blog petrolPrice = new Blog.BlogBuilder().title("Petrol Price").type(BlogType.NEWS).writer(matt).publishDate(LocalDate.of(1985, 11,25)).likes(108).build();
        Blog eLPris = new Blog.BlogBuilder().title("EL Pris").type(BlogType.NEWS).writer(bob).publishDate(LocalDate.of(2022, 12,8)).likes(120).build();
        Blog globalWarming = new Blog.BlogBuilder().title("Global Warming").type(BlogType.NEWS).writer(jack).publishDate(LocalDate.of(2022, 2,20)).likes(850).build();
        Blog schoolEducation = new Blog.BlogBuilder().title("School Education").type(BlogType.NEWS).writer(sara).publishDate(LocalDate.of(2015, 1,9)).likes(700).build();
        Blog dressCode = new Blog.BlogBuilder().title("Dress Code").type(BlogType.NEWS).writer(matt).publishDate(LocalDate.of(2018, 10,19)).build();

        jack.getBlogs().addAll(Arrays.asList(javaBasics, javaAnnotation, globalWarming));
        sara.getBlogs().addAll(Arrays.asList(javaEnum,schoolEducation));
        bob.getBlogs().addAll(Arrays.asList(samsungS22Review,eLPris));
        matt.getBlogs().addAll(Arrays.asList(javaException, iPhone12Review, iphone14Review, petrolPrice, dressCode));

        List<Person> people = new ArrayList<>();
        people.addAll(Arrays.asList(jack, sara, bob, matt));
        return people;
    }
}
