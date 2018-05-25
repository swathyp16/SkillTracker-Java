package com.tracker.model;

public class SkillsModel {
	
	
	private int skillId;
	
	private String skillName;

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
		return "SkillsModel [skillId=" + skillId + ", skillName=" + skillName + "]";
	}

	
	
	

}
