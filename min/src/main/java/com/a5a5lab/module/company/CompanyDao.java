package com.a5a5lab.module.company;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao {
	public List<CompanyDto> selectList(CompanyVo vo);
	public List<CompanyDto> codeList(CompanyDto companyDto);
	public int selectOneCount(CompanyVo vo);
	public CompanyDto selectOne(CompanyVo vo);
	public int update(CompanyDto companyDto);
	public int insert(CompanyDto companyDto);

}
