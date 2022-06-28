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

@Controller
public class MovieUpdateController {
	//セッション準備
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/admin/movie/update" , method  = RequestMethod.GET)
	private ModelAndView update(@RequestParam("No") int no,ModelAndView mav) {
		Movie movie = MovieDao.selectMovie(no);
		session.setAttribute("movie", movie);
		mav.setViewName("Admin/Update/movie/movieUpdate");
		return mav;
	}
}
