package com.cinemaEgrid.web.Submit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 会員登録
 * @author aishikawa
 *
 */
@Controller
@RequestMapping("/login")
public class SubmitController {

	@RequestMapping("/userSubmit")
	private String newUserSubmit() {
		return "/Admin/Submit/newUserSubmit";
	}

	@RequestMapping(value="/userSubmit", method=RequestMethod.POST)
	private ModelAndView newUserSubmitCheck(ModelAndView mav) {
//		mav.setViewName("/Admin/Submit/newUserSubmit");
		mav.setViewName("");
		return mav;
	}
}
