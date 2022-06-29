package com.cinemaEgrid.web.Submit.movie;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.form.MovieForm;

//吉田　編集中

@Controller
@RequestMapping("/admin/movie/submit")
public class MovieSubmitController {
	@Autowired
	HttpSession session;
	
	@RequestMapping(method = RequestMethod.POST)
	private ModelAndView submit(MovieForm form , ModelAndView mav) {
		mav.setViewName("Admin/Submit/movie/movieSubmit");
		return mav;
	}
	
}
