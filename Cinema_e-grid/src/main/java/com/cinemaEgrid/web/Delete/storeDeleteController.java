package com.cinemaEgrid.web.Delete;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class storeDeleteController {

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
		mav.setViewName("Admin/Delete/store/storeDelete");
		return mav;
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	private ModelAndView index2(@RequestParam("No") int id, Store form,
			ModelAndView mav, Model model) {
		if (form.getStore_del_flg() == 1) {
			try {
				StoreDao.deleteStore(id);
			} catch (SQLException e) {
			}
			mav.setViewName("Admin/Done/deleteDone");
		} else {
			mav.setViewName("redirect:/admin/alldisplay");
		}
		return mav;
	}
}
