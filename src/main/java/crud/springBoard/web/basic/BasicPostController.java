package crud.springBoard.web.basic;

import crud.springBoard.domain.post.Post;
import crud.springBoard.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("basic/posts")
@RequiredArgsConstructor
public class BasicPostController {

    private final PostRepository postRepository;

    @GetMapping
    public String posts(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);

        return "basic/posts";
    }

    @PostConstruct
    public void init() {
        postRepository.save(new Post("titleA", "my first post."));
        postRepository.save(new Post("titleB", "my second post."));
    }
}
