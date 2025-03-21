package com.a5a5lab.module.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	
	
	@RequestMapping(value="/index")
	public String index() {
		return "/user/index";
	}
	
	

}
