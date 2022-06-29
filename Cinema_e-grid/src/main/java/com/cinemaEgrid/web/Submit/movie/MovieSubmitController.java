package com.cinemaEgrid.web.Submit.movie;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Store;
import com.cinemaEgrid.dao.MovieDao;
import com.cinemaEgrid.form.MovieForm;

//吉田　編集中

@Controller
@RequestMapping("/admin/movie/submit")
public class MovieSubmitController {
	@Autowired
	HttpSession session;

	//登録画面に遷移するa
	@RequestMapping(method = RequestMethod.POST)
	private ModelAndView submit(@ModelAttribute MovieForm form, ModelAndView mav) {
		session.setAttribute("form", form);
		mav.setViewName("Admin/Submit/movie/movieSubmit");
		return mav;
	}

	//登録確認画面を表示する
	@RequestMapping(value = "/", method = RequestMethod.POST)
	private ModelAndView submitconfirm(@ModelAttribute @Validated MovieForm form, BindingResult result,
			ModelAndView mav) {
		if (result.hasErrors()) {
			mav.addObject("movieForm", form);
			mav.setViewName("Admin/Submit/movie/movieSubmit");
		} else {
			session.setAttribute("form", form);
			mav.setViewName("Admin/Confirm/movie/movieSubmitConfirm");
			mav.addObject("msg", "映画");
			mav.addObject("url", "/admin/movie/submit/success");
			mav.addObject("btn", "登録確定");
		}
		return mav;
	}

	//戻るボタンが押された場合のコントローラ
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	private ModelAndView updatecancel(MovieForm form, ModelAndView mav) {
		mav.addObject("movieForm", session.getAttribute("form"));
		mav.setViewName("Admin/Submit/movie/movieSubmit");
		return mav;
	}

	//戻るボタンが押下された場合
	@RequestMapping(value = "/back", method = RequestMethod.POST)
	private ModelAndView index3(@Validated Store form, BindingResult result,
			ModelAndView mav, Model model) {
		mav.setViewName("Admin/Submit/movie/movieSubmit");
		return mav;
	}

	//登録完了画面を表示する
	@RequestMapping(value = "/success", method = RequestMethod.POST)
	private ModelAndView submitdone(@ModelAttribute MovieForm form, ModelAndView mav) {
		MovieForm movie = (MovieForm) session.getAttribute("form");
		MovieDao.submitMovie(movie);
		session.removeAttribute("form");
		mav.setViewName("/Admin/Done/memberDone");
		mav.addObject("msg", "映画登録");
		mav.addObject("url", "/admin/alldisplay");
		mav.addObject("btn", "管理者トップページへ");
		return mav;
	}
}
