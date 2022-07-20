package com.olacab.blog.service;

import com.olacab.blog.model.Article;
import com.olacab.blog.model.ArticleResponse;
import com.olacab.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    public ArticleResponse addArticle(Article article) {
        Article newArticle=articleRepository.save(article);
        ArticleResponse response = new ArticleResponse();
        if(newArticle!=null){
            response.setArticleAdded(true);
            response.setMessage("Article added successfully");
        }else{
            response.setArticleAdded(false);
            response.setMessage("Article could not be added");
        }
        return response;
    }

    public Article getArticle(Long articleId) {
        Article article=articleRepository.findByArticleId(articleId);
        return article;
    }
}
