package com.example.personalBlogProject.controller;

import com.example.personalBlogProject.Article;
import com.example.personalBlogProject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ArticleService service;

    @GetMapping("/dashboard")
    public String dash(Model model){
        model.addAttribute("articles",service.getAll());
        return "admin/dashboard";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("article",new Article());
        return "admin/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Article article){
        service.save(article);
        return "redirect:admin/dashboard";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Article article){
        service.save(article);
        return "redirect:admin/dashboard";
    }

    @DeleteMapping("/deleted/{id}")
    public String delete(@PathVariable int id){
        service.delete(id);
        return "redirect:admin/dashboard";
    }

}
