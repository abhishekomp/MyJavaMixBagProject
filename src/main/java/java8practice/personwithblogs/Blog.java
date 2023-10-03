package java8practice.personwithblogs;

import java.time.LocalDate;

/**
 * Created by sca820 on 08 dec., 2022
 */
public class Blog {
    private String title;
    private BlogType type;
    private LocalDate publishDate;
    private int likes;
    private Person writer;

    public String getTitle() {
        return title;
    }
    public BlogType getType() {
        return type;
    }
    public LocalDate getPublishDate() {
        return publishDate;
    }
    public int getLikes() {
        return likes;
    }
    public Person getWriter() {
        return writer;
    }
    private Blog(BlogBuilder builder) {
        this.title = builder.title;
        this.type = builder.type;
        this.publishDate = builder.publishDate;
        this.likes = builder.likes;
        this.writer = builder.writer;
    }

    public static class BlogBuilder {
        private String title;
        private BlogType type;
        private LocalDate publishDate;
        private int likes;
        private Person writer;

//        public BlogBuilder(int blogId, String title, LocalDate publishDate, Person writer) {
//            this.blogId = blogId;
//            this.title = title;
//            this.publishDate = publishDate;
//            this.writer = writer;
//        }

        public BlogBuilder title(final String title){
            this.title = title;
            return this;
        }

        public BlogBuilder type(final BlogType type){
            this.type = type;
            return this;
        }

        public BlogBuilder publishDate(final LocalDate publishDate){
            this.publishDate = publishDate;
            return this;
        }

        public BlogBuilder likes(final int likes){
            this.likes = likes;
            return this;
        }

        public BlogBuilder writer(final Person person) {
            this.writer = writer;
            return this;
        }

        public Blog build() {
            return new Blog(this);
        }
    }
}
