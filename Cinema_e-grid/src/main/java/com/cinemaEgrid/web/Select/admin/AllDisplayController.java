package com.cinemaEgrid.web.Select.admin;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Movie;
import com.cinemaEgrid.bean.Store;
import com.cinemaEgrid.bean.User;
import com.cinemaEgrid.dao.MovieDao;
import com.cinemaEgrid.dao.StoreDao;
import com.cinemaEgrid.dao.UserDao;

// http://localhost:10000/admin/alldisplay
/**
 * 管理者メニュー
 * @author iwai
 *
 */
@Controller
@RequestMapping("/admin/alldisplay")
public class AllDisplayController {

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(User form, Store form2, Movie form3, ModelAndView mav) {
		List<User> userlist = null;
		List<Movie> movielist = null;
		List<Store> storelist = null;
		try {
			userlist = UserDao.findAll();
			movielist = MovieDao.selectAllmovie();
			storelist = StoreDao.dispStore();
		} catch (SQLException e) {
		}
		mav.addObject("ulist", userlist);
		mav.addObject("mlist", movielist);
		mav.addObject("slist", storelist);
		mav.setViewName("Admin/AllDisplay");
		return mav;
	}
}
