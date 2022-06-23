package com.cinemaEgrid.web.Select.admin;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Store;
import com.cinemaEgrid.dao.StoreDao;

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
	private ModelAndView index(Store form, ModelAndView mav) {
		List<Store> storelist = null;
		try {
			storelist = StoreDao.dispStore();
		} catch (SQLException e) {
		}
		mav.addObject("list", storelist);
		mav.setViewName("Admin/AllDisplay");
		return mav;
	}

//	@RequestMapping(method = RequestMethod.POST)
//	private ModelAndView index2(StoreForm form, ModelAndView mav, Model model) {
//		List<StoreForm> storelist = null;
//		try {
//			storelist = StoreDao.storeDisp();
//		} catch (SQLException e) {
//		}
//		mav.addObject("list", storelist);
//		mav.setViewName("Admin/AllDisplay");
//		return mav;
//	}
}
