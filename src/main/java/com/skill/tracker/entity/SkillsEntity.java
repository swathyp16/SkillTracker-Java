package com.skill.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skills")
public class SkillsEntity {
	
	@Id
	@Column(name="skill_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int skillId;
	
	@Column(name="skill_name")
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
		return "SkillsEntity [skillId=" + skillId + ", skillName=" + skillName + "]";
	}
	
	

}
