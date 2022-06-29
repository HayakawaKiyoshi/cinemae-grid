package com.cinemaEgrid.web.Mypage;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Reserve;
import com.cinemaEgrid.dao.ReserveDao;
/**
* マイページ表示、予約キャンセル
* @author matsuo
*
*/

@Controller
public class MyPageController {
	@Autowired
	HttpSession session;

	//マイページトップ表示コントローラ
	//http://localhost:10000/mypage
	@RequestMapping(value = "/mypage", method = RequestMethod.POST)
	private ModelAndView myPage(ModelAndView mav) throws SQLException {

		mav.setViewName("User/MyPage/myPage");

		return mav;
	}

	//予約履歴表示コントローラ
	//http://localhost:10000/mypage/history
	@RequestMapping(value = "/mypage/reservelog", method = RequestMethod.GET)
	private ModelAndView reserveLog(ModelAndView mav) throws SQLException {

		String[] user = (String[]) session.getAttribute("user");

		//ユーザーごとの予約履歴取得
		ArrayList<Reserve> reserveList = ReserveDao.selectReserve(user[0]);

		mav.setViewName("User/MyPage/reserveLog");
		mav.addObject("reserveList", reserveList);
		//System.out.println("test" +  reserveList);
		return mav;
	}

	//予約キャンセルコントローラ
	//http://localhost:10000/mypage/history
	@RequestMapping(value = "/mypage/reservelog/cancel", method = RequestMethod.GET)
	private ModelAndView reserveCancel(@RequestParam("code") String code, ModelAndView mav) throws SQLException {


		String[] user = (String[]) session.getAttribute("user");

		Reserve reserve = ReserveDao.reserveCancel(user[0], code);

		mav.setViewName("User/Reserve/reserveCancel");
		mav.addObject("reserveCancel", reserve);
		//System.out.println("test" +  reserveList);
		return mav;
	}

	//予約キャンセルコントローラ
	//http://localhost:10000/mypage/history
	@RequestMapping(value = "/mypage/reservelog/cancel/done", method = RequestMethod.POST)
	private ModelAndView reserveCancelDone(@RequestParam("code") String code, ModelAndView mav) throws SQLException {

		System.out.println(code);
		String[] user = (String[]) session.getAttribute("user");

		ReserveDao.reserveCancelDone(user[0], code);

		String id = null;
		// (String) session.getAttribute("ユーザーセッション");

		mav.setViewName("User/Reserve/reserveCancelDone");

		//System.out.println("test" +  reserveList);
		return mav;
	}
}
