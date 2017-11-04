package com.hotsix.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {
	
	// 이용약관
	@RequestMapping("/accessterms.mt")
	public String accessterms(){
		return "accessterms";
	}
	
	// 개인정보취급방침
	@RequestMapping("/privacy.mt")
	public String privacy(){
		return "privacy";
	}
}
