package com.cinemaEgrid.web.Delete;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.User;

// http://localhost:10000/admin/user/delete

/**
* 管理者/会員情報削除
* @author iwai
*
*/
@Controller
@RequestMapping("/admin/user/delete")
public class UserAdminDeleteController {

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(@RequestParam("ID") String id,
			User form, ModelAndView mav) {
//		List<User> Userlist = null;
//		try {
//			Userlist = UserDao.findOneUser(id);
//		} catch (SQLException e) {
//		}
//		//beanに情報コピー
//		BeanUtils.copyProperties(Userlist.get(0), form);
		mav.setViewName("Admin/Delete/user/userAdminDelete");
		return mav;
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	private ModelAndView index2(@RequestParam("ID") String id, User form,
			ModelAndView mav, Model model) {

		if (form.getUser_del_flg().equals("1")) {
//			try {
//				UserDao.deleteUser(id);
//			} catch (SQLException e) {
//			}
			mav.setViewName("Admin/Done/deleteDone");
		} else {
			mav.setViewName("redirect:/admin/alldisplay");
		}
		return mav;
	}
}