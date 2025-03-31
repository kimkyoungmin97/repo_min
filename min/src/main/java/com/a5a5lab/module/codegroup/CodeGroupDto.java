package com.a5a5lab.module.codegroup;

import java.sql.Date;

public class CodeGroupDto {
	private String ifcgSeq;
	private int ifcgDelNy;
	private int ifcgUseNy;
	private String ifcgName;
	private Date registrationDate;
	private Date modificationDate;
	private int xifcdSeqCount;
	public int getIfcgUseNy() {
		return ifcgUseNy;
	}
	public void setIfcgUseNy(int ifcgUseNy) {
		this.ifcgUseNy = ifcgUseNy;
	}
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public int getIfcgDelNy() {
		return ifcgDelNy;
	}
	public void setIfcgDelNy(int ifcgDelNy) {
		this.ifcgDelNy = ifcgDelNy;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public Date getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}
	public int getXifcdSeqCount() {
		return xifcdSeqCount;
	}
	public void setXifcdSeqCount(int xifcdSeqCount) {
		this.xifcdSeqCount = xifcdSeqCount;
	}
	
	
	


}
