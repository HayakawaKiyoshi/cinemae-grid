package com.cinemaEgrid.web.Update.store;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.User;
import com.cinemaEgrid.dao.UserAdminDao;

// http://localhost:10000/admin/user/update

/**
* 管理者/会員情報更新
* @author iwai
*
*/
@Controller
@RequestMapping("/admin/user/update")
@SessionAttributes("user")
public class UserAdminUpdateController {

	@ModelAttribute("user")
	public User setUpUser() {
		return new User();
	}

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(@RequestParam("ID") String id,
			User form, ModelAndView mav) {
		List<User> userlist = null;
		try {
			userlist = UserAdminDao.findOneUser(id);
		} catch (SQLException e) {
		}
		//beanに情報コピー
		BeanUtils.copyProperties(userlist.get(0), form);
		mav.setViewName("Admin/Update/user/userAdminUpdate");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	private ModelAndView index2(@Validated User form,
			BindingResult result,
			ModelAndView mav, Model model) {
		if (result.hasErrors()) {
			mav.setViewName("Admin/Update/user/storeUpdate");
		} else {
			mav.setViewName("Admin/Confirm/user/updateConfirm");
		}
		return mav;
	}

	@RequestMapping(value = "/success", params = "back", method = RequestMethod.POST)
	private ModelAndView index3(@Validated User form, BindingResult result,
			ModelAndView mav, Model model) {
		mav.setViewName("Admin/Update/user/userAdminUpdate");
		return mav;
	}

	@RequestMapping(value = "/success", params = "exec", method = RequestMethod.POST)
	private ModelAndView index4(User form, ModelAndView mav) {
		try {
			UserAdminDao.updateAdminUser(form);
		} catch (SQLException e) {
		}
		mav.setViewName("Admin/Done/updateDone");
		return mav;
	}

}
