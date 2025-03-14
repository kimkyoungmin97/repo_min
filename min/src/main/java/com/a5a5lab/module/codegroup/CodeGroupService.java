package com.a5a5lab.module.codegroup;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {
	
	@Autowired
	CodeGroupDao codeGroupDao;
	public List<CodeGroupDto> selectList(CodeGroupVo vo){
		return codeGroupDao.selectList(vo);
	}
	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);
	}
	public int selectOneCount(CodeGroupVo vo) {
		return codeGroupDao.selectOneCount(vo);
	}
	
	


}
