package com.tracker.entity;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class AssociateEntity.
 */
@Entity
@Table(name="associate")
public class AssociateEntity {

	/** The associate id. */
	@Id
	@Column(name="associate_id")
	private int associateId;
	
	/** The name. */
	@Column(name="name")
	private String name;
	
	/** The email. */
	@Column(name="email")
	private String email;
	
	/** The mobile. */
	@Column(name="mobile")
	private BigInteger mobile;
	
	/** The pic. */
	@Column(name="pic")
	private byte[] pic;
	
	/** The remark. */
	@Column(name="remark")
	private String remark;
	
	/** The strength. */
	@Column(name="strength")
	private String strength;
	
	/** The weakness. */
	@Column(name="weakness")
	private String weakness;
	
	/** The status green. */
	@Column(name="status_green")
	private boolean statusGreen;
	
	/** The status blue. */
	@Column(name="status_blue")
	private boolean statusBlue;
	
	/** The status red. */
	@Column(name="status_red")
	private boolean statusRed;
	
	/** The level 1. */
	@Column(name="level_1")
	private boolean level1;
	
	/** The level 2. */
	@Column(name="level_2")
	private boolean level2;
	
	/** The level 3. */
	@Column(name="level_3")
	private boolean level3;
	
	/** The gender. */
	@Column(name="gender")
	private String gender;
	
	/** The other skill. */
	@Column(name="other_skill")
	private String otherSkill;
	
	/** The skills. */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "associate_skills", joinColumns = { 
			@JoinColumn(name = "associate_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "skill_id", 
					nullable = false, updatable = false) })
	private List<SkillsEntity> skills;
	 

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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the mobile.
	 *
	 * @return the mobile
	 */
	public BigInteger getMobile() {
		return mobile;
	}

	/**
	 * Sets the mobile.
	 *
	 * @param mobile the new mobile
	 */
	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

	/**
	 * Gets the pic.
	 *
	 * @return the pic
	 */
	public byte[] getPic() {
		return pic;
	}

	/**
	 * Sets the pic.
	 *
	 * @param pic the new pic
	 */
	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * Gets the strength.
	 *
	 * @return the strength
	 */
	public String getStrength() {
		return strength;
	}

	/**
	 * Sets the strength.
	 *
	 * @param strength the new strength
	 */
	public void setStrength(String strength) {
		this.strength = strength;
	}

	/**
	 * Gets the weakness.
	 *
	 * @return the weakness
	 */
	public String getWeakness() {
		return weakness;
	}

	/**
	 * Sets the weakness.
	 *
	 * @param weakness the new weakness
	 */
	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	/**
	 * Checks if is status green.
	 *
	 * @return true, if is status green
	 */
	public boolean isStatusGreen() {
		return statusGreen;
	}

	/**
	 * Sets the status green.
	 *
	 * @param statusGreen the new status green
	 */
	public void setStatusGreen(boolean statusGreen) {
		this.statusGreen = statusGreen;
	}

	/**
	 * Checks if is status blue.
	 *
	 * @return true, if is status blue
	 */
	public boolean isStatusBlue() {
		return statusBlue;
	}

	/**
	 * Sets the status blue.
	 *
	 * @param statusBlue the new status blue
	 */
	public void setStatusBlue(boolean statusBlue) {
		this.statusBlue = statusBlue;
	}

	/**
	 * Checks if is status red.
	 *
	 * @return true, if is status red
	 */
	public boolean isStatusRed() {
		return statusRed;
	}

	/**
	 * Sets the status red.
	 *
	 * @param statusRed the new status red
	 */
	public void setStatusRed(boolean statusRed) {
		this.statusRed = statusRed;
	}

	/**
	 * Checks if is level 1.
	 *
	 * @return true, if is level 1
	 */
	public boolean isLevel1() {
		return level1;
	}

	/**
	 * Sets the level 1.
	 *
	 * @param level1 the new level 1
	 */
	public void setLevel1(boolean level1) {
		this.level1 = level1;
	}

	/**
	 * Checks if is level 2.
	 *
	 * @return true, if is level 2
	 */
	public boolean isLevel2() {
		return level2;
	}

	/**
	 * Sets the level 2.
	 *
	 * @param level2 the new level 2
	 */
	public void setLevel2(boolean level2) {
		this.level2 = level2;
	}

	/**
	 * Checks if is level 3.
	 *
	 * @return true, if is level 3
	 */
	public boolean isLevel3() {
		return level3;
	}

	/**
	 * Sets the level 3.
	 *
	 * @param level3 the new level 3
	 */
	public void setLevel3(boolean level3) {
		this.level3 = level3;
	}	
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the skills.
	 *
	 * @return the skills
	 */
	public List<SkillsEntity> getSkills() {
		return skills;
	}

	/**
	 * Sets the skills.
	 *
	 * @param skills the new skills
	 */
	public void setSkills(List<SkillsEntity> skills) {
		this.skills = skills;
	}
	
	
	/**
	 * Gets the other skill.
	 *
	 * @return the other skill
	 */
	public String getOtherSkill() {
		return otherSkill;
	}

	/**
	 * Sets the other skill.
	 *
	 * @param otherSkill the new other skill
	 */
	public void setOtherSkill(String otherSkill) {
		this.otherSkill = otherSkill;
	}

	/**
	 * Instantiates a new associate entity.
	 */
	public AssociateEntity() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * Instantiates a new associate entity.
	 *
	 * @param name the name
	 * @param email the email
	 * @param mobile the mobile
	 * @param pic the pic
	 * @param remark the remark
	 * @param strength the strength
	 * @param weakness the weakness
	 * @param statusGreen the status green
	 * @param statusBlue the status blue
	 * @param statusRed the status red
	 * @param level1 the level 1
	 * @param level2 the level 2
	 * @param level3 the level 3
	 * @param gender the gender
	 * @param otherSkill the other skill
	 * @param skills the skills
	 */
	public AssociateEntity(String name, String email, BigInteger mobile, byte[] pic, String remark,
			String strength, String weakness, boolean statusGreen, boolean statusBlue, boolean statusRed,
			boolean level1, boolean level2, boolean level3, String gender, String otherSkill, List<SkillsEntity> skills) {
		super();
		//this.associateId = associateId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.pic = pic;
		this.remark = remark;
		this.strength = strength;
		this.weakness = weakness;
		this.statusGreen = statusGreen;
		this.statusBlue = statusBlue;
		this.statusRed = statusRed;
		this.level1 = level1;
		this.level2 = level2;
		this.level3 = level3;
		this.gender = gender;
		this.otherSkill = otherSkill;
		this.skills = skills;
	}

	/**
	 * Instantiates a new associate entity.
	 *
	 * @param name the name
	 * @param skills the skills
	 */
	public AssociateEntity(String name, List<SkillsEntity> skills) {
		//this.associateId = associateId;
		this.name = name;
		this.skills = skills;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssociateEntity [associateId=" + associateId + ", name=" + name + ", email=" + email + ", mobile="
				+ mobile + ", pic=" + Arrays.toString(pic) + ", remark=" + remark + ", strength=" + strength
				+ ", weakness=" + weakness + ", statusGreen=" + statusGreen + ", statusBlue=" + statusBlue
				+ ", statusRed=" + statusRed + ", level1=" + level1 + ", level2=" + level2 + ", level3=" + level3
				+ ", gender=" + gender + ", otherSkill=" + otherSkill + ", skills=" + skills + "]";
	}	
	
	
	
}
