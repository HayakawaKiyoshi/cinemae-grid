package com.cinemaEgrid.web.UpdateMember;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.EventExecutive;
import com.cinemaEgrid.dao.EventExecutiveDao;
import com.cinemaEgrid.form.EventForm;

/**
 * 経営者イベント更新
 * @author aishikawa
 *
 */
@Controller
@RequestMapping("/login")
public class UpdateEvent {

	//	http://localhost:10000/login/eventUpdate/0

	//イベントの番号をurlで送るように

	@RequestMapping("/eventUpdate/{type}")
	private String eventUpdate(@PathVariable int type, EventForm form) {
		if (type == 0) {
			//最初に入ってきた場合
			ArrayList<EventExecutive> eventList = EventExecutiveDao.search("1");
			form.setEventTitle(eventList.get(0).getUpdate_title());
			form.setEventContent(eventList.get(0).getEvent_content());
		}
		return "/Executive/Event/eventUpdate";
	}

	@RequestMapping(value = "/eventUpdate/check", method = RequestMethod.POST)
	private String eventUpdateCheck(EventForm form) {
		return "/Executive/Confirm/eventUpdateConfirm";
	}

	@RequestMapping(value = "/eventUpdate/done", method = RequestMethod.POST)
	private ModelAndView eventUpdateDone(EventForm form, ModelAndView mav) {
		EventExecutiveDao.update("1", form.getEventTitle(),
				form.getEventContent(), form.getUpdateDate());
		System.out.println();
		mav.addObject("title", "イベント更新完了");
		mav.addObject("msg", "イベントの更新");
		mav.addObject("uel", "#");
		mav.addObject("btn", "マイページへ");
		mav.setViewName("/Admin/Done/myUpdateDone");
		return mav;
	}

}
