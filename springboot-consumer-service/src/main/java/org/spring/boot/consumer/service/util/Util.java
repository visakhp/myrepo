package org.spring.boot.consumer.service.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author visakh
 *
 */
public class Util {

	private Util() {
	}

	public static final List<String> getArticleType() {
		List<String> articleType = new ArrayList<String>();
		articleType.add("News");
		articleType.add("New Product");
		articleType.add("Design Guide");
		articleType.add("Sourcing");
		articleType.add("Other");

		return articleType;
	}

	public static final List<String> getArticleStatus() {
		List<String> articleStatus = new ArrayList<String>();
		articleStatus.add("Edited");
		articleStatus.add("Published");
		articleStatus.add("QA");

		return articleStatus;
	}

}
