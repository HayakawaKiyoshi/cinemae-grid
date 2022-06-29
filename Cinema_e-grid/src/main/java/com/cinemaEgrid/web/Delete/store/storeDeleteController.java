package com.cinemaEgrid.web.Delete.store;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Store;
import com.cinemaEgrid.dao.StoreDao;

// http://localhost:10000/admin/store/delete

/**
* 管理者/店舗情報削除
* @author iwai
*
*/
@Controller
@RequestMapping("/admin/store/delete")
@SessionAttributes("store")
public class storeDeleteController {

	@ModelAttribute("store")
	public Store setUpStore() {
		return new Store();
	}

	@RequestMapping(method = RequestMethod.POST)
	private ModelAndView index(@RequestParam("No") int id,
			Store form, ModelAndView mav) {
		List<Store> storelist = null;
		try {
			storelist = StoreDao.findStore(id);
		} catch (SQLException e) {
		}
		//beanに情報コピー
		BeanUtils.copyProperties(storelist.get(0), form);
		mav.setViewName("Admin/Delete/store/storeDelete");
		return mav;
	}

	@RequestMapping(value = "/success", method = RequestMethod.POST)
	private ModelAndView index2(Store form, ModelAndView mav, Model model) {
			try {
				StoreDao.deleteStore(form);
			} catch (SQLException e) {
			}
			mav.setViewName("/Admin/Done/memberDone");
			mav.addObject("msg", "店舗削除");
			mav.addObject("url", "/admin/alldisplay");
			mav.addObject("btn", "管理者トップページへ");
		return mav;
	}
}
