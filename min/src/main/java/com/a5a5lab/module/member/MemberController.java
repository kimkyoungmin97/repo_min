package com.a5a5lab.module.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.a5a5lab.module.code.CodeService;
import com.a5a5lab.module.mail.MailService;
import com.a5a5lab.module.util.UtilDateTime;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	CodeService codeService;
	@Autowired
	private MailService mailService;
	
	@RequestMapping(value="/memberXdmList")
	public String memberxdmlist(Model model, @ModelAttribute("vo") MemberVo vo) {
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
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

		if(matchesBcrypt(dto.getUserPw(),rtMember.getUserPw(),10)) {
			returnMap.put("rt","success");
			httpSession.setAttribute("sessSeqXdm", rtMember.getUserSeq());
			httpSession.setAttribute("sessIdXdm", rtMember.getUserId());
			httpSession.setAttribute("sessNameXdm", rtMember.getUserName());	

		} else {
			
		}
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
	
//------------------------------user
	@RequestMapping(value="/iguana/loginUser")
	public String loginUser() {
		return"user/loginUser";
	}
	
	@RequestMapping(value="/iguana/myPage")
	public String myPage() {
		return"user/mypage/MyPage";
	}
	@RequestMapping(value="/iguana/myPagePasswordEdit")
	public String myPagePasswordEdit() {
		return"user/mypage/MyPagePasswordEdit";
	}
	
	@RequestMapping(value="/iguana/register")
	public String register(Model model, MemberDto memberDto) throws Exception {
//		memberService.codeList(memberDto);
		
		return "user/register";
	}
	
	@RequestMapping(value="/registerInst")
	public String registerInst(MemberDto memberDto) throws Exception {
//		memberDto.setUserPw(encodeBcrypt(memberDto.getUserPw(),10));
//		memberService.insert(memberDto);
		
		Thread thread = new Thread(new Runnable() {
		    @Override
		    public void run() {
		        try {
		            // 여기에 실행할 코드 작성
		            mailService.sendMailWelcome();  //회원가입 축하 메일 전송
		        } catch (Exception e) {
		            e.printStackTrace(); // 예외 처리
		        }
		    }
		});
		thread.start(); //실행
		return"redirect:/index";
		
	}

	@ResponseBody
	@RequestMapping(value="/registerProc")
	public Map<String, Object> registerProc(MemberDto memberDto) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		MemberDto rtMember = memberService.selectOne(memberDto);
		if(rtMember != null) {
			returnMap.put("rt","success");
		} else {
			returnMap.put("rt","fail");
		
		}
		return returnMap;
	}
	
	//암호화
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
	

}
