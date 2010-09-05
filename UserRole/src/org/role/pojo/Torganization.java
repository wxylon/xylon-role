package org.role.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Torganization implements java.io.Serializable {
		
	private static final long serialVersionUID = -4242848584269792198L;
	private Integer toId;
	private Integer toParentId;
	private String toName;
	private Date createTime;
	private String description;
	private Set Tusers = new HashSet(0);

	public Torganization() {
	}


	public Integer getToId() {
		return this.toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public Integer getToParentId() {
		return this.toParentId;
	}

	public void setToParentId(Integer toParentId) {
		this.toParentId = toParentId;
	}

	public String getToName() {
		return this.toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
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

	public Set getTusers() {
		return Tusers;
	}

	public void setTusers(Set tusers) {
		Tusers = tusers;
	}
}