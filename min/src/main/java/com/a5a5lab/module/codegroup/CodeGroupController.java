package com.a5a5lab.module.codegroup;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.a5a5lab.module.code.CodeService;
import com.a5a5lab.module.code.CodeVo;

import jakarta.servlet.http.HttpSession;


@Controller

public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	@Autowired
	CodeService codeService;
	
	
	@RequestMapping(value="/codegroupXdmList")
	public String codegroupxdmlist(Model model, @ModelAttribute("vo") CodeGroupVo vo,HttpSession httpSession) {
		
		
	    vo.setParamsPaging(codeGroupService.selectOneCount(vo));
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", codeGroupService.selectList(vo));
		}
		System.out.println("시퀀스" + httpSession.getAttribute("sessSeqXdm"));
		return "xdm/codegroup/CodeGroupXdmList";
	}

	
	@RequestMapping(value="/codegroupXdmform")
	
	public String codegroupxdmform(Model model, @ModelAttribute("vo") CodeGroupVo vo) throws Exception {
		if (vo.getIfcgSeq().equals("0") || vo.getIfcgSeq().equals("")) {
//			insert mode
			
		} else {
//			update mode
			model.addAttribute("item", codeGroupService.selectOne(vo));
//			model.addAttribute("list", codeService.selectList(cvo));
			
		}
		
		
		return "/xdm/codegroup/CodeGroupXdmForm";
	}
	@RequestMapping(value="/codeGroupXdmInst")
	public String codeGroupXdmInst( CodeGroupDto codeGroupDto) {
		codeGroupService.insert(codeGroupDto);

		return "redirect:/codegroupXdmList";
	}
	@RequestMapping(value="/codeGroupXdmUpdt")
	public String codeGroupXdmUpdt(CodeGroupDto codeGroupDto) {
		codeGroupService.update(codeGroupDto);
		return "redirect:/codegroupXdmList";
	}
	@RequestMapping(value="/codeGroupXdmUlete")
	public String codeGroupXdmUlete(CodeGroupDto codeGroupDto) {
		codeGroupService.ulete(codeGroupDto);
		return "redirect:/codegroupXdmList";
	}
	
	
	
	
}
