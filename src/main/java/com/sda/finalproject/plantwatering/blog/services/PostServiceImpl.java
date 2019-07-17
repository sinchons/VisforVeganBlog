package com.sda.finalproject.plantwatering.blog.services;

import com.sda.finalproject.plantwatering.blog.models.Post;
import com.sda.finalproject.plantwatering.blog.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
//UserPostService and AdminPostService, lai saprotami
public class PostServiceImpl implements PostService {

    //kamer nav datubaze, ka fake pieprasijums no datubazes
//    public User getDUmmyUser(){
//        User user = new User(email);
//        user.setNameSurname("Dummy NameSurname");
//        user.setUsername("Elephant Fairy");
//        return user;
//    }

    public List<Post> getDummyPosts(){
        List<Post> posts = new ArrayList<>();
        Post posttest = new Post();
        posttest.setTitle("testtitle");
        posttest.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa " +
                "qui officia deserunt mollit anim id est laborum.");
        posts.add(posttest);
        Post posttest2 = new Post();
        posttest2.setTitle("testtitle2");
        posttest2.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris " +
                "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa " +
                "qui officia deserunt mollit anim id est laborum.");
        posts.add(posttest2);
        return posts;
    }

    @Override
    public List<Post> findAll() {
        return this.getDummyPosts();
    }

    @Override
    public List<Post> findLastPosts(int limit) {
        return this.getDummyPosts().stream()
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))

                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public Post findById(Long id) {
        return this.getDummyPosts().stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post create(Post post) {
        return null;
    }

    @Override
    public Post edit(Post post) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Post postToFacebook(Post post) {
        return null;
    }
}
