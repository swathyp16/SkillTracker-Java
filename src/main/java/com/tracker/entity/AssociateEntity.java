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

@Entity
@Table(name="associate")
public class AssociateEntity {

	@Id
	@Column(name="associate_id")
	private int associateId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private BigInteger mobile;
	
	@Column(name="pic")
	private byte[] pic;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="strength")
	private String strength;
	
	@Column(name="weakness")
	private String weakness;
	
	@Column(name="status_green")
	private boolean statusGreen;
	
	@Column(name="status_blue")
	private boolean statusBlue;
	
	@Column(name="status_red")
	private boolean statusRed;
	
	@Column(name="level_1")
	private boolean level1;
	
	@Column(name="level_2")
	private boolean level2;
	
	@Column(name="level_3")
	private boolean level3;
	
	@Column(name="gender")
	private String gender;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "associate_skills", joinColumns = { 
			@JoinColumn(name = "associate_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "skill_id", 
					nullable = false, updatable = false) })
	private List<SkillsEntity> skills;
	 

	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigInteger getMobile() {
		return mobile;
	}

	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

	public boolean isStatusGreen() {
		return statusGreen;
	}

	public void setStatusGreen(boolean statusGreen) {
		this.statusGreen = statusGreen;
	}

	public boolean isStatusBlue() {
		return statusBlue;
	}

	public void setStatusBlue(boolean statusBlue) {
		this.statusBlue = statusBlue;
	}

	public boolean isStatusRed() {
		return statusRed;
	}

	public void setStatusRed(boolean statusRed) {
		this.statusRed = statusRed;
	}

	public boolean isLevel1() {
		return level1;
	}

	public void setLevel1(boolean level1) {
		this.level1 = level1;
	}

	public boolean isLevel2() {
		return level2;
	}

	public void setLevel2(boolean level2) {
		this.level2 = level2;
	}

	public boolean isLevel3() {
		return level3;
	}

	public void setLevel3(boolean level3) {
		this.level3 = level3;
	}	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<SkillsEntity> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillsEntity> skills) {
		this.skills = skills;
	}
	
	public AssociateEntity() {
		// TODO Auto-generated constructor stub
	}

	

	public AssociateEntity(String name, String email, BigInteger mobile, byte[] pic, String remark,
			String strength, String weakness, boolean statusGreen, boolean statusBlue, boolean statusRed,
			boolean level1, boolean level2, boolean level3, String gender, List<SkillsEntity> skills) {
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
		this.skills = skills;
	}

	public AssociateEntity(String name, List<SkillsEntity> skills) {
		//this.associateId = associateId;
		this.name = name;
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "AssociateEntity [associateId=" + associateId + ", name=" + name + ", email=" + email + ", mobile="
				+ mobile + ", pic=" + Arrays.toString(pic) + ", remark=" + remark + ", strength=" + strength
				+ ", weakness=" + weakness + ", statusGreen=" + statusGreen + ", statusBlue=" + statusBlue
				+ ", statusRed=" + statusRed + ", level1=" + level1 + ", level2=" + level2 + ", level3=" + level3
				+ ", gender=" + gender + ", skills=" + skills + "]";
	}
	
	
	
}
