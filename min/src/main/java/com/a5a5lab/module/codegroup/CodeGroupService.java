package com.a5a5lab.module.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	public List<CodeGroupDto> selectList(){
		return codeGroupDao.selectList();
	}

}
