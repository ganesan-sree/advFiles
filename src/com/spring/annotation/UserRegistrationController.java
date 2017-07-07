package com.spring.annotation;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.login.UserService;
import com.spring.login.domain.Community;
import com.spring.login.domain.Country;
import com.spring.login.domain.User;


@Controller
@RequestMapping("/userRegistration.htm")
@SessionAttributes("user")
public class UserRegistrationController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@ModelAttribute("countryList")
	public List<Country> populateCountryList() {
		return userService.getAllCountries();
	}
	
	@ModelAttribute("communityList")
	public List<Community> populateCommunityList() {
		return userService.getAllCommunities();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "annotation/userForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid @ModelAttribute("user") User user,BindingResult result) {
		System.out.println("Errrororrrrrrrrrrrrrrrrrr  "+result.hasErrors());
		userService.add(user);
		return "redirect:userSuccess.htm";
	}
	
}
