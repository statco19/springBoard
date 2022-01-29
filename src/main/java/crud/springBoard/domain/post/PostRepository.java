package crud.springBoard.domain.post;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepository {

    private static final Map<Long, Post> repo = new HashMap<>();
    private static Long sequence = 0L;

    public Post save(Post post) {
        post.setId(++sequence);
        repo.put(post.getId(), post);

        return post;
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
