package com.spring.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserRegistrationSuccessController {

	@RequestMapping("/userSuccess.htm")
	public String redirect()
	{
		return "annotation/userSuccess";
	}
}
