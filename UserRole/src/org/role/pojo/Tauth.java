package org.role.pojo;

import java.util.HashSet;
import java.util.Set;

public class Tauth implements java.io.Serializable {

	private Integer taId;
	private Integer taParentId;
	private String taName;
	private String description;
	private Set Troles = new HashSet(0);
	private Set Tusers = new HashSet(0);
	private Set Tgroups = new HashSet(0);

	public Tauth() {
	}

	public Integer getTaId() {
		return this.taId;
	}

	public void setTaId(Integer taId) {
		this.taId = taId;
	}

	public Integer getTaParentId() {
		return this.taParentId;
	}

	public void setTaParentId(Integer taParentId) {
		this.taParentId = taParentId;
	}

	public String getTaName() {
		return this.taName;
	}

	public void setTaName(String taName) {
		this.taName = taName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getTroles() {
		return Troles;
	}

	public void setTroles(Set troles) {
		Troles = troles;
	}

	public Set getTusers() {
		return Tusers;
	}

	public void setTusers(Set tusers) {
		Tusers = tusers;
	}

	public Set getTgroups() {
		return Tgroups;
	}

	public void setTgroups(Set tgroups) {
		Tgroups = tgroups;
	}
}