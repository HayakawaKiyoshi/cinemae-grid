//吉田 編集中

package com.cinemaEgrid.web.Delete.movie;

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
public class movieDeleteController {	//削除の際選択されたデータを表示するコントローラ
	//セッション準備
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/admin/movie/delete", method = RequestMethod.GET)
	private ModelAndView delete(@RequestParam("No") int no,ModelAndView mav) {
		Movie movie = MovieDao.selectMovie(no);
		session.setAttribute("movie", movie);
		mav.setViewName("Admin/Delete/movie/movieDelete");
		return mav;
	}
	//@RequestMapping(value="")

}
