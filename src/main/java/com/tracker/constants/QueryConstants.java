package com.tracker.constants;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryConstants.
 */
public class QueryConstants {

	
	/** The Constant FETCH_PIC_BY_ASSOCIATE_ID. */
	public static final String FETCH_PIC_BY_ASSOCIATE_ID = "select A.pic from AssociateEntity A where A.associateId = ?1";
	
	/** The Constant FETCH_SKILL_NAME_BY_ID. */
	public static final String FETCH_SKILL_NAME_BY_ID = "select A from SkillsEntity A where A.skillId in (?1)";
	
	/** The Constant FETCH_DISTINCT_ASSOCIATE_ID. */
	public static final String FETCH_DISTINCT_ASSOCIATE_ID = "select distinct A.associateId from AssociateEntity A";

	/** The Constant FETCH_ASSOCIATE_SKILL_BY_ID. */
	public static final String FETCH_ASSOCIATE_SKILL_BY_ID = "select  A from AssociateSkillsEntity A where A.associateId in (?1)";

	/** The Constant SAVE_SKILL_RATING. */
	public static final String SAVE_SKILL_RATING = "update AssociateSkillsEntity A set A.skillRating = ?3 where A.associateId = ?1 and A.skillId = ?2";
	

}
