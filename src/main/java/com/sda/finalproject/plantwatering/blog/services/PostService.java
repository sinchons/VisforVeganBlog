package com.sda.finalproject.plantwatering.blog.services;

import com.sda.finalproject.plantwatering.blog.models.Post;

import java.util.List;

public interface PostService {

    List<Post> findAll();
    List<Post> findLastPosts(int limit);
    Post findById (Long id);
    Post create (Post post);
    Post edit(Post post);
    void deleteById(Long id);
    Post postToFacebook (Post post);

}
