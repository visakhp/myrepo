package org.spring.boot.integration.dao;

import java.util.List;

import org.spring.boot.integration.exception.SpringBootException;
import org.spring.boot.integration.model.Article;
import org.spring.boot.integration.util.MongoNextSequenceUtil;
import org.spring.boot.integration.util.Util;
import org.springframework.beans.factory.annotation.Autowired;

public class MongoArticleDAOImpl implements ArticleDAO {

	@Autowired
	private ArticleRepository repository;

	@Autowired
	private MongoNextSequenceUtil nextSquenceService;

	public void addArticle(Article article) throws SpringBootException {
		article.setArticleID(nextSquenceService.getNextSequence(Util.SEQUENCE_KEY));
		repository.insert(article);
	}

	public void updateArticle(Article article) throws SpringBootException {
		repository.save(article);
	}

	public List<Article> listArticles() throws SpringBootException {
		List<Article> articleList = repository.findAll();
		return articleList;
	}

	public Article getArticleById(int articleId) {
		Article article = repository.getArticleByID(articleId);
		return article;
	}

}
