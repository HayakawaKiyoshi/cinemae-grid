package com.cinemaEgrid.web.Login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.dao.User_TableDao;
import com.cinemaEgrid.form.LoginForm;

/**
 * ログイン
 * @author aishikawa
 *
 */
@Controller
public class LoginController {

	@Autowired
	HttpSession session;

//	http://localhost:10000/login

	@RequestMapping("/login")
	private String userLogin(LoginForm form) {
		return "/User/Login/login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	private ModelAndView userLoginCheck(LoginForm form, ModelAndView mav) {

		String[] user = User_TableDao.login(form.getId(), form.getPass());

		if (user[0] != null) {
			//該当する会員がいた場合、トップ画面へ
			session.setAttribute("user", user);
			mav.setViewName("/login/topPage");
		} else {
			//該当する会員がいない時は、ログイン画面へ
			mav.setViewName("/User/Login/login");
			mav.addObject("msg", "IDまたはパスワードが違います");
		}
		return mav;
	}

}
