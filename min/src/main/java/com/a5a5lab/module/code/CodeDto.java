package com.a5a5lab.module.code;

import java.util.ArrayList;
import java.util.List;

public class CodeDto {
	
	private String ifcdSeq;
	private String ifcdName;
	private Integer ifcdUseNy;

	private Integer ifcdDelNy;
	private Integer codeGroup_ifcgSeq;
	
//	codegroup
	private String ifcgSeq;
	private String ifcgName;
//	------
	public Integer getIfcdUseNy() {
		return ifcdUseNy;
	}
	public void setIfcdUseNy(Integer ifcdUseNy) {
		this.ifcdUseNy = ifcdUseNy;
	}
	public String getIfcdSeq() {
		return ifcdSeq;
	}
	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}
	public String getIfcdName() {
		return ifcdName;
	}
	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}
	public Integer getIfcdDelNy() {
		return ifcdDelNy;
	}
	public void setIfcdDelNy(Integer ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
	}
	public Integer getCodeGroup_ifcgSeq() {
		return codeGroup_ifcgSeq;
	}
	public void setCodeGroup_ifcgSeq(Integer codeGroup_ifcgSeq) {
		this.codeGroup_ifcgSeq = codeGroup_ifcgSeq;
	}
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	
//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}
	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}
	
	
	

}
