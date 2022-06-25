package com.cinemaEgrid.web.Delete;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinemaEgrid.bean.User;
import com.cinemaEgrid.dao.UserDao;

/**
 * ユーザーによる退会
 * @author aishikawa
 *
 */
@Controller
@RequestMapping("/login")
public class MyUserDelete {

	@Autowired
	HttpSession session;

//	http://localhost:10000/login/delete

	@RequestMapping("/delete")
	private String myUserDeleteCheck() {
		return "/Admin/Delete/user/myUserDelete";

	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	private String myUserDelete() {
//		String[] user = (String[]) session.getAttribute("user");
//		ArrayList<User> userList = UserDao.search(user[0]);
		ArrayList<User> userList = UserDao.search("123");
		UserDao.delete(userList.get(0).getUser_id(), userList.get(0).getUser_mail(),
				userList.get(0).getUser_name(), userList.get(0).getPassword(),
				userList.get(0).getAuthority());
		return "/Admin/Done/myUserDeleteDone";

	}
}
