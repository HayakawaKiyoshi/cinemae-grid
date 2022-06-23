package com.cinemaEgrid.web.Update.store;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// http://localhost:10000/admin/store/update
/**
* 管理者/店舗情報更新
* @author iwai
*
*/
@Controller
@RequestMapping("/admin/store/update")
public class storeUpdateController {

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(ModelAndView mav) {
		mav.setViewName("Admin/Update/store/storeUpdate");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	private ModelAndView index2(
			//@Validated BindingResult result,
			ModelAndView mav, Model model) {
//		if (result.hasErrors()) {
			mav.setViewName("Admin/Update/store/storeUpdate");
//		} else {
//			mav.setViewName("update/UpdateCheck");
//		}
		return mav;
	}

}
