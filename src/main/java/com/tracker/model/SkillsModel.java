package com.tracker.model;

public class SkillsModel {
	
	
	private int skillId;
	
	private String skillName;
	
	private Integer skillRating;
	

	public Integer getSkillRating() {
		return skillRating;
	}

	public void setSkillRating(Integer skillRating) {
		this.skillRating = skillRating;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "SkillsModel [skillId=" + skillId + ", skillName=" + skillName + ", skillRating=" + skillRating + "]";
	}

	
	
	

}
