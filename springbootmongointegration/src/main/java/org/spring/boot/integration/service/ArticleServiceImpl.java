package org.spring.boot.integration.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.spring.boot.integration.dao.ArticleDAO;
import org.spring.boot.integration.exception.SpringBootException;
import org.spring.boot.integration.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author visakh
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDAO articleDao;

	@Transactional
	public void addArticle(Article article) throws SpringBootException {
		article.setEneteredDate(new Date());
		this.articleDao.addArticle(article);
	}

	@Transactional
	public void updateArticle(Article article) throws SpringBootException {
		if (article.getArticleStatus().equals("Edited"))
			article.setEdited(true);
		else if (article.getArticleStatus().equals("Published"))
			article.setPublished(true);
		else if (article.getArticleStatus().equals("QA"))
			article.setQA(true);

		this.articleDao.updateArticle(article);
	}

	@Transactional
	public List<Article> listArticles() throws SpringBootException {
		List<Article> articles = new ArrayList<Article>();
		for (Article article : this.articleDao.listArticles()) {
			article.setArticleStatus(getArticleStatus(article));
			articles.add(article);
		}
		return articles;
	}

	@Transactional
	public Article getArticleById(int articleId) throws SpringBootException {
		return this.articleDao.getArticleById(articleId);
	}

	private String getArticleStatus(Article article) {
		StringBuffer sb = new StringBuffer();
		if (article.isQA()) {
			return sb.append("QA").toString();
		} else if (article.isPublished()) {
			return sb.append("Published").toString();
		} else if (article.isEdited()) {
			sb.append("Edited").toString();
		} else {
			sb.append("NA");
		}

		return sb.toString();
	}

}
