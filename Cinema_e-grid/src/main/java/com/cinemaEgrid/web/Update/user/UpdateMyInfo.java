package com.cinemaEgrid.web.Update.user;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.User;
import com.cinemaEgrid.dao.UserDao;
import com.cinemaEgrid.form.UpdateForm;

/**
 * プロフィール変更
 * @author aishikawa
 *
 */
@Controller
@RequestMapping("/login")
public class UpdateMyInfo {

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/myPage/userUpdate/{type}", method = RequestMethod.POST)
	private String newUserUpdate(@PathVariable int type, UpdateForm form) {
		//マイページからプロフィール編集画面へ
		if (type == 0) {
			//最初に入る時
			String[] user = (String[]) session.getAttribute("user");
			System.out.println(user[0] + "aa");
			ArrayList<User> userList = UserDao.search(user[0]);
			session.setAttribute("updateUser", userList);
			form.setName(userList.get(0).getUser_name());
			form.setEmail(userList.get(0).getUser_mail());
		}
		return "/User/Update/memberUpdate";
	}

	@RequestMapping(value = "/myPage/userUpdate/check", method = RequestMethod.POST)
	private ModelAndView newUserUpdateCheck(@Validated UpdateForm form,
			BindingResult result, ModelAndView mav) {
		if (result.hasErrors()) {
			//エラーチェック
			mav.setViewName("/User/Update/memberUpdate");
		} else {
			mav.setViewName("/Admin/Confirm/user/myUpdateConfirm");
		}
		return mav;

	}

	@RequestMapping(value = "/myPage/userUpdate/done", method = RequestMethod.POST)
	private ModelAndView newUserUpdateDone(UpdateForm form,
			ModelAndView mav) {
		ArrayList<User> updateUser = (ArrayList<User>) session.getAttribute("updateUser");
		String id = updateUser.get(0).getUser_id();
		String pass = updateUser.get(0).getPassword();
		String auth = updateUser.get(0).getAuthority();
		String del_flg = updateUser.get(0).getUser_del_flg();
		UserDao.update(id, form.getEmail(), form.getName(), pass, auth, del_flg);
		mav.addObject("title", "プロフィール変更完了");
		mav.addObject("msg", "プロフィールの変更");
		mav.addObject("url", "/mypage");
		mav.addObject("btn", "マイページへ");
		mav.setViewName("/Admin/Done/myUpdateDone");
		return mav;

	}
}
