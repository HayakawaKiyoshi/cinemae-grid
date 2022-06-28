package com.cinemaEgrid.web.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Schedule;
import com.cinemaEgrid.dao.ReserveDao;
import com.cinemaEgrid.dao.ScheduleDao;
import com.cinemaEgrid.web.Reserve.AlphaNumericStringGenerator;
//yoshida テスト用コントローラ
@Controller
public class ReserveController {
	@Autowired
	HttpSession session;
	//
	//上映予定を表示するテストコントローラ

	@RequestMapping(value = "/login/schedule", method = RequestMethod.GET)
	private ModelAndView schedule( ModelAndView mav) {
		//スケジュールの全権表示のSQL
		List<Schedule> scheduleList = new ArrayList<>();
		scheduleList = ScheduleDao.getScheduleList();

		//mavに登録
		mav.addObject("scheduleList",scheduleList);
		mav.setViewName("User/Reserve/MovieSchedule");

		return mav;
	}
	@RequestMapping(value = "/login/reserveDone", method = RequestMethod.GET)
	private ModelAndView reservedone(@RequestParam("date") String date,@RequestParam("no") String no, ModelAndView mav) {

		//予約されたレコードのみを抽出
		Schedule schedule = ScheduleDao.getScheduleDone(date,no);
		session.setAttribute("schedule", schedule);

		mav.addObject("schedule",schedule);
		mav.setViewName("User/Reserve/ReserveDone");

		return mav;
	}
	@RequestMapping(value = "/login/reserveResult", method = RequestMethod.GET)
	private ModelAndView reserveresult(ModelAndView mav) {

		Schedule schedule = (Schedule) session.getAttribute("schedule");
		String code = AlphaNumericStringGenerator.getRandomString(15);  //ランダムなコード発行
		String[] user = (String[]) session.getAttribute("user");		  //ユーザーのセッションを取得
		
		ReserveDao.addReserve(schedule, "1",code);
		//ReserveDao.addReserve(schedule,user[0],code);
		mav.addObject("code",code);
		mav.addObject("schedule",schedule);
		mav.setViewName("User/Reserve/ReserveResult");


		return mav;
	}
	
}
