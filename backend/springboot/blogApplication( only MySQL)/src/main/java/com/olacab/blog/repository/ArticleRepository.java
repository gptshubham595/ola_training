package com.olacab.blog.repository;

import com.olacab.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Article findByArticleId(long articleId);
    Article findByUserId(String userId);
}
