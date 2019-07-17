package com.sda.finalproject.plantwatering.blog.controllers;

import com.sda.finalproject.plantwatering.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String getLastPosts(Model model) {
         model.addAttribute("latestposts", this.postService.findLastPosts(3));
         return "posts";
    }
}
