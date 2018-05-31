package com.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="associate_skills")
public class AssociateSkillsEntity {

	@Id
	@Column(name="associate_id")
	private int associateId;
	
	@Column(name="skill_id")
	private int skillId;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="associate_id",insertable=false,updatable=false)
	private AssociateEntity associateEntity;
	
	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}	

	public AssociateEntity getAssociateEntity() {
		return associateEntity;
	}

	public void setAssociateEntity(AssociateEntity associateEntity) {
		this.associateEntity = associateEntity;
	}

	@Override
	public String toString() {
		return "AssociateSkillsEntity [associateId=" + associateId + ", skillId=" + skillId + "]";
	}
	
	
	
	
}
