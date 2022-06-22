package com.cinemaEgrid.web.test;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class test_matsuo {
	@Autowired
	HttpSession session;

	//ログイン関連のコントローラ

	//ログイン画面に遷移するコントローラ
	//http://localhost:10000/cinema/test
	@RequestMapping(value = "/cinema/test", method = RequestMethod.GET)
	private ModelAndView login( ModelAndView mav) {
		mav.setViewName("Layout/Layout");

		return mav;
	}
}
