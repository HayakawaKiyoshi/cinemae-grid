package com.cinemaEgrid.web.Submit;

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
import com.cinemaEgrid.form.SubmitForm;

/**
 * 会員登録
 * @author aishikawa
 *
 */
@Controller
@RequestMapping("/login")
public class SubmitController {

	@Autowired
	HttpSession session;

	//管理者のトップページのurlを記入すること
	//後にpostに変更するように(特に管理者)

	@RequestMapping("/userSubmit")
	private String newUserSubmit(SubmitForm form) {
		//新規会員登録
		return "/Admin/Submit/newUserSubmit";
	}

	@RequestMapping("/userAdminSubmit")
	private String newUserAdminSubmit(SubmitForm form) {
		//管理者会員登録
		return "/Admin/Submit/userAdminSubmit";
	}

	@RequestMapping(value="/userSubmit/check/{type}", method=RequestMethod.POST)
	private ModelAndView newUserSubmitCheck(@PathVariable int type,
			SubmitForm form, ModelAndView mav) {

		session.setAttribute("type", type);

		//IDが同じものがないか確認
		ArrayList<User> userList = UserDao.findAll();
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUser_id().equals(form.getId())) {
				//同じものがあったら戻る
				mav.addObject("msg", "このIDは既に存在します。");
				if(type == 0) {
					mav.setViewName("/Admin/Submit/user/newUserSubmit");
				} else {
					mav.setViewName("/Admin/Submit/user/userAdminSubmit");
				}
				return mav;
			}
		}

		if(type == 0) {
			//ユーザーによる新規会員登録の場合
			mav.setViewName("/Admin/Confirm/newUserSubmitConfirm");
		} else {
			//管理者による新規会員登録の場合
			mav.setViewName("/Admin/Confirm/userAdminSubmitConfirm");
		}

		return mav;
	}

	@RequestMapping(value="/userSubmit/completion", method=RequestMethod.POST)
	private ModelAndView newUserSubmit(SubmitForm form, ModelAndView mav) {

		//登録
		ArrayList<User> userList =
				UserDao.submit(form.getId(), form.getName(), form.getMail(),
				form.getPass(), form.getAuthority(), form.getDel_flg());
		mav.addObject("msg", "会員登録");
		mav.setViewName("/Admin/Done/memberDone");

		if(session.getAttribute("type").equals(0)) {
			//ユーザーによる新規会員登録の場合
			String[] user = UserDao.login
					(userList.get(0).getUser_id(), userList.get(0).getPassword());
			session.setAttribute("user", user);
			mav.addObject("url", "/login/topPage");
			mav.addObject("btn", "トップページへ");
		} else {
			//管理者が行う会員登録の場合
			mav.addObject("url", "/admin/alldisplay");
			mav.addObject("btn", "管理者トップページへ");

		}
		return mav;

	}
}
