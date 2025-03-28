package com.a5a5lab.module.company;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao {
	public List<CompanyDto> selectList(CompanyVo vo);
	public int selectOneCount(CompanyVo vo);

}
