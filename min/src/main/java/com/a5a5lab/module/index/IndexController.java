package com.a5a5lab.module.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping(value="/indexXdm")
	public String indexXdm() {
		return "xdm/Index";
	}
	@RequestMapping(value="/index")
	public String index() {
		return "user/index";
	}
}
