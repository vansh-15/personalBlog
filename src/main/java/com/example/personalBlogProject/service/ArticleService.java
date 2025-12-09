package com.example.personalBlogProject.service;

import com.example.personalBlogProject.Article;
import com.example.personalBlogProject.repo.ArticleRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepo repo;

    public List<Article> getAll() {
        return repo.findAll();
    }

    public Article getArticle(Integer id) {
        return repo.findById(id).orElse(null);
    }


    public void save(Article article) {
        repo.save(article);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
