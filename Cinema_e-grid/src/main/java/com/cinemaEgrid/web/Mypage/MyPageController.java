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
import com.cinemaEgrid.dao.ReserveLogDao;

@Controller
public class MyPageController {
	@Autowired
	HttpSession session;

	//マイページトップ表示コントローラ
	//http://localhost:10000/mypage
	@RequestMapping(value = "/mypage", method = RequestMethod.POST)
	private ModelAndView myPage(ModelAndView mav) throws SQLException {

		mav.setViewName("User/MyPage/MyPage");

		return mav;
	}

	//予約履歴表示コントローラ
	//http://localhost:10000/mypage/history
	@RequestMapping(value = "/mypage/reservelog", method = RequestMethod.GET)
	private ModelAndView reserveLog(ModelAndView mav) throws SQLException {

		String id = null;
		// (String) session.getAttribute("ユーザーセッション");

		//ユーザーごとの予約履歴取得
		ArrayList<Reserve> reserveList = ReserveLogDao.selectReserve(id);

		mav.setViewName("User/MyPage/ReserveLog");
		mav.addObject("reserveList", reserveList);
		//System.out.println("test" +  reserveList);
		return mav;
	}

	//予約キャンセルコントローラ
		//http://localhost:10000/mypage/history
		@RequestMapping(value = "/mypage/reservelog/cancel", method = RequestMethod.GET)
		private ModelAndView reserveCancel(@RequestParam("code") String code, ModelAndView mav) throws SQLException {


			Reserve reserve = ReserveLogDao.reserveCancel(code);

			String id = null;
			// (String) session.getAttribute("ユーザーセッション");

			mav.setViewName("User/Reserve/ReserveCancel");
			mav.addObject("reserveCancel", reserve);
			//System.out.println("test" +  reserveList);
			return mav;
		}


		//予約キャンセルコントローラ
				//http://localhost:10000/mypage/history
				@RequestMapping(value = "/mypage/reservelog/cancel/done", method = RequestMethod.POST)
				private ModelAndView reserveCancelDone(ModelAndView mav) throws SQLException {


					ReserveLogDao.reserveCancelDone();

					String id = null;
					// (String) session.getAttribute("ユーザーセッション");

					mav.setViewName("User/Reserve/ReserveCancelDone");

					//System.out.println("test" +  reserveList);
					return mav;
				}
}
