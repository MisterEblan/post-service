package com.mreblan.postservice.controllers;

import com.mreblan.postservice.models.Post;
import com.mreblan.postservice.service.impl.PostServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/posts")
public class PostController {

    private PostServiceImpl service;

    @GetMapping
    public List<Post> getAllPosts() {
        return service.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return service.getPostById(id);
    }

    @PostMapping("/create_post")
    public String createPost(@RequestBody Post postToCreate) {
        service.savePost(postToCreate);

        return "Post created!";
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return service.updatePost(id, post);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        service.deletePostById(id);

        return "Post deleted!";
    }
}
