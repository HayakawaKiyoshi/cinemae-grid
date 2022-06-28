package com.cinemaEgrid.web.Delete.user;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class UserAdminDeleteController {
	@Autowired
	HttpSession session;

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(@RequestParam("ID") String id,
			User form, ModelAndView mav) {
		User menber = UserAdminDao.findOneUser(id);
		session.setAttribute("user", menber);
		mav.setViewName("Admin/Delete/user/userAdminDelete");
		return mav;
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	private ModelAndView index2(@RequestParam("ID") String id, User form,
			ModelAndView mav, Model model) {
		User form1 = (User) session.getAttribute("user");
		if (form1.getUser_del_flg().equals("1")) {
			try {
				UserAdminDao.deleteAdminUser(id);
			} catch (SQLException e) {
			}
			mav.setViewName("/Admin/Done/memberDone");
			mav.addObject("msg", "会員削除");
			mav.addObject("url", "/admin/alldisplay");
			mav.addObject("btn", "管理者トップページへ");
		} else {
			mav.addObject("msg", "ユーザー削除フラグが機能しています");
			mav.setViewName("redirect:/admin/alldisplay");
		}
		return mav;
	}
}