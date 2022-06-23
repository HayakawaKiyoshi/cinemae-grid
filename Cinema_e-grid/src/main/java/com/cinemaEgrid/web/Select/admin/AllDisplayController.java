package com.cinemaEgrid.web.Select.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	private ModelAndView index(ModelAndView mav) {
		mav.setViewName("Admin/AllDisplay");
		return mav;
	}
}
