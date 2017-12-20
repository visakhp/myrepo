package org.spring.boot.integration.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.spring.boot.integration.exception.SpringBootException;
import org.spring.boot.integration.model.Article;

/**
 * 
 * @author visakh
 *
 */
public class MySQLArticleDAOImpl implements ArticleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void addArticle(Article article) throws SpringBootException {
		entityManager.persist(article);
	}

	public void updateArticle(Article article) throws SpringBootException {
		entityManager.merge(article);
	}

	@SuppressWarnings("unchecked")
	public List<Article> listArticles() throws SpringBootException {
		List<Article> articleList = entityManager.createQuery("from Article").getResultList();
		return articleList;
	}

	public Article getArticleById(int articleId) {
		Article article = entityManager.find(Article.class, articleId);
		return article;
	}

}
