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

	@RequestMapping("/userSubmit")
	private String newUserSubmit(SubmitForm form) {
		return "/Admin/Submit/newUserSubmit";
	}

	@RequestMapping(value="/userSubmit/check/{type}", method=RequestMethod.POST)
	private ModelAndView newUserSubmitCheck(@PathVariable int type,
			SubmitForm form, ModelAndView mav) {

		//ユーザーによる新規会員登録の場合
		if(type == 0) {
			session.setAttribute("type", type);
		}

		//IDが同じものがないか確認
		ArrayList<User> userList = UserDao.findAll();
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUser_id().equals(form.getId())) {
				//同じものがあったら戻る
				mav.addObject("msg", "このIDは既に存在します。");
				mav.setViewName("/Admin/Submit/newUserSubmit");
				return mav;
			}
		}
		mav.setViewName("/Admin/Confirm/newUserSubmitConfirm");

		return mav;
	}

	@RequestMapping(value="/userSubmit/completion", method=RequestMethod.POST)
	private ModelAndView newUserSubmit(SubmitForm form, ModelAndView mav) {

		//登録
		ArrayList<User> userList =
				UserDao.submit(form.getId(), form.getName(), form.getMail(),
				form.getPass(), form.getAuthority(), form.getDel_flg());

		if(session.getAttribute("type").equals(0)) {
			//新規会員登録の場合
			String[] user = UserDao.login
					(userList.get(0).getUser_id(), userList.get(0).getPassword());
			session.setAttribute("user", user);
			mav.addObject("msg", "会員登録");
			mav.addObject("url", "/login/topPage");
			mav.addObject("btn", "トップページへ");
			mav.setViewName("/Admin/Done/memberDone");
		} else {
			//管理者が行う会員登録の場合

		}
		return mav;

	}
}
