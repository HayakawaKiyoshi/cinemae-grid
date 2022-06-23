package com.cinemaEgrid.web.Update.store;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Store;
import com.cinemaEgrid.dao.StoreDao;

// http://localhost:10000/admin/store/update

/**
* 管理者/店舗情報更新
* @author iwai
*
*/
@Controller
@RequestMapping("/admin/store/update")
@SessionAttributes("store")
public class storeUpdateController {
//	@Autowired
//	HttpSession session;

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(@RequestParam("No") int id,
			Store form, ModelAndView mav) {
		List<Store> storelist = null;
		try {
			storelist = StoreDao.findStore(id);
		} catch (SQLException e) {
		}
		//beanに情報コピー
		BeanUtils.copyProperties(storelist.get(0), form);
		mav.setViewName("Admin/Update/store/storeUpdate");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	private ModelAndView index2(
			//@Validated
			Store form,
			//BindingResult result,
			ModelAndView mav, Model model) {
//		if (result.hasErrors()) {
//			mav.setViewName("Admin/Update/store/storeUpdate");
//		} else {
			mav.setViewName("Admin/Confirm/store/storeCheck");
//		}
		return mav;
	}

	@RequestMapping(value = "/success", params = "back", method = RequestMethod.POST)
	private ModelAndView index3(@Validated Store form, BindingResult result,
			ModelAndView mav, Model model) {
		mav.setViewName("Admin/Update/store/storeUpdate");
		return mav;
	}

	@RequestMapping(value = "/success", params = "exec", method = RequestMethod.POST)
	private ModelAndView index4(Store form, ModelAndView mav) {
		try {
			StoreDao.updateStore(form);
		} catch (SQLException e) {
		}
		mav.setViewName("Admin/Done/updateSuccess");
		return mav;
	}

}
