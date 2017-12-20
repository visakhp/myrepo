package org.spring.boot.integration.conditions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

@Component
public class MYSQLDBDatabaseTypeCondition implements Condition {

	private static final Logger LOGGER = LogManager.getLogger(MYSQLDBDatabaseTypeCondition.class);

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		String dbType = System.getProperty("dbType");

		LOGGER.info("MYSQL Bean intialized....", dbType);

		return (dbType != null && dbType.equalsIgnoreCase("MYSQL"));
	}

}
