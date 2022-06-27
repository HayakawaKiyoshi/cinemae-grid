package com.cinemaEgrid.web.UpdateMember;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.ScheduleExecutive;
import com.cinemaEgrid.dao.ScheduleExecutiveDao;
import com.cinemaEgrid.form.ScheduleForm;

/**
 * 経営者 上映情報更新
 * @author aishikawa
 *
 */
@Controller
@RequestMapping("/login")
public class UpdateSchedule {

	@Autowired
	HttpSession session;

//	http://localhost:10000/login/scheduleUpdate/0
	//公開日、スケジュールナンバー、上映時間を取得すること

	@RequestMapping(value="/scheduleUpdate/{type}", method = RequestMethod.POST)
	private String scheduleUpdate(@PathVariable int type, @ModelAttribute("day") String day,
			@ModelAttribute("time") String time, @ModelAttribute("no") String no, ScheduleForm form) {
		if (type == 0) {
			//最初に入ってきた場合
			ArrayList<ScheduleExecutive> eventList = ScheduleExecutiveDao.search(no, time, day);
			form.setDate(eventList.get(0).getSchedule_date());
			form.setNo(eventList.get(0).getSchedule_no());
			form.setTime(eventList.get(0).getSchedule_time());
			form.setName(eventList.get(0).getSchedule_name());
			form.setMovieTime(eventList.get(0).getSchedule_movie_time());
			form.setAgeLevel(eventList.get(0).getSchedule_age_level());
			form.setContent(eventList.get(0).getSchedule_content());
			form.setStatusSchedule(eventList.get(0).getSchedule_status());
			String[] schedule = {day, time, no};
			session.setAttribute("schedule", schedule);
			session.setAttribute("day", eventList.get(0).getSchedule_date());
		}
		return "/Executive/Schedule/scheduleChange";
	}

	@RequestMapping(value = "/scheduleUpdate/check", method = RequestMethod.POST)
	private String scheduleUpdateCheck(@ModelAttribute ScheduleForm form) {
		return "/Executive/Confirm/scheduleUpdateConfirm";
	}

	@RequestMapping(value = "/scheduleUpdate/done", method = RequestMethod.POST)
	private ModelAndView scheduleUpdateDone(ScheduleForm form, ModelAndView mav) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date day = null;
		try {
			day = format.parse(form.getDate());
		} catch (ParseException e) {
			System.out.println("データ変換中にエラーです。");
		}
		System.out.println(day + "aaa");
		ScheduleExecutiveDao.update(new java.sql.Date(day.getTime()), form.getNo(), form.getTime(),
				 form.getName(), form.getMovieTime(), form.getAgeLevel(),
				  form.getContent(), form.getStatusSchedule(), (String) session.getAttribute("day"));
		mav.addObject("title", "上映情報更新完了");
		mav.addObject("msg", "上映情報の更新");
		mav.addObject("uel", "/cinena/mypage/top");
		mav.addObject("btn", "マイページへ");
		mav.setViewName("/Admin/Done/myUpdateDone");
		return mav;
	}
}
