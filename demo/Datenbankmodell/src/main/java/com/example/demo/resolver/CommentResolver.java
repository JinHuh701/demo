package com.example.demo.resolver;

import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CommentResolver {

    @Autowired
    private CommentService commentService;

    @QueryMapping
    public List<Comment> getCommentsByPost(@Argument Long postId) {
        return commentService.getCommentsByPost(postId);
    }

    @MutationMapping
    public Comment commentPost(@Argument Long userId, @Argument Long postId, @Argument String content) {
        return commentService.commentPost(userId, postId, content);
    }
}