package java8practice.personwithblogs;

import org.junit.jupiter.api.Test;

import java.util.List;

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

}
