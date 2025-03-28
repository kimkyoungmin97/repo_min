package com.a5a5lab.module.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	
	@Autowired
	CompanyDao companyDao;
	public List<CompanyDto> selectList(CompanyVo vo){
		return companyDao.selectList(vo);
	}
	public int selectOneCount(CompanyVo vo) {
		return companyDao.selectOneCount(vo);
	}

}
