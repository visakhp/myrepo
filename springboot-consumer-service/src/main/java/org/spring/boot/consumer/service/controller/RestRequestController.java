package org.spring.boot.consumer.service.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spring.boot.consumer.service.exception.SpringBootException;
import org.spring.boot.consumer.service.model.Article;
import org.spring.boot.consumer.service.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestRequestController
{

	private static final Logger LOGGER = LogManager.getLogger(RestRequestController.class);

	@Autowired
	protected RestTemplate restTemplate;

	@Value("${remote.service.url}")
	private String remoteServiceURL;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome(Model model) throws SpringBootException
	{
		LOGGER.info("Redirecting to Article Page.....");
		return "redirect:/listArticles";
	}

	@RequestMapping(value = "/listArticles", method = RequestMethod.GET)
	public String listArticles(Model model) throws SpringBootException
	{
		try
		{
			LOGGER.info("Sending request to remote Service: {} ", remoteServiceURL + "/listArticles");

			URI requestUrl = new URI(remoteServiceURL + "/listArticles");

			Object response = restTemplate.getForObject(requestUrl, Object.class);

			if (response instanceof ResponseEntity<?>)
			{
				LOGGER.error("Error while retrieving articles from database.");

				model.addAttribute("error", ((ResponseEntity<?>) response).getBody().toString());
				return "error";
			}

			model.addAttribute("article", new Article());
			model.addAttribute("listArticles", response);
			model.addAttribute("news", Util.getArticleType());

			LOGGER.info("Article(s) Listed Successfully from remote service..");

			return "article";

		} catch (RestClientException e) {

			LOGGER.error(e);
			throw new SpringBootException("Error While fetching the data from remote service. Please try again!!!");

		} catch (URISyntaxException e)
		{
			LOGGER.error(e);
			throw new SpringBootException("cannot parse given URI. Please use valid URI.");
		}

	}

	@RequestMapping(value = "/article/add", method = RequestMethod.POST)
	public Object addORSaveArticle(@RequestParam(required = false, value = "save") String saveFlag,
			@ModelAttribute("article") Article article, Model model, BindingResult result)
			throws SpringBootException
	{
		try
		{
			URI requestUrl = new URI(remoteServiceURL + "/article/save");

			LOGGER.info("Sending request to remote Service: {} ", remoteServiceURL + "/article/save");

			Object response = restTemplate.postForObject(requestUrl, article, Object.class);

			if (response instanceof ResponseEntity<?>)
			{
				LOGGER.error("Error while adding article to database.");

				model.addAttribute("error", ((ResponseEntity<?>) response).getBody().toString());
				return "error";
			}
			
			if (response instanceof List<?> && !((List<?>) response).isEmpty())
			{
				LOGGER.error("Validation failed for Article Object");

				requestUrl = new URI(remoteServiceURL + "/listArticles");

				LOGGER.info("Sending request to remote Service: {} ", remoteServiceURL + "/listArticles");

				Object listArticles = restTemplate.getForObject(requestUrl, Object.class);

				if (listArticles instanceof ResponseEntity<?>)
				{
					LOGGER.error("Error while retrieving articles from database.");

					model.addAttribute("error", ((ResponseEntity<?>) listArticles).getBody().toString());
					return "error";
				}

				LOGGER.info("Article(s) Listed Successfully from remote service..");

				List<String> tempArticleType = Util.getArticleType();

				if (article.getNews() != null && !article.getNews().equals(StringUtils.EMPTY))
					tempArticleType.remove(article.getNews());

				model.addAttribute("listArticles", listArticles);
				model.addAttribute("news", tempArticleType);
				model.addAttribute("articleStatus", Util.getArticleStatus());
				model.addAttribute("article", article);

				List<?> errors = (List<?>) response;

				for (Object obj : errors)
				{
					Map fieldError = (Map) obj;
					FieldError error = new FieldError((String) fieldError.get("objectName"),
							(String) fieldError.get("field"), (String) fieldError.get("defaultMessage"));

					result.addError(error);
				}

				return "article";
			}

			LOGGER.info("Article updated Successfully");

			return "redirect:/listArticles";

		} catch (URISyntaxException e)
		{
			LOGGER.error(e);
			throw new SpringBootException(
					"cannot parse given URI. Please use valid URI.");
		} catch (RestClientException e)
		{
			LOGGER.error(e);
			throw new SpringBootException("Error While fetching the data from remote service. Please try again!!!");
		}

	}

	@RequestMapping(value = "/edit/{articleId}", method = RequestMethod.GET)
	public String editArticle(@PathVariable("articleId") int articleId, Model model) throws SpringBootException
	{
		try
		{
			String requestUrl = remoteServiceURL + "/editArticle/{articleId}";

			LOGGER.info("Sending request to remote Service: {} ", remoteServiceURL + "/edit/" + articleId);

			Object response = restTemplate.getForObject(requestUrl.toString(), Article.class, articleId);

			LOGGER.info("Article listed successfully for Id: {} ", articleId);

			URI requestUri = new URI(remoteServiceURL + "/listArticles");

			LOGGER.info("Sending request to remote Service: {} ", remoteServiceURL + "/listArticles");

			Object listArticles = restTemplate.getForObject(requestUri, Object.class);

			if (listArticles instanceof ResponseEntity<?>)
			{
				LOGGER.error("Error while retrieving articles from database.");

				model.addAttribute("error", ((ResponseEntity<?>) listArticles).getBody().toString());
				return "error";
			}

			LOGGER.info("Article(s) Listed Successfully from remote service..");

			model.addAttribute("article", response);
			model.addAttribute("listArticles", listArticles);

			List<String> tempArticleType = Util.getArticleType();
			tempArticleType.remove(((Article) response).getNews());

			model.addAttribute("news", tempArticleType);
			model.addAttribute("articleStatus", Util.getArticleStatus());

			return "article";

		} catch (RestClientException e)
		{
			LOGGER.error(e);
			throw new SpringBootException("Error While fetching the data from remote service. Please try again!!!");

		} catch (URISyntaxException e)
		{
			LOGGER.error(e);
			throw new SpringBootException("cannot parse given URI. Please use valid URI.");
		}
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
