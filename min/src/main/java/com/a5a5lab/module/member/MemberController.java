package com.a5a5lab.module.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

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
	@ResponseBody
	@RequestMapping(value = "/signinXdmProc")
	public Map<String, Object> signinXdmProc(MemberDto dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		MemberDto rtMember = memberService.selectOne(dto);
		if(rtMember != null) {
			returnMap.put("rt","success");
			httpSession.setAttribute("sessSeqXdm", rtMember.getUserSeq());
			httpSession.setAttribute("sessIdXdm", rtMember.getUserId());
			httpSession.setAttribute("sessNameXdm", rtMember.getUserName());
			
		} else {
		
		}
//		System.out.println("dto.seq"+ dto.getUserSeq());
//		System.out.println("dto.id"+ dto.getUserId());
//		System.out.println("dto.name"+ dto.getUserName());
		
	
		
		return returnMap;
	}
	@ResponseBody
	@RequestMapping(value = "/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(MemberDto dto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("rt", "success");
		return returnMap;
	}
	
	

}
