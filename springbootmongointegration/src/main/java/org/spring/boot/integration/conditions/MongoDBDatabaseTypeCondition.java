package org.spring.boot.integration.conditions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

@Component
public class MongoDBDatabaseTypeCondition implements Condition {

	private static final Logger LOGGER = LogManager.getLogger(MongoDBDatabaseTypeCondition.class);

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		String dbType = System.getProperty("dbType");

		LOGGER.info("MongoDB Bean intialized....");

		return (dbType != null && dbType.equalsIgnoreCase("Mongo"));
	}

}
