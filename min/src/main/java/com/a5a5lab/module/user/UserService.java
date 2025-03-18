package com.a5a5lab.module.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public List<UserDto> selectList(UserVo vo){
		return userDao.selectList(vo);
	}
	public int selectOneCount(UserVo vo){
		return userDao.selectOneCount(vo);
	}

}
