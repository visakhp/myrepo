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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

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
	public Object addORSaveArticle(@RequestBody @Valid Article article, BindingResult bindingResult)
			throws SpringBootException, JsonProcessingException
	{
		try
		{
			if (bindingResult.hasErrors())
			{
				List<FieldError> errors = bindingResult.getFieldErrors();
				LOGGER.error("Request is Invalid: ", errors);

				return errors;
			}

			else
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
			}

		} catch (SpringBootException e)
		{
			LOGGER.error(e);
			throw new SpringBootException("Error While fetching the data from DB. Please try again!!!");
		}

	}

	@RequestMapping(value = "/editArticle/{articleId}", method = RequestMethod.GET)
	public Article editArticle(@PathVariable("articleId") int articleId) throws SpringBootException
	{
		try
		{
			Article article = this.articleService.getArticleById(articleId);

			return article;

		} catch (SpringBootException ex)
		{
			LOGGER.error("Error While reteriving article from database for articleId:{}. Exception: {}", articleId, ex);
			throw new SpringBootException("Error While reteriving article from database. Please try again!!!");
		}
	}

}
