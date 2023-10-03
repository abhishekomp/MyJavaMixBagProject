package java8practice.blogpost;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.*;

class BlogPostTest {

    List<BlogPost> blogPosts = List.of(
            new BlogPost("Java String", "Bill", BlogPostType.GUIDE, 20),
            new BlogPost("Java Enum", "Jack", BlogPostType.GUIDE, 40),
            new BlogPost("Iphone 14 Review", "Sara", BlogPostType.REVIEW, 20),
            new BlogPost("Samsung S22 Review", "Michael", BlogPostType.REVIEW, 20),
            new BlogPost("Petrol Price", "Ted", BlogPostType.NEWS, 20),
            new BlogPost("President Election", "Bill", BlogPostType.NEWS, 80),
            new BlogPost("Sony Experia Review", "Thomas", BlogPostType.REVIEW, 30),
            new BlogPost("Dell Merger", "Johan", BlogPostType.NEWS, 40),
            new BlogPost("Chromebook Review", "Matt", BlogPostType.REVIEW, 50)
    );

    @Test
    //Given a list of blogposts of different types, find the average likes per type of blogpost i.e. avergage likes for GUIDE, REVIEW, NEWS and so on
    //Done
    public void getAverageLikesPerBlogPostType() {
        final Map<BlogPostType, Double> collect = blogPosts.stream()
                .collect(groupingBy(BlogPost::getType, averagingInt(BlogPost::getLikes)));
        System.out.println("collect = " + collect);
    }

    @Test
    //Given a list of blogposts of different types, find the SUM of likes per type of blogpost i.e. SUM of likes for GUIDE, REVIEW, NEWS and so on
    //Done
    public void getSumOfLikesPerBlogPostType() {
        final Map<BlogPostType, Integer> collect = blogPosts.stream()
                .collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)));
        System.out.println("collect = " + collect);
    }

    @Test
    //Given a list of blogposts of different types, create a map with key as blogpost type and value as the post with maximum likes in that group
    //Done with question
    //Question: What if there are more than 1 post in a group with same count of max likes
    public void getMaximumOfLikesPerBlogPostType() {
        final Map<BlogPostType, Optional<BlogPost>> collect = blogPosts.stream()
                .collect(groupingBy(BlogPost::getType, maxBy(comparingInt(BlogPost::getLikes))));
        System.out.println("collect = " + collect);
    }

    @Test
    //Given a list of blogposts of different types, create a map with key as blogpost type and value as the post with maximum likes in that group
    //Done
    //Question: What if there are more than 1 post in a group with same count of max likes
    public void getNameOfBlogPostWithMaxLikePerBlogPostType() {
        final Map<BlogPostType, String> collect = blogPosts.stream()
                .collect(groupingBy(BlogPost::getType, collectingAndThen(maxBy(comparingInt(BlogPost::getLikes)), post -> post.map(BlogPost::getTitle).orElse("Not found"))));
        System.out.println("collect = " + collect);
    }
}