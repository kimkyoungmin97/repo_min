package com.a5a5lab.module.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/memberxdmlist")
	public String memberxdmlist(Model model, @ModelAttribute("vo") MemberVo vo) {
		vo.setParamsPaging(memberService.selectOneCount(vo));
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", memberService.selectList(vo));
		}
		return"/xdm/member/MemberXdmList";
	}
	@RequestMapping(value="/memberxdmform")
	public String memberxdmform(Model model, MemberDto memberDto) {
		model.addAttribute("item", memberService.selectOne(memberDto));
		
		
		return "/xdm/member/MemberXdmForm";
	}

}
