package com.a5a5lab.module.codegroup;

import java.sql.Date;

public class CodeGroupDto {
	private String ifcgSeq;
	private int ifcgDelNy;
	private int ifcgUseNy;
	private String ifcgName;
	private String registrationDate;
	private String modificationDate;
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
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getModificationDate() {
		return modificationDate;
	}
	public void setModificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
	}
	public int getXifcdSeqCount() {
		return xifcdSeqCount;
	}
	public void setXifcdSeqCount(int xifcdSeqCount) {
		this.xifcdSeqCount = xifcdSeqCount;
	}
	
	
	


}
