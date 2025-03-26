package com.a5a5lab.module.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeDao {
	
	public List<CodeDto> selectList(CodeVo vo);
	public List<CodeDto> codeList(CodeDto codeDto);
	public CodeDto selectOne(CodeDto codeDto);
	public int selectOneCount(CodeVo vo);
	public int insert(CodeDto codeDto);
	public int update(CodeDto codeDto);
	public List<CodeDto> selectListCachedCodeArrayList();
	

}
