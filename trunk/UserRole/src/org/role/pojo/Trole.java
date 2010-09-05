package org.role.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Trole implements java.io.Serializable {
		
	private static final long serialVersionUID = -1260915131321552274L;
	private Integer trId;
	private Integer parentTrId;
	private String trName;
	private Date createTime;
	private String description;
	private Set Tauths = new HashSet(0);
	private Set Tgroups = new HashSet(0);
	private Set Tusers = new HashSet(0);

	public Trole() {
	}

	public Integer getTrId() {
		return this.trId;
	}

	public void setTrId(Integer trId) {
		this.trId = trId;
	}

	public Integer getParentTrId() {
		return this.parentTrId;
	}

	public void setParentTrId(Integer parentTrId) {
		this.parentTrId = parentTrId;
	}

	public String getTrName() {
		return this.trName;
	}

	public void setTrName(String trName) {
		this.trName = trName;
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

	public Set getTgroups() {
		return Tgroups;
	}

	public void setTgroups(Set tgroups) {
		Tgroups = tgroups;
	}

	public Set getTusers() {
		return Tusers;
	}

	public void setTusers(Set tusers) {
		Tusers = tusers;
	}
}