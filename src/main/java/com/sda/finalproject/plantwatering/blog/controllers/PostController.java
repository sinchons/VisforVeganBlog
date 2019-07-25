package com.sda.finalproject.plantwatering.blog.controllers;

import com.sda.finalproject.plantwatering.blog.models.Post;
import com.sda.finalproject.plantwatering.blog.models.User;
import com.sda.finalproject.plantwatering.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    private PostService postService;


    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String getAllPosts(Model model) {
        model.addAttribute("allposts", this.postService.findAll());
        model.addAttribute("latestposts", this.postService.findLastPosts(3));
        return "posts";
    }

    @GetMapping("/createpost")
    private String createPost(Model model) {
        model.addAttribute("newPost", new Post());
        return "createpost";
    }

    @PostMapping("/createpost")
    private String createNewPost(Post post, Model model) {
        postService.create(post);
//        model.addAttribute("saveOk", "Post is saved!");
//        model.addAttribute("newPost", new Post());
        return "redirect:/posts";
    }

    @GetMapping("/editpost/{id}")
    private String editPost(@PathVariable long id, Model model) {
        model.addAttribute("newPost", postService.findById(id));
        return "editpost";
    }

    @PostMapping("/editpost")
    private String editPost(Post post, Model model) {
        postService.edit(post);
        model.addAttribute("saveOk", "Post is updated!");
        model.addAttribute("newPost", new Post());
        return "redirect:/posts";
    }

    @GetMapping("/delete/{id}")
    private String deletePost(@PathVariable long id) {
        postService.deleteById(id);
        return "redirect:/posts";
    }


}
