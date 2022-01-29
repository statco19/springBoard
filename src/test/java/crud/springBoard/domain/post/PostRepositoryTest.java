package crud.springBoard.domain.post;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {

    PostRepository postRepository = new PostRepository();

    @AfterEach
    void afterEach() {
        postRepository.clearRepo();
    }

    @Test
    void save() {
        Post post = new Post("my title", "my article");
        postRepository.save(post);
        Post savedPost = postRepository.findById(post.getId());

        assertThat(savedPost).isEqualTo(post);
    }

    @Test
    void findAll() {
        Post post1 = new Post("my title1", "my article1");
        Post post2 = new Post("my title2", "my article2");
        postRepository.save(post1);
        postRepository.save(post2);

        List<Post> posts = postRepository.findAll();

        assertThat(posts.size()).isEqualTo(2);
        assertThat(posts).contains(post1, post2);
    }

    @Test
    void update() {
        Post post = new Post("my title", "my article");
        postRepository.save(post);

        Post newPost = new Post("update title", "update article");
        postRepository.update(post.getId(), newPost);
        Post foundPost = postRepository.findById(post.getId());

        assertThat(foundPost.getId()).isEqualTo(post.getId());
        assertThat(foundPost.getTitle()).isEqualTo(post.getTitle());
        assertThat(foundPost.getArticle()).isEqualTo(post.getArticle());
    }
}