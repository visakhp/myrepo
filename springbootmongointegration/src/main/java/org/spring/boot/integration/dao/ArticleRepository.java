package org.spring.boot.integration.dao;

import org.spring.boot.integration.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ArticleRepository extends MongoRepository<Article, String> {

	@Query("{ 'articleID' : ?0 }")
	public Article getArticleByID(int id);

}
