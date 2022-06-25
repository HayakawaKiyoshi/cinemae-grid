package com.cinemaEgrid.web.Login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.dao.UserDao;
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

		String[] user = UserDao.login(form.getId(), form.getPass());

		if (user[0] != null && user[3].equals("0")) {
			//該当する会員がいた場合
			session.setAttribute("user", user);

			if(user[1].equals("3")) {
				//管理者の場合は管理者ログインページへ
				mav.setViewName("/User/Login/adminLogin");
			} else {
				//管理者以外の場合はトップページへ
				mav.setViewName("/login/topPage");
			}
		} else {
			//該当する会員がいない時は、ログイン画面へ
			mav.setViewName("/User/Login/login");
			mav.addObject("msg", "IDまたはパスワードが違います");
		}
		return mav;
	}

	@RequestMapping(value="/login/adminLogin", method=RequestMethod.POST)
	private ModelAndView adminLogin(LoginForm form, ModelAndView mav) {
		//管理者ID(pass)が入力されたら管理者用のトップページへ
		if(form.getAdminId().equals("pass")) {
			mav.setViewName("/admin/alldisplay");
		} else {
			//管理者IDが間違えていたら戻る
			mav.addObject("msg", "管理者用のIDが違います。");
			mav.setViewName("/User/Login/adminLogin");
		}
		return mav;
	}


	@RequestMapping(value="/logout", method=RequestMethod.POST)
	private String userLogout(SessionStatus sessionStatus) {
		// セッション廃棄
		sessionStatus.setComplete();
		session.removeAttribute("user");
		return "redirect:/login";
	}

}
