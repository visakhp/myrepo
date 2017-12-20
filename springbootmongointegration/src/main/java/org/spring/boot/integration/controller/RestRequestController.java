package org.spring.boot.integration.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spring.boot.integration.exception.SpringBootException;
import org.spring.boot.integration.model.Article;
import org.spring.boot.integration.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConditionalOnProperty(prefix = "spring.boot.rest.controller", name = "enabled")
public class RestRequestController
{

	private static final Logger LOGGER = LogManager.getLogger(RestRequestController.class);

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/listArticles", method = RequestMethod.GET)
	public List<Article> listArticles() throws SpringBootException
	{
		try
		{
			LOGGER.info("Article(s) Listed Successfully from database..");

			return this.articleService.listArticles();

		} catch (SpringBootException e)
		{
			LOGGER.error(e);
			throw new SpringBootException("Error While fetching the data from DB. Please try again!!!");
		}

	}

	@RequestMapping(value = "/article/save", method = RequestMethod.POST)
	public String addORSaveArticle(@RequestBody @Valid Article article, BindingResult bindingResult)
			throws SpringBootException
	{
		try
		{
			if (article.getArticleID() == 0)
			{
				// new article, add it
				this.articleService.addArticle(article);
				LOGGER.info("Article Added Successfully");
				return "\"Article added Successfully\"";
			} else
			{
				// existing article, update it
				this.articleService.updateArticle(article);
				LOGGER.info("Article updated Successfully");
				return "\"Article updated Successfully\"";
			}

		} catch (SpringBootException e)
		{
			LOGGER.error(e);
			throw new SpringBootException("Error While fetching the data from DB. Please try again!!!");
		}

	}
}
