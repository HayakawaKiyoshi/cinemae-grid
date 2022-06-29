package com.cinemaEgrid.web.Update.movie;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Movie;
import com.cinemaEgrid.dao.MovieDao;
import com.cinemaEgrid.form.MovieForm;

@Controller
public class MovieUpdateController {
	//セッション準備
	@Autowired
	HttpSession session;

	//変更するmovieの情報を取得
	@RequestMapping(value = "/admin/movie/update" , method  = RequestMethod.GET)
	private ModelAndView update(@RequestParam("No") int no,ModelAndView mav,MovieForm form) {

		Movie movie = MovieDao.selectMovie(no);
		session.setAttribute("no", no);
		session.setAttribute("movie", movie);
		//変更画面に遷移
		mav.setViewName("Admin/Update/movie/movieUpdate");
		return mav;


	}
	//変更確認画面表示
	@RequestMapping(value = "/admin/movie/update/success" , method = RequestMethod.GET)
	private ModelAndView updatedone(MovieForm form,ModelAndView mav	) {
		session.setAttribute("movie", form);
		mav.setViewName("Admin/Done/movieUpdateDone");
		return mav;
	}
	//戻るボタンが押された場合のコントローラ
	@RequestMapping(value = "/admin/movie/update/cancel" ,method = RequestMethod.GET)
	private ModelAndView updatecancel(MovieForm form,ModelAndView mav) {
		mav.setViewName("Admin/Update/movie/movieUpdate");
		return mav;
	}
	@RequestMapping(value = "/admin/movie/update/done" ,method =  RequestMethod.GET)
	private ModelAndView updateDone(ModelAndView mav) {
		MovieForm movie = (MovieForm) session.getAttribute("movie");
		int no = (int) session.getAttribute("no");
		MovieDao.updateMovie(movie,no);
		mav.setViewName("/Admin/Done/memberDone");
		mav.addObject("msg", "映画更新");
		mav.addObject("url", "/admin/alldisplay");
		mav.addObject("btn", "管理者トップページへ");
		return mav;
	}
}
