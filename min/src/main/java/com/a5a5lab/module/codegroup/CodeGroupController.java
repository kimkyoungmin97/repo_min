package com.a5a5lab.module.codegroup;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@RequestMapping(value="/codegroupxdmlist")
	public String codegroupxdmlist(Model model,  CodeGroupVo vo) {
		
	    vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		model.addAttribute("vo", vo);
		model.addAttribute("list", codeGroupService.selectList(vo));
		
		return "/xdm/codegroup/CodeGroupXdmList";
	}

	
	@RequestMapping(value="/codegroup/codegroupxdmform")
	public String codegroupxdmform() {
		return "/xdm/codegroup/CodeGroupXdmForm";
	}
	@RequestMapping(value="/codegroup/codeGroupXdmInst")
	public String codeGroupXdmInst( CodeGroupDto codeGroupDto) {
		codeGroupService.insert(codeGroupDto);
		return "redirect:/codegroupxdmlist";
	}
	
	
	
}
