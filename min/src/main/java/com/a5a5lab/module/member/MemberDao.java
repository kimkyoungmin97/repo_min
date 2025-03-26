package com.a5a5lab.module.member;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	
	public List<MemberDto> selectList(MemberVo vo);
	public int selectOneCount(MemberVo vo);
	public MemberDto selectOne(MemberDto memberDto);
	public MemberDto login(MemberVo vo);

}
