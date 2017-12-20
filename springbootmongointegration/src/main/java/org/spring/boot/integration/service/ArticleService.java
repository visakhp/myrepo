package org.spring.boot.integration.service;

import java.util.List;

import org.spring.boot.integration.exception.SpringBootException;
import org.spring.boot.integration.model.Article;

/**
 * 
 * @author visakh
 *
 */
public interface ArticleService {

	public void addArticle(Article article) throws SpringBootException;

	public void updateArticle(Article article) throws SpringBootException;

	public List<Article> listArticles() throws SpringBootException;

	public Article getArticleById(int articleId) throws SpringBootException;

}
