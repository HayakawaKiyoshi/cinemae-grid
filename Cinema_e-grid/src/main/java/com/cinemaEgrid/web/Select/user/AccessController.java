package com.cinemaEgrid.web.Select.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// http://localhost:10000/user/access
/**
 * 店舗一覧
 * @author iwai
 *
 */
@Controller
@RequestMapping("/user/access")
public class AccessController {
	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(ModelAndView mav) {
		mav.setViewName("User/Access/AccessDisplay");
		return mav;
	}

}
