package crud.springBoard.domain.post;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Repository
public class PostRepository {

    private static final Map<Long, Post> repo = new HashMap<>();
    private static Long sequence = 0L;

    public String save(Post post) {
        post.setId(++sequence);

        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        String timeSaved = dtf4.format(LocalDateTime.now());
        post.setTimeStamp(timeSaved);

        repo.put(post.getId(), post);
        return timeSaved;
    }

    public Post findById(Long id) {
        Post post = repo.get(id);
        return post;
    }

    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>(repo.values());
        return posts;
    }

    public void update(Long id, Post newPost) {
        Post oldPost = repo.get(id);
        oldPost.setTitle(newPost.getTitle());
        oldPost.setArticle(newPost.getArticle());
    }

    public void clearRepo() {
        repo.clear();
    }
}
