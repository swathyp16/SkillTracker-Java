package com.tracker.model;

// TODO: Auto-generated Javadoc
/**
 * The Class SkillsModel.
 */
public class SkillsModel {
	
	
	/** The skill id. */
	private int skillId;
	
	/** The skill name. */
	private String skillName;
	
	/** The skill rating. */
	private Integer skillRating;
	

	/**
	 * Gets the skill rating.
	 *
	 * @return the skill rating
	 */
	public Integer getSkillRating() {
		return skillRating;
	}

	/**
	 * Sets the skill rating.
	 *
	 * @param skillRating the new skill rating
	 */
	public void setSkillRating(Integer skillRating) {
		this.skillRating = skillRating;
	}

	/**
	 * Gets the skill id.
	 *
	 * @return the skill id
	 */
	public int getSkillId() {
		return skillId;
	}

	/**
	 * Sets the skill id.
	 *
	 * @param skillId the new skill id
	 */
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	/**
	 * Gets the skill name.
	 *
	 * @return the skill name
	 */
	public String getSkillName() {
		return skillName;
	}

	/**
	 * Sets the skill name.
	 *
	 * @param skillName the new skill name
	 */
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SkillsModel [skillId=" + skillId + ", skillName=" + skillName + ", skillRating=" + skillRating + "]";
	}

	
	
	

}
