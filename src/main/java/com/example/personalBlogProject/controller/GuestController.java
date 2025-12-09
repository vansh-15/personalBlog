package com.example.personalBlogProject.controller;

import com.example.personalBlogProject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GuestController {

    @Autowired
    private ArticleService service;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("articles",service.getAll());
        return "index";
    }

    @GetMapping("/article/{id}")
    public String article(@PathVariable Integer id,Model model){
        model.addAttribute("article",service.getArticle(id));
        return "article";
    }

}
