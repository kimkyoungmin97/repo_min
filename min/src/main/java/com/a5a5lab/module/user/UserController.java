package com.a5a5lab.module.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/userxdmlist")
	public String userxdmlist(Model model, UserVo vo) {
		vo.setParamsPaging(userService.selectOneCount(vo));
		model.addAttribute("vo",vo);
		model.addAttribute("list",userService.selectList(vo));
		return"/xdm/user/UserXdmList";
	}
	@RequestMapping(value="/userxdmform")
	public String userxdmform(Model model, UserDto userDto) {
		model.addAttribute("item", userService.selectOne(userDto));
		
		
		return "/xdm/user/UserXdmForm";
	}

}
