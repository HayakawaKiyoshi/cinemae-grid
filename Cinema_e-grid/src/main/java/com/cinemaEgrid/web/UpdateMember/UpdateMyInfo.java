package com.cinemaEgrid.web.UpdateMember;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.User;
import com.cinemaEgrid.dao.UserDao;
import com.cinemaEgrid.form.UpdateForm;

@Controller
@RequestMapping("/login")
public class UpdateMyInfo {

	@Autowired
	HttpSession session;

	//ログインしてからでないと確認できないので、仮の値を入れています。
	//マイページ完成後にpostに変更するように

//	http://localhost:10000/login/myPage/userUpdate/0

	@RequestMapping(value="/myPage/userUpdate/{type}")
	private String newUserUpdate(@PathVariable int type, UpdateForm form) {
		//マイページからプロフィール編集画面へ
		if(type == 0) {
			//最初に入る時
//		String[] user = (String[]) session.getAttribute("user");
//		System.out.println(user[0] + "aa");
//		ArrayList<User> userList = UserDao.search(user[0]);
			ArrayList<User> userList = UserDao.search("123");
			session.setAttribute("updateUser", userList);
			form.setName(userList.get(0).getUser_name());
			form.setEmail(userList.get(0).getUser_mail());
		}
		return "/Admin/Update/memberUpdate";
	}

	@RequestMapping(value="/myPage/userUpdate/check", method=RequestMethod.POST)
	private ModelAndView newUserUpdateCheck(UpdateForm form,
			ModelAndView mav) {
		mav.setViewName("/Admin/Confirm/myUpdateConfirm");
		return mav;

	}

	@RequestMapping(value="/myPage/userUpdate/done", method=RequestMethod.POST)
	private ModelAndView newUserUpdateDone(UpdateForm form,
			ModelAndView mav) {
		ArrayList<User> updateUser =
				(ArrayList<User>) session.getAttribute("updateUser");
		String id = updateUser.get(0).getUser_id();
		String pass = updateUser.get(0).getPassword();
		String auth = updateUser.get(0).getAuthority();
		String del_flg = updateUser.get(0).getUser_del_flg();
		UserDao.update(id, form.getEmail(), form.getName(), pass, auth, del_flg);
		mav.addObject("title", "プロフィール変更完了");
		mav.addObject("msg", "プロフィールの変更");
		mav.addObject("uel", "/cinena/mypage/top");
		mav.addObject("btn", "マイページへ");
		mav.setViewName("/Admin/Done/myUpdateDone");
		return mav;

	}
}
