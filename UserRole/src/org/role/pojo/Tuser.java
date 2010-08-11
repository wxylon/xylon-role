package org.role.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Tuser implements java.io.Serializable {

	private Integer tuId;
	private Torganization torganization;
	private String userName;
	private String passWord;
	private String vserName;
	private String mobile;
	private String email;
	private Date createTime;
	private Date loginTime;
	private Date lastLoginTime;
	private Integer loginCount;
	private Set Tauths = new HashSet(0);
	private Set Troles = new HashSet(0);
	private Set Tgroups = new HashSet(0);
	private Set Tlogs = new HashSet(0);

	public Tuser() {
	}

	public Integer getTuId() {
		return this.tuId;
	}

	public void setTuId(Integer tuId) {
		this.tuId = tuId;
	}

	public Torganization getTorganization() {
		return this.torganization;
	}

	public void setTorganization(Torganization torganization) {
		this.torganization = torganization;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getVserName() {
		return this.vserName;
	}

	public void setVserName(String vserName) {
		this.vserName = vserName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Set getTauths() {
		return Tauths;
	}

	public void setTauths(Set tauths) {
		Tauths = tauths;
	}

	public Set getTroles() {
		return Troles;
	}

	public void setTroles(Set troles) {
		Troles = troles;
	}

	public Set getTgroups() {
		return Tgroups;
	}

	public void setTgroups(Set tgroups) {
		Tgroups = tgroups;
	}

	public Set getTlogs() {
		return Tlogs;
	}

	public void setTlogs(Set tlogs) {
		Tlogs = tlogs;
	}
}