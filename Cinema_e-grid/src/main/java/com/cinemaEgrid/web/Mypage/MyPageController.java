package com.cinemaEgrid.web.Mypage;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Reserve;
import com.cinemaEgrid.dao.ReserveLogDao;

@Controller
public class MyPageController {
	@Autowired
	HttpSession session;


	//予約履歴表示画面
	//http://localhost:10000/mypage/history
	@RequestMapping(value = "/mypage/history", method = RequestMethod.GET)
	private ModelAndView login(ModelAndView mav) throws SQLException {

		ArrayList<Reserve> reserveList = ReserveLogDao.selectReserve();

		mav.setViewName("User/MyPage/ReserveLog");
		mav.addObject("reserveList", reserveList);
		//System.out.println("test" +  reserveList);
		return mav;
	}
}
