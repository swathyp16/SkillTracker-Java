package com.tracker.model;

import java.util.List;

public class AssociateModel {
	
	private int associateId;
	
	private String name;
	
	private String email;
	
	private int mobileNum;
	
	private String remark;
	
	private List<SkillsModel> associateSkills;
	
	private String otherSkill;
	
	private String strength;
	
	private String weakness;

	private boolean statusGreen;
	
	private boolean statusBlue;
	
	private boolean statusRed;
	
	private boolean level1;
	
	private boolean level2;
	
	private boolean level3;	
	

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

	public int getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(int mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<SkillsModel> getAssociateSkills() {
		return associateSkills;
	}

	public void setAssociateSkills(List<SkillsModel> associateSkills) {
		this.associateSkills = associateSkills;
	}

	public String getOtherSkill() {
		return otherSkill;
	}

	public void setOtherSkill(String otherSkill) {
		this.otherSkill = otherSkill;
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

	@Override
	public String toString() {
		return "AssociateModel [associateId=" + associateId + ", name=" + name + ", email=" + email + ", mobileNum="
				+ mobileNum + ", remark=" + remark + ", associateSkills=" + associateSkills + ", otherSkill="
				+ otherSkill + ", strength=" + strength + ", weakness=" + weakness + ", statusGreen=" + statusGreen
				+ ", statusBlue=" + statusBlue + ", statusRed=" + statusRed + ", level1=" + level1 + ", level2="
				+ level2 + ", level3=" + level3 + "]";
	}	
	
	

}
