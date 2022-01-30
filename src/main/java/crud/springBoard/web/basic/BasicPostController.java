package crud.springBoard.web.basic;

import crud.springBoard.domain.post.Post;
import crud.springBoard.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/posts")
@RequiredArgsConstructor
public class BasicPostController {

    private final PostRepository postRepository;

    @GetMapping
    public String posts(Model model) {
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);

        return "basic/posts";
    }

    @GetMapping("/{postId}")
    public String postDetail(@PathVariable Long postId, Model model) {
        Post post = postRepository.findById(postId);
        model.addAttribute("post", post);

        return "basic/post";
    }

    @GetMapping("/upload-post")
    public String upload() {
        return "basic/uploadPost";
    }

    @PostMapping("/upload-post")
    public String uploadPost(@ModelAttribute Post post, RedirectAttributes redirectAttributes) {
        postRepository.save(post);
        redirectAttributes.addAttribute("postId", post.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/posts/{postId}";
    }

    @PostConstruct
    public void init() {
        postRepository.save(new Post("titleA", "my first post."));
        postRepository.save(new Post("titleB", "my second post."));
    }
}
