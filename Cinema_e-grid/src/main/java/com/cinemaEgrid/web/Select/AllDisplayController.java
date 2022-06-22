package com.cinemaEgrid.web.Select;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// http://localhost:10000/admin/alldisplay

@Controller
@RequestMapping("/admin/alldisplay")
public class AllDisplayController {

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(ModelAndView mav) {
		mav.setViewName("Admin/AllDisplay");
		return mav;
	}
}
