package com.tracker.model;

public class SkillRatingModel {
	
	
	private int skillId;
	
	private int skillRating;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public int getSkillRating() {
		return skillRating;
	}

	public void setSkillRating(int skillRating) {
		this.skillRating = skillRating;
	}

	@Override
	public String toString() {
		return "SkillRatingModel [skillId=" + skillId + ", skillRating=" + skillRating + "]";
	}
	
	

}
