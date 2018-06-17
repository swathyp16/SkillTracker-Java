package com.tracker.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.tracker.model.AssociateSkills;

// TODO: Auto-generated Javadoc
/**
 * The Class AssociateSkillsEntity.
 */
@Entity
@Table(name="associate_skills")
@IdClass(AssociateSkills.class)
public class AssociateSkillsEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The associate id. */
	@Id
	@Column(name="associate_id")
	private int associateId;
	
	/** The skill id. */
	@Id
	@Column(name="skill_id")
	private int skillId;
	
	/** The skill rating. */
	@Column(name="skill_rating")
	private int skillRating;
	
	/**
	 * Gets the associate id.
	 *
	 * @return the associate id
	 */
	public int getAssociateId() {
		return associateId;
	}

	/**
	 * Sets the associate id.
	 *
	 * @param associateId the new associate id
	 */
	public void setAssociateId(int associateId) {
		this.associateId = associateId;
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
	 * Gets the skill rating.
	 *
	 * @return the skill rating
	 */
	public int getSkillRating() {
		return skillRating;
	}

	/**
	 * Sets the skill rating.
	 *
	 * @param skillRating the new skill rating
	 */
	public void setSkillRating(int skillRating) {
		this.skillRating = skillRating;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssociateSkillsEntity [associateId=" + associateId + ", skillId=" + skillId + ", skillRating="
				+ skillRating + "]";
	}
	
	
}
