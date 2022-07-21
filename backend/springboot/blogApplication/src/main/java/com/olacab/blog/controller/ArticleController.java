package com.olacab.blog.controller;

import com.olacab.blog.model.Article;
import com.olacab.blog.model.ArticleResponse;
import com.olacab.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping(value = "/addArticle", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ArticleResponse> ADDArticle(@RequestBody Article article) throws IOException {
        try {
            if (UserController.isLoggedIn) {
                ArticleResponse articleResponse = articleService.addArticle(article);
                if (articleResponse.isArticleAdded()) {
                    return new ResponseEntity<>(articleResponse, HttpStatus.OK);
                } else {
                    return new ResponseEntity<ArticleResponse>(articleResponse, HttpStatus.BAD_REQUEST);
                }
            } else {
                ArticleResponse articleResponse = new ArticleResponse();
                articleResponse.setArticleAdded(false);
                articleResponse.setMessage("INVALID USER!");
                return new ResponseEntity<ArticleResponse>(articleResponse, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            ArticleResponse articleResponse = null;
            return new ResponseEntity<ArticleResponse>(articleResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/getArticle", consumes = "application/json", produces = "application/json")
    public String GETArticle(@RequestParam Long articleId) throws IOException {
        //localhost:3200/getArticle?articleId=101
        return "id -> " + articleId.toString() + "";
    }

    @GetMapping(value = "/getArticle/get/{articleId}", consumes = "application/json", produces = "application/json")
    public String GETArticlePathVariable(@PathVariable Long articleId) throws IOException {
//            localhost:3200/getArticle/get/101
        return "id -> " + articleId.toString() + "";
    }
}
