package com.mreblan.postservice.service.impl;

import com.mreblan.postservice.models.Post;
import com.mreblan.postservice.repository.PostRepository;
import com.mreblan.postservice.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;


    @Override
    public List<Post> getAllPosts() {
        String logMessage = "All posts returned";
        log.info(logMessage);

        return repository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        String logMessage = String.format("Post with id -- %d -- returned", id);
        log.info(logMessage);

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post with id -- " + id + " -- not found"));
    }

    @Override
    public Post savePost(Post post) {
        String logMessage = String.format("Post saved:\n%s", post.toString());
        log.info(logMessage);

        return repository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post) {
        String logMessage = String.format("Post updated:\n%s", post.toString());
        log.info(logMessage);

        return  repository.save(post);
    }

    @Override
    public void deletePostById(Long id) {
        String logMessage = String.format("Post witd id -- %d -- deleted", id);
        log.info(logMessage);

        repository.deleteById(id);
    }
}
