package com.a5a5lab.module.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.module.util.UtilDateTime;

@Controller
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping(value="/companyXdmList")
	public String companyxdmlist( Model model,@ModelAttribute("vo") CompanyVo vo, CompanyDto companyDto) {
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
		vo.setParamsPaging(companyService.selectOneCount(vo));
		if (vo.getTotalRows() > 0) {
//			model.addAttribute("item", companyService.codeList(companyDto));
			model.addAttribute("list", companyService.selectList(vo));
			
			
		}
		
		return "xdm/company/CompanyXdmList";
	}
	@RequestMapping(value="/companyXdmForm")
	public String companyXdmForm(Model model, @ModelAttribute("vo") CompanyVo vo, CompanyDto companyDto) {
		if (vo.getMcSeq().equals("0") || vo.getMcSeq().equals("")) {
//			insert mode
			
		} else {
//			update mode
			model.addAttribute("list", companyService.codeList(companyDto));
			model.addAttribute("item", companyService.selectOne(vo));
//			model.addAttribute("list", codeService.selectList(cvo));
			
		}
		
		return "xdm/company/CompanyXdmForm";
	}
	@RequestMapping(value="/companyXdmUpdt")
	public String companyXdmUpdt(CompanyDto companyDto) {
		companyService.update(companyDto);
		return "redirect:/companyXdmList";
	}
	@RequestMapping(value="/companyXdmInst")
	public String companyXdmInst(CompanyDto companyDto) {
		companyService.insert(companyDto);
		return "redirect:/companyXdmList";
	}
	
	
	
	

}
