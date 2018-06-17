package com.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class SkillsEntity.
 */
@Entity
@Table(name="skills")
public class SkillsEntity {
	
	/** The skill id. */
	@Id
	@Column(name="skill_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int skillId;
	
	/** The skill name. */
	@Column(name="skill_name")
	private String skillName;
	

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
		return "SkillsEntity [skillId=" + skillId + ", skillName=" + skillName + "]";
	}

	/**
	 * Instantiates a new skills entity.
	 *
	 * @param skillName the skill name
	 */
	public SkillsEntity(String skillName) {
		super();
		this.skillName = skillName;
	}
	
	/**
	 * Instantiates a new skills entity.
	 */
	public SkillsEntity() {
		
	}
	
	

}
