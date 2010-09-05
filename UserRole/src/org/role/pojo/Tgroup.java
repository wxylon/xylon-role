package org.role.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Tgroup implements java.io.Serializable {

	private static final long serialVersionUID = 3495422030501687299L;
	private Integer tgId;
	private Integer tgParentId;
	private String tgName;
	private Date createTime;
	private String description;
	private Set Tauths = new HashSet(0);
	private Set Tusers = new HashSet(0);
	private Set Troles = new HashSet(0);
	
	public Tgroup() {
	}

	public Integer getTgId() {
		return this.tgId;
	}

	public void setTgId(Integer tgId) {
		this.tgId = tgId;
	}

	public Integer getTgParentId() {
		return this.tgParentId;
	}

	public void setTgParentId(Integer tgParentId) {
		this.tgParentId = tgParentId;
	}

	public String getTgName() {
		return this.tgName;
	}

	public void setTgName(String tgName) {
		this.tgName = tgName;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getTauths() {
		return Tauths;
	}

	public void setTauths(Set tauths) {
		Tauths = tauths;
	}

	public Set getTusers() {
		return Tusers;
	}

	public void setTusers(Set tusers) {
		Tusers = tusers;
	}

	public Set getTroles() {
		return Troles;
	}

	public void setTroles(Set troles) {
		Troles = troles;
	}
}