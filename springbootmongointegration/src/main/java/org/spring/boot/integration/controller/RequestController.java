package org.spring.boot.integration.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spring.boot.integration.exception.SpringBootException;
import org.spring.boot.integration.model.Article;
import org.spring.boot.integration.service.ArticleService;
import org.spring.boot.integration.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author visakh
 * 
 *         Rest Service to handle all the requests.
 * 
 */
@Controller
@ConditionalOnProperty(prefix = "spring.boot.controller", name = "enabled", matchIfMissing = true)
public class RequestController
{
	private static final Logger LOGGER = LogManager.getLogger(RequestController.class);

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome(Model model) throws SpringBootException
	{
		LOGGER.info("Redirecting to Article Page.....");
		return "redirect:/articles";
	}

	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public String listArticles(Model model) throws SpringBootException
	{
		try
		{
			model.addAttribute("article", new Article());
			model.addAttribute("listArticles", this.articleService.listArticles());
			model.addAttribute("news", Util.getArticleType());
			LOGGER.info("Article Listed Successfully from database");
			return "article";
		} catch (SpringBootException e)
		{
			LOGGER.error(e);
			throw new SpringBootException("Error While fetching the data from DB. Please try again!!!");
		}

	}

	// For add and update person both
	@RequestMapping(value = "/article/add", method = RequestMethod.POST)
	public String addOrUpdateArticle(@RequestParam(required = false, value = "save") String saveFlag,
			@ModelAttribute("article") @Valid Article article, BindingResult result, Model model)
			throws SpringBootException
	{
		try
		{
			if (saveFlag != null)
			{
				if (result.hasErrors())
				{
					model.addAttribute("listArticles", this.articleService.listArticles());
					List<String> tempArticleType = Util.getArticleType();

					if (article.getNews() != null && !article.getNews().equals(StringUtils.EMPTY))
						tempArticleType.remove(article.getNews());

					model.addAttribute("news", tempArticleType);
					model.addAttribute("articleStatus", Util.getArticleStatus());
					model.addAttribute("article", article);
					return "article";
				}
				if (article.getArticleID() == 0)
				{
					// new article, add it
					this.articleService.addArticle(article);
					LOGGER.info("Article Added Successfully");
				} else
				{
					// existing article, call update
					this.articleService.updateArticle(article);
					LOGGER.info("Article Updated Successfully");
				}
			}
			return "redirect:/articles";
		} catch (SpringBootException ex)
		{
			LOGGER.error("Error While Adding/Updating Articles. Exception: ", ex);
			throw new SpringBootException("Error While Adding/Updating Articles. Please try again!!!");
		}

	}

	@RequestMapping("/edit/{articleId}")
	public String editPerson(@PathVariable("articleId") int articleId, Model model) throws SpringBootException
	{
		try
		{
			Article tempArticle = this.articleService.getArticleById(articleId);
			model.addAttribute("article", tempArticle);
			model.addAttribute("listArticles", this.articleService.listArticles());

			List<String> tempArticleType = Util.getArticleType();
			tempArticleType.remove(tempArticle.getNews());

			model.addAttribute("news", tempArticleType);
			model.addAttribute("articleStatus", Util.getArticleStatus());
		} catch (SpringBootException ex)
		{
			LOGGER.error("Error While Adding/Updating Articles. Exception: ", ex);
			throw new SpringBootException("Error While Adding/Updating Articles. Please try again!!!");
		}
		return "article";
	}
}
