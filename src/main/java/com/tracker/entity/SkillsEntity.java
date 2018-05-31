package com.tracker.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	//private List<AssociateEntity> associateEntity;

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
	
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "skillsEntity")
//	public List<AssociateEntity> getAssociateEntity() {
//		return associateEntity;
//	}
//
//	public void setAssociateEntity(List<AssociateEntity> associateEntity) {
//		this.associateEntity = associateEntity;
//	}
	
	

	@Override
	public String toString() {
		return "SkillsEntity [skillId=" + skillId + ", skillName=" + skillName + "]";
	}

	public SkillsEntity(String skillName) {
		super();
		//this.skillId = skillId;
		this.skillName = skillName;
	}
	
	public SkillsEntity() {
		
	}
	
	

}
