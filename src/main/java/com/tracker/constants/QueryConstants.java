package com.tracker.constants;

public class QueryConstants {

	
	public static final String FETCH_PIC_BY_ASSOCIATE_ID = "select A.pic from AssociateEntity A where A.associateId = ?1";
	
	public static final String FETCH_SKILL_NAME_BY_ID = "select A from SkillsEntity A where A.skillId = ?1";
	
}
