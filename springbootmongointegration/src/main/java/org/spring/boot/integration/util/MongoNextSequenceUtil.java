package org.spring.boot.integration.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spring.boot.integration.exception.SpringBootException;
import org.spring.boot.integration.model.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * 
 * @author PadmakVis
 *
 */
@Component
public class MongoNextSequenceUtil {

	private static final Logger LOGGER = LogManager.getLogger(MongoNextSequenceUtil.class);

	@Autowired
	private MongoOperations mongoOperation;

	public int getNextSequence(String key) throws SpringBootException {

		// get sequence id
		Query query = new Query(Criteria.where("_id").is(key));

		// increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);

		// return new increased id
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		// this is the magic happened.
		Sequence seqId = mongoOperation.findAndModify(query, update, options, Sequence.class);

		// if no id, throws SequenceException
		// optional, just a way to tell user when the sequence id is failed to
		// generate.
		if (seqId == null) {
			throw new SpringBootException("Unable to get sequence id for key : " + key);
		}

		LOGGER.info("Sequence key generated, Next Seq ID: {}", seqId.getSeq());

		return seqId.getSeq();
	}

}
