package crud.springBoard.domain.post;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Post {
    private Long id;
    private String title;
    private String article;

    public Post() {
    }

    public Post(String title, String article) {
        this.title = title;
        this.article = article;
    }
}
