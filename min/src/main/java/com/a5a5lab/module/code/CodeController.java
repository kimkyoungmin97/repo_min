package com.a5a5lab.module.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	@RequestMapping(value="/codeXdmList")
	public String codeXdmList() {
		return "/xdm/code/CodeXdmList";
	}

}
