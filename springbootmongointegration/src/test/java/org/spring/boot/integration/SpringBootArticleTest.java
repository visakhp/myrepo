package org.spring.boot.integration;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.boot.integration.exception.SpringBootException;
import org.spring.boot.integration.model.Article;
import org.spring.boot.integration.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author visakh
 *
 */
@RunWith(SpringRunner.class)
@ComponentScan("org.spring.boot.integration")
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestPropertySource(locations = "classpath:/org/spring/boot/integration/springboot_test_application.properties")
public class SpringBootArticleTest
{

	@Autowired
	private ArticleService articleService;

	static
	{
		System.setProperty("dbType", "mysql");
	}

	@Test
	public void addArticlesTest()
	{
		try
		{
			for (int i = 0; i < 5; i++)
			{
				Article article = new Article();
				article.setArticleTitle("Sample Title" + i);
				article.setDescription("Sample Description" + i);
				this.articleService.addArticle(article);
			}
		} catch (SpringBootException e)
		{
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void listArticlesTest()
	{
		try
		{
			this.articleService.listArticles();

		} catch (SpringBootException e)
		{
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}

}
