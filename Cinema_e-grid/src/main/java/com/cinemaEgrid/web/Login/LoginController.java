package com.cinemaEgrid.web.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

//	http://localhost:10000/login

	@RequestMapping("/login")
	private String userLogin() {
		return "/User/Login/login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	private ModelAndView userLoginCheck(ModelAndView mav) {
//		mav.setViewName("/User/Login/login");
		mav.setViewName("");
		return mav;
	}

}
