package com.tracker.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
//	
//	@JsonDeserialize(as = MultipartFile.class)
//	private MultipartFile picture;

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
				+ otherSkill + ", strength=" + strength + ", weakness=" + weakness + "]";
	}

//	public MultipartFile getPicture() {
//		return picture;
//	}
//
//	public void setPicture(MultipartFile picture) {
//		this.picture = picture;
//	}

	
	
	
	

}
