package com.a5a5lab.module.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@Autowired
	CodeService codeService;
	@RequestMapping(value="/codeXdmList")
	public String codeXdmList(Model model, CodeVo vo) {
		vo.setParamsPaging(codeService.selectOneCount(vo));
		model.addAttribute("vo",vo);
		model.addAttribute("list", codeService.selectList(vo));
		
		return "/xdm/code/CodeXdmList";
	}
	@RequestMapping(value="/codeXdmForm")
	public String codeXdmForm(Model model, CodeDto codeDto) {
		model.addAttribute("list", codeService.codeList(codeDto));
		System.out.println("테스트" + codeDto.getIfcgSeq());
		return "xdm/code/CodeXdmForm";
	}
	@RequestMapping(value="codeXdmInst")
	public String codeXdmInst(CodeDto codeDto) {
		codeService.insert(codeDto);
		return "redirect:/codeXdmList";
	}

}
