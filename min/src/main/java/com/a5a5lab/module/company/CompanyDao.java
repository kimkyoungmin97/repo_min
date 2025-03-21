package com.a5a5lab.module.company;

import java.util.List;

public interface CompanyDao {
	public List<CompanyDto> selectList(CompanyDto companyDto);

}
