package com.a5a5lab.module.user;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	
	public List<UserDto> selectList(UserVo vo);
	public int selectOneCount(UserVo vo);

}
