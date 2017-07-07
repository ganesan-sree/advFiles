package com.spring.login;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.spring.login.domain.User;

@SuppressWarnings("deprecation")
public class LoginController extends SimpleFormController{
	
	private UserService userService;

	public LoginController()	{
		setCommandClass(User.class);
		setCommandName("login");
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		User login = (User) command;
		userService.add(login);
		//return null; // if we call this line then folling properties is require on xml="p:successView="account/loginSucess" />"
		return new ModelAndView("account/loginSucess","user",login);
	}
}
