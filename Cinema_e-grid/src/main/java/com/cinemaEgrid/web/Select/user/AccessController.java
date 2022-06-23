package com.cinemaEgrid.web.Select.user;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Store;
import com.cinemaEgrid.dao.StoreDao;

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
	private ModelAndView index(Store form, ModelAndView mav) {
		List<Store> storelist = null;
		try {
			storelist = StoreDao.storeDisp();
		} catch (SQLException e) {
		}
		mav.addObject("list", storelist);
		mav.setViewName("User/Access/AccessDisplay");
		return mav;
	}

}
