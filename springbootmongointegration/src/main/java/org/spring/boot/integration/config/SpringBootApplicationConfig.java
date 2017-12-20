package org.spring.boot.integration.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spring.boot.integration.conditions.MYSQLDBDatabaseTypeCondition;
import org.spring.boot.integration.conditions.MongoDBDatabaseTypeCondition;
import org.spring.boot.integration.dao.ArticleDAO;
import org.spring.boot.integration.dao.MongoArticleDAOImpl;
import org.spring.boot.integration.dao.MySQLArticleDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootApplicationConfig
{

	private static final Logger LOGGER = LogManager.getLogger(SpringBootApplicationConfig.class);

	@Bean
	@Conditional(MYSQLDBDatabaseTypeCondition.class)
	public ArticleDAO jdbcUserDAO()
	{
		LOGGER.info("Condition MYSQL satisfied, creating DAO bean for MYSQL...");
		return new MySQLArticleDAOImpl();
	}

	@Bean
	@Conditional(MongoDBDatabaseTypeCondition.class)
	public ArticleDAO mongoUserDAO()
	{
		LOGGER.info("Condition MONGO satisfied, creating DAO bean for Mongo...");
		return new MongoArticleDAOImpl();
	}

}
