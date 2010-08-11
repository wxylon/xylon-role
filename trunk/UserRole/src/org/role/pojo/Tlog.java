package org.role.pojo;

import java.util.Date;

public class Tlog implements java.io.Serializable {

	private Integer tlId;
	private Tuser tuser;
	private Byte toType;
	private String tlContent;
	private Date createTime;

	public Tlog() {
	}

	public Integer getTlId() {
		return this.tlId;
	}

	public void setTlId(Integer tlId) {
		this.tlId = tlId;
	}

	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	public Byte getToType() {
		return this.toType;
	}

	public void setToType(Byte toType) {
		this.toType = toType;
	}

	public String getTlContent() {
		return this.tlContent;
	}

	public void setTlContent(String tlContent) {
		this.tlContent = tlContent;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}