package com.mreblan.postservice.service;

import com.mreblan.postservice.models.Post;
import com.mreblan.postservice.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post savePost(Post post);

    Post updatePost(Long id, Post post);

    void deletePostById(Long id);
}
