package com.a5a5lab.module.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {
	
	
	@RequestMapping(value="/loginXdm")
	public String login() {
		return "/xdm/login/LoginXdm";
	}
	
	

}
