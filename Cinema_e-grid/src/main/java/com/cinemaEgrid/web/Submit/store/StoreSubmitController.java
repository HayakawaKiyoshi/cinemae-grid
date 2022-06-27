package com.cinemaEgrid.web.Submit.store;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Store;
import com.cinemaEgrid.dao.StoreDao;

// http://localhost:10000/admin/store/submit

/**
* 管理者/店舗情報登録
* @author iwai
*
*/
@Controller
@RequestMapping("/admin/store/submit")
@SessionAttributes("store")
public class StoreSubmitController {
	@Autowired
	HttpSession session;

	@ModelAttribute("store")
	public Store setUpStore() {
		return new Store();
	}

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(Store form, ModelAndView mav) {
		mav.setViewName("Admin/Submit/store/storeSubmit");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	private ModelAndView index2(@Validated Store form,
			BindingResult result,
			ModelAndView mav, Model model) {
		if (result.hasErrors()) {
			mav.setViewName("Admin/Submit/store/storeSubmit");
		} else {
			mav.setViewName("Admin/Confirm/store/submitConfirm");
		}
		return mav;
	}

	@RequestMapping(value = "/success", params = "back", method = RequestMethod.POST)
	private ModelAndView index3(@Validated Store form, BindingResult result,
			ModelAndView mav, Model model) {
		mav.setViewName("Admin/Submit/store/storeSubmit");
		return mav;
	}

	@RequestMapping(value = "/success", params = "exec", method = RequestMethod.POST)
	private ModelAndView index4(Store form, ModelAndView mav) {
		try {
			StoreDao.submitStore(form);
		} catch (SQLException e) {
		}
//		mav.addObject("msg", "店舗登録");
//		mav.addObject("url", "/admin/alldisplay");
//		mav.addObject("btn", "管理者メニューへ");
		mav.setViewName("Admin/Done/submitDone");
		return mav;
	}

	@RequestMapping("/destroy")
	public String destroy(SessionStatus sessionStatus) {
		// セッション廃棄
		sessionStatus.setComplete();
		session.removeAttribute("store");
		return "redirect:/admin/store/submit";
	}

}
