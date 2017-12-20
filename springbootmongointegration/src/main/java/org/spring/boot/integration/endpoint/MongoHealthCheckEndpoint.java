package org.spring.boot.integration.endpoint;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.actuate.health.MongoHealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @author PadmakVis
 *
 */
@ConfigurationProperties(prefix = "endpoints.mongo")
@Component
public class MongoHealthCheckEndpoint implements Endpoint<Map<String, String>>
{

	private static final Logger LOGGER = LogManager.getLogger(MongoHealthCheckEndpoint.class);

	private static final String MONGO_ENDPOINT_ID = "mongo";

	private static final Map<String, String> UP = new HashMap<String, String>()
	{
		{
			put("mongo.status", "UP");
		}
	};

	private static final Map<String, String> DOWN = new HashMap<String, String>()
	{
		{
			put("mongo.status", "DOWN");
		}
	};

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String getId()
	{
		return MONGO_ENDPOINT_ID;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

	@Override
	public boolean isSensitive()
	{
		return false;
	}

	@Override
	public Map<String, String> invoke()
	{
		try
		{
			return (new MongoHealthIndicator(mongoTemplate).health().getStatus().equals(Status.UP)) ? UP : DOWN;
		} catch (Exception e)
		{
			LOGGER.error("mongo database is down: ", e);
			return DOWN;
		}
	}

}
