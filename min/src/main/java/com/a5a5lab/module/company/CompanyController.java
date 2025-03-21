package com.a5a5lab.module.company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyController {
	
	@RequestMapping(value="/companyxdmlist")
	public String companyxdmlist() {
		return "/xdm/company/CompanyXdmList";
	}
	
	

}
