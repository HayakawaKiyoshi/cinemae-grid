package com.cinemaEgrid.web.Select.user;

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
public class TopPageController {
	@Autowired
	HttpSession session;


	//http://localhost:10000/toppage
	@RequestMapping(value = "/toppage", method = RequestMethod.POST)
	private ModelAndView Toptest(ModelAndView mav) throws SQLException {

		mav.setViewName("User/Top/TopPage");

		ArrayList<Movie> movieList = MovieDao.selectAllmovie();
		ArrayList<Event> eventList = EventDao.selectEvent();

		mav.addObject("movieList", movieList);
		mav.addObject("eventList", eventList);

		return mav;
	}

	//http://localhost:10000/top/search
	@RequestMapping(value = "top/search", method = RequestMethod.GET)
	private ModelAndView searchMovie(@RequestParam("searchTitle") String title,
			@RequestParam("searchGenre") String genre, @RequestParam("searchGenre") String genre2, ModelAndView mav)
			throws SQLException {

		mav.setViewName("User/Top/topPage");
		if(title.equals("") && genre != "") {
			ArrayList<Movie> movieList = MovieDao.searchGenreMovie(genre, genre2);
			mav.addObject("movieList", movieList);

		} else if(genre.equals("")) {
			ArrayList<Movie> movieList = MovieDao.searchSelectMovie(title, genre, genre2);
			mav.addObject("movieList", movieList);
		} else if(genre.equals("") && title.equals("")) {
			ArrayList<Movie> movieList = MovieDao.searchSelectMovie(title, genre, genre2);
			mav.addObject("movieList", movieList);
		}


		ArrayList<Event> eventList = EventDao.selectEvent();

		mav.addObject("eventList", eventList);

		return mav;
	}

}