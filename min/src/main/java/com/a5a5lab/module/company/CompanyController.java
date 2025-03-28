package com.a5a5lab.module.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value="/companyXdmList")
	public String companyxdmlist( Model model,@ModelAttribute("vo") CompanyVo vo) {
		vo.setParamsPaging(companyService.selectOneCount(vo));
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", companyService.selectList(vo));
			
		}
		
		return "xdm/company/CompanyXdmList";
	}
	@RequestMapping(value="/companyXdmForm")
	public String companyXdmForm() {
		
		return "xdm/company/CompanyXdmForm";
	}
	
	
	

}
