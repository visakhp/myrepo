package org.spring.boot.integration.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author visakh
 *
 */
public class Util {

	public static final String SEQUENCE_KEY = "sequence";

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
