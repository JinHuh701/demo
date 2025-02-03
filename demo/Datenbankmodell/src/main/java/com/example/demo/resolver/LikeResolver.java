package com.example.project.resolver;

import com.example.project.entity.Like;
import com.example.project.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LikeResolver {

    @Autowired
    private LikeService likeService;

    @QueryMapping
    public List<Like> getLikesByPost(@Argument Long postId) {
        return likeService.getLikesByPost(postId);
    }

    @MutationMapping
    public Like likePost(@Argument Long userId, @Argument Long postId) {
        return likeService.likePost(userId, postId);
    }
}