package com.tracker.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.tracker.model.AssociateSkills;

@Entity
@Table(name="associate_skills")
@IdClass(AssociateSkills.class)
public class AssociateSkillsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="associate_id")
	private int associateId;
	
	@Id
	@Column(name="skill_id")
	private int skillId;
	
	@Column(name="skill_rating")
	private int skillRating;
	
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

	public int getSkillRating() {
		return skillRating;
	}

	public void setSkillRating(int skillRating) {
		this.skillRating = skillRating;
	}

	@Override
	public String toString() {
		return "AssociateSkillsEntity [associateId=" + associateId + ", skillId=" + skillId + ", skillRating="
				+ skillRating + "]";
	}
	
	
}
