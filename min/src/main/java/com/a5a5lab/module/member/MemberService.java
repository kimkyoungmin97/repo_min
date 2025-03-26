package com.a5a5lab.module.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public List<MemberDto> selectList(MemberVo vo){
		return memberDao.selectList(vo);
	}
	public int selectOneCount(MemberVo vo){
		return memberDao.selectOneCount(vo);
	}
	public MemberDto selectOne(MemberDto memberDto){
		return memberDao.selectOne(memberDto);
	}
	public MemberDto login(MemberVo vo) {
		return memberDao.login(vo);
	}

}
