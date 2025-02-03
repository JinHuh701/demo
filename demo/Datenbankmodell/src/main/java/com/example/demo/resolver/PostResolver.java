package com.example.demo.resolver;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PostResolver {

    @Autowired
    private PostService postService;

    @QueryMapping
    public List<Post> getPostsByUser(@Argument Long userId) {
        return postService.getPostsByUser(userId);
    }

    @MutationMapping
    public Post createPost(@Argument Long userId, @Argument String content) {
        return postService.createPost(userId, content);
    }
}