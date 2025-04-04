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
	public List<MemberDto> codeList(MemberDto memberDto){
		return memberDao.codeList(memberDto);
	}
	public int selectOneCount(MemberVo vo){
		return memberDao.selectOneCount(vo);
	}
	public MemberDto selectOne(MemberDto memberDto){
		return memberDao.selectOne(memberDto);
	}
	public int insert(MemberDto memberDto) {
		return memberDao.insert(memberDto);
	}

}
