package com.a5a5lab.module.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao MemberDao;
	
	public List<MemberDto> selectList(MemberVo vo){
		return MemberDao.selectList(vo);
	}
	public int selectOneCount(MemberVo vo){
		return MemberDao.selectOneCount(vo);
	}
	public MemberDto selectOne(MemberDto memberDto){
		return MemberDao.selectOne(memberDto);
	}

}
