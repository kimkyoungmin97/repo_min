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
	
	@RequestMapping(value="/memberXdmList")
	public String memberxdmlist(Model model, @ModelAttribute("vo") MemberVo vo) {
		vo.setParamsPaging(memberService.selectOneCount(vo));
		if (vo.getTotalRows() > 0) {
			model.addAttribute("list", memberService.selectList(vo));
		}
		return"/xdm/member/MemberXdmList";
	}
	@RequestMapping(value="/memberXdmForm")
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
//		System.out.println(httpSession.getAttribute("sessSeqXdm"));
//		System.out.println(httpSession.getAttribute("sessIdXdm"));
//		System.out.println(httpSession.getAttribute("sessNameXdm"));
		
	
		
		return returnMap;
	}
	@ResponseBody
	@RequestMapping(value = "/signoutXdmProc")
	public Map<String, Object> signoutXdmProc(HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		httpSession.setAttribute("sessSeqXdm", null);
		httpSession.setAttribute("sessIdXdm", null);
		httpSession.setAttribute("sessNameXdm", null);
		returnMap.put("rt", "success");
		
		System.out.println("시퀀스" + httpSession.getAttribute("sessSeqXdm"));
		System.out.println("아이디"+httpSession.getAttribute("sessIdXdm"));
		System.out.println("이름"+httpSession.getAttribute("sessNameXdm"));
		return returnMap;
	}
	
	

}
