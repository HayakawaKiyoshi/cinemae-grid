package com.cinemaEgrid.web.test;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//yoshida テスト用コントローラ
@Controller
public class test_yoshida {
	@Autowired
	HttpSession session;
	//
	//上映予定を表示するテストコントローラ

	//ログイン画面に遷移するコントローラ
	//http://localhost:10000/cinema/test
	@RequestMapping(value = "/login/schedule", method = RequestMethod.GET)
	private ModelAndView login( ModelAndView mav) {
		mav.setViewName("User/Reserve/MovieSchedule");

		return mav;
	}
}
