package com.a5a5lab.module.member;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.a5a5lab.module.company.CompanyDto;

@Repository
public interface MemberDao {
	
	public List<MemberDto> selectList(MemberVo vo);
	public List<MemberDto> codeList(MemberDto memberDto);
	public int selectOneCount(MemberVo vo);
	public MemberDto selectOne(MemberDto memberDto);
	public int insert(MemberDto memberDto);
	

}
