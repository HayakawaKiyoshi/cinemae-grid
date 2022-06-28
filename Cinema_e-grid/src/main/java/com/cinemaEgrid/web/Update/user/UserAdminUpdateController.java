package com.cinemaEgrid.web.Update.user;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
public class UserAdminUpdateController {
	@Autowired
	HttpSession session;

	@RequestMapping(method = RequestMethod.GET)
	private ModelAndView index(@RequestParam("ID") String id,
			User form, ModelAndView mav) {
		User menber = UserAdminDao.findOneUser(id);
		session.setAttribute("user", menber);
		// セッションよりデータを取得して設定
		User menbers = (User) session.getAttribute("user");
		mav.addObject("user", menbers);
		mav.setViewName("Admin/Update/user/userAdminUpdate");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST)
	private ModelAndView index2(@Validated User form, BindingResult result,
			ModelAndView mav, Model model) {
		if (result.hasErrors()) {
			mav.setViewName("Admin/Update/user/userAdminUpdate");
		} else {
			// セッション設定
			session.setAttribute("user", form);
			mav.setViewName("Admin/Confirm/user/updateConfirm");
		}
		return mav;
	}

	@RequestMapping(value = "/success", params = "back", method = RequestMethod.POST)
	private ModelAndView index3(@Validated User form, BindingResult result,
			ModelAndView mav, Model model) {
		// セッションよりデータを取得して設定
		User menbers = (User) session.getAttribute("user");
		mav.addObject("user", menbers);
		mav.setViewName("Admin/Update/user/userAdminUpdate");
		return mav;
	}

	@RequestMapping(value = "/success", params = "exec", method = RequestMethod.POST)
	private ModelAndView index4(User form, ModelAndView mav) {
		// セッションよりデータを取得して設定
		User menbers = (User) session.getAttribute("user");
		mav.addObject("user", menbers);
		try {
			UserAdminDao.updateAdminUser(menbers);
		} catch (SQLException e) {
		}
		mav.setViewName("/Admin/Done/memberDone");
		mav.addObject("msg", "会員更新");
		mav.addObject("url", "/admin/alldisplay");
		mav.addObject("btn", "管理者トップページへ");
		return mav;
	}

}
