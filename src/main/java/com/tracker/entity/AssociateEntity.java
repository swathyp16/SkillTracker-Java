package com.tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private int mobile;
	
	@Column(name="pic")
	private byte[] pic;
	
	@Column(name="remark")
	private String remark;
	
	@Column(name="strength")
	private String strength;
	
	@Column(name="weakness")
	private String weakness;

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

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
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
	
	
}
