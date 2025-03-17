package com.a5a5lab.module.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
	
	public List<CodeDto> selectList(CodeVo vo){
		return codeDao.selectList(vo);
	}
	public List<CodeDto> codeList(CodeDto codeDto) {
		return codeDao.codeList(codeDto);
	}
	public int selectOneCount(CodeVo vo) {
		return codeDao.selectOneCount(vo);
	}
	public int insert(CodeDto codeDto) {
		return codeDao.insert(codeDto);
	}

}
