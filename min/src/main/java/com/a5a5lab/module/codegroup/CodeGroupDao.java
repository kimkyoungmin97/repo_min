package com.a5a5lab.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	
	
	public List<CodeGroupDto> selectList();
	

}
