package com.cinemaEgrid.web.Delete.user;
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

import com.cinemaEgrid.bean.User;
import com.cinemaEgrid.dao.UserAdminDao;

/**
* 管理者/会員情報削除
* @author iwai
*
*/
@Controller
@RequestMapping("/admin/user/delete")
@SessionAttributes("user")
public class UserAdminDeleteController {

	@ModelAttribute("user")
	public User setUpUser() {
		return new User();
	}

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(@RequestParam("ID") String id,
			User form, ModelAndView mav) {
		List<User> Userlist = null;
		try {
			Userlist = UserAdminDao.findOneUser(id);
		} catch (SQLException e) {
		}
		//beanに情報コピー
		BeanUtils.copyProperties(Userlist.get(0), form);
		mav.setViewName("Admin/Delete/user/userAdminDelete");
		return mav;
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	private ModelAndView index2(@RequestParam("ID") String id, User form,
			ModelAndView mav, Model model) {
		if (form.getUser_del_flg().equals("1")) {
			try {
				UserAdminDao.deleteAdminUser(id);
			} catch (SQLException e) {
			}
			mav.setViewName("Admin/Done/deleteDone");
		} else {
			mav.addObject("msg", "ユーザー削除フラグが機能しています");
			mav.setViewName("redirect:/admin/alldisplay");
		}
		return mav;
	}
}