package com.cinemaEgrid.web.Submit.store;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Store;
import com.cinemaEgrid.dao.StoreDao;

/**
* 管理者/店舗情報登録
* @author iwai
*
*/
@Controller
@RequestMapping("/admin/store/submit")
public class StoreSubmitController {
	@Autowired
	HttpSession session;

	@RequestMapping(method = RequestMethod.POST)
	private ModelAndView index(Store form, ModelAndView mav, Model model) {
		mav.setViewName("Admin/Submit/store/storeSubmit");
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	private ModelAndView index2(@Validated Store form,
			BindingResult result, ModelAndView mav, Model model) {
		if (result.hasErrors()) {
			mav.setViewName("Admin/Submit/store/storeSubmit");
		} else {
			mav.setViewName("Admin/Confirm/store/storeConfirm");
			session.setAttribute("store",form);
			mav.addObject("msg", "店舗");
			mav.addObject("url", "/admin/store/submit/success");
			mav.addObject("btn", "登録確定");
		}
		return mav;
	}

	@RequestMapping(value = "/success", params = "back", method = RequestMethod.POST)
	private ModelAndView index3(@Validated Store form, BindingResult result,
			ModelAndView mav, Model model) {
		// セッションよりデータを取得して設定
		Store stores = (Store) session.getAttribute("store");
		mav.addObject("store", stores);
		mav.setViewName("Admin/Submit/store/storeSubmit");
		return mav;
	}

	@RequestMapping(value = "/success", params = "exec", method = RequestMethod.POST)
	private ModelAndView index4(Store form, ModelAndView mav) {
		// セッションよりデータを取得して設定
		Store stores = (Store) session.getAttribute("store");
		mav.addObject("store", stores);
		try {
			StoreDao.submitStore(stores);
		} catch (SQLException e) {
		}
		mav.setViewName("/Admin/Done/memberDone");
		mav.addObject("msg", "店舗登録");
		mav.addObject("url", "/admin/alldisplay");
		mav.addObject("btn", "管理者トップページへ");
		return mav;
	}

}
