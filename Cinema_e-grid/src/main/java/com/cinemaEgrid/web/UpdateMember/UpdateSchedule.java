package com.cinemaEgrid.web.UpdateMember;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinemaEgrid.bean.EventExecutive;
import com.cinemaEgrid.dao.ScheduleExecutiveDao;
import com.cinemaEgrid.form.ScheduleForm;

@Controller
@RequestMapping("/login")
public class UpdateSchedule {

	@RequestMapping("/scheduleUpdate/{type}")
	private String eventUpdate(@PathVariable int type, ScheduleForm form) {
		if (type == 0) {
			//最初に入ってきた場合
			ArrayList<EventExecutive> eventList = ScheduleExecutiveDao.search("1");
//			form.setEventTitle(eventList.get(0).getUpdate_title());
//			form.setEventContent(eventList.get(0).getEvent_content());
		}
		return "/Executive/Event/eventUpdate";
	}

}
