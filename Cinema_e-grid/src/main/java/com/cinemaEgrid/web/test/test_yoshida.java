package com.cinemaEgrid.web.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.Schedule;
import com.cinemaEgrid.dao.ScheduleDao;
//yoshida テスト用コントローラ
@Controller
public class test_yoshida {
	@Autowired
	HttpSession session;
	//
	//上映予定を表示するテストコントローラ

	@RequestMapping(value = "/login/schedule", method = RequestMethod.GET)
	private ModelAndView schedule( ModelAndView mav) {
		//スケジュールの全権表示のSQL
		List<Schedule> scheduleList = new ArrayList<>();
		scheduleList = ScheduleDao.getScheduleList();
		mav.addObject("scheduleList",scheduleList);
		mav.setViewName("User/Reserve/MovieSchedule");

		return mav;
	}
	@RequestMapping(value = "/login/reserveDone", method = RequestMethod.GET)
	private ModelAndView reservedone( ModelAndView mav) {
		mav.setViewName("User/Reserve/ReserveDone");

		return mav;
	}
}
