package com.a5a5lab.module.codegroup;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface CodeGroupDao {
	
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo);
	public int selectOneCount(CodeGroupVo vo);
	public CodeGroupDto selectOne(CodeGroupVo vo);
	public int insert(CodeGroupDto codeGroupDto);
	public int update(CodeGroupDto codeGroupDto);
	public int ulete(CodeGroupDto codeGroupDto);
	
	
	
	

}
