package com.cinemaEgrid.web.test;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Event;
import com.cinemaEgrid.bean.Movie;
import com.cinemaEgrid.dao.EventDao;
import com.cinemaEgrid.dao.MovieDao;

@Controller
public class test_matsuo {
	@Autowired
	HttpSession session;

	//http://localhost:10000/cinema/test
	@RequestMapping(value = "/cinema/test", method = RequestMethod.GET)
	private ModelAndView login(ModelAndView mav) {
		mav.setViewName("Layout/Layout");

		return mav;
	}

	//http://localhost:10000/cinema/test2
	@RequestMapping(value = "/cinema/test2", method = RequestMethod.GET)
	private ModelAndView Toptest(ModelAndView mav) throws SQLException {

		mav.setViewName("User/Top/TopPage");

		ArrayList<Movie> movieList = MovieDao.selectAllmovie();
		ArrayList<Event> eventList = EventDao.selectEvent();

		mav.addObject("list", movieList);
		mav.addObject("list2", eventList);

		return mav;
	}

	//http://localhost:10000/cinema/test2
	@RequestMapping(value = "top/search", method = RequestMethod.GET)
	private ModelAndView searchMovie(@RequestParam("searchTitle") String title,
			@RequestParam("searchGenre") String genre, ModelAndView mav) throws SQLException {

		mav.setViewName("User/Top/TopPage");

		ArrayList<Movie> movieList = MovieDao.selectAllmovie();

		mav.addObject("list", movieList);

		return mav;
	}

}
