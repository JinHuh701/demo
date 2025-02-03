package com.example.demo.service;

import com.example.demo.entity.Like;
import com.example.demo.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public Like likePost(Long userId, Long postId) {
        Like like = new Like();
        like.setUserId(userId);
        like.setPostId(postId);
        return likeRepository.save(like);
    }
}