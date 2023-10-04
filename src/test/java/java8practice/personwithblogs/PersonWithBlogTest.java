package java8practice.personwithblogs;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by sca820 on 08 dec., 2022
 */
public class PersonWithBlogTest {

    @Test
    void should_get_all_blog_titles_written_by_given_author() {
        String author = "Sara";
        List<String> list = BlogFactory.personList().stream()
                .filter(e -> e.getName().equals(author))
                .flatMap(p -> p.getBlogs().stream())
                .map(Blog::getTitle)
                .collect(toList());
        list.forEach(System.out::println);
        assertThat(list).containsExactlyInAnyOrder("Java Enum", "School Education");
    }

    /**
     * Given a list of person give me a list of their first name.
     * This is a one-to-one function which means for every person their is one first name.
     * Hence, after applying map function to a person we get the first name which we collect in a List of firstNames
     * Another example: Given a list of 3 integers, get me a list that has double the value of integer in the input list
     * Stream<T>.map(f11) --> Stream<R>
     * This result when finally collected is a list of numbers doubled (i.e. a list of integers is our result)
     */
    @Test
    void test_one_to_function_on_a_list_of_integers() {
        List<Integer> integers = List.of(1, 2, 3);
        List<Integer> resultList = integers.stream()
                .map(e -> e * 2)
                .collect(toList());
        System.out.println(resultList); //Output: [2, 4, 6]
    }

    /**
     * FlatMap example
     * Given a list of person, give me the list of all their email addresses. One person can have multiple email addresses.
     * In this case, applying map to a person object will give us a list of email address per person.
     * So the mapping function is one-to-many in this case.
     * Stream<Person>.map(f1n) --> Stream<List<EmailAddress>>
     * This result when finally collected is a list of list of emails (i.e. a list containing multiple lists)
     * But I want a big list of all emails.
     * In such case we have to use flatMap()
     * Question is: If you have a Stream of T and the mapping function produces a list for each T then use flatMap()
     * Stream<T>.flatMap(f1n) --> Stream<R>
     */
    @Test
    void test_one_to_many_function_on_a_list_of_integers() {
        List<Integer> integers = List.of(1, 2, 3);
        List<List<Integer>> resultList = integers.stream()
                .map(e -> List.of(e - 1, e + 1))
                .collect(toList());
        System.out.println(resultList); //Output: [[0, 2], [1, 3], [2, 4]]

        List<Integer> collect = integers.stream()
                .flatMap(e -> List.of(e - 1, e + 1).stream())
                .collect(toList());
        System.out.println("collect = " + collect);
    }
}
