package com.cinemaEgrid.web.Update.executive;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cinemaEgrid.bean.EventExecutive;
import com.cinemaEgrid.dao.EventDao;
import com.cinemaEgrid.form.EventForm;

/**
 * 経営者イベント更新
 * @author aishikawa
 *
 */
@Controller
@RequestMapping("/login")
public class UpdateEvent {

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/eventUpdate/{type}", method = RequestMethod.POST)
	private String eventUpdate(@PathVariable int type,
			@ModelAttribute("eventId") String eventId, EventForm form) {
		if (type == 0) {
			//最初に入ってきた場合
			ArrayList<EventExecutive> eventList = EventDao.search(eventId);
			session.setAttribute("eventId", eventId);
			form.setEventTitle(eventList.get(0).getUpdate_title());
			form.setEventContent(eventList.get(0).getEvent_content());
		}
		return "/Executive/Event/eventUpdate";
	}

	@RequestMapping(value = "/eventUpdate/check", method = RequestMethod.POST)
	private String eventUpdateCheck(@Validated EventForm form, BindingResult result) {
		if(result.hasErrors()) {
			//エラーチェック
			return "/Executive/Event/eventUpdate";
		}
		return "/Executive/Confirm/eventUpdateConfirm";
	}

	@RequestMapping(value = "/eventUpdate/done", method = RequestMethod.POST)
	private ModelAndView eventUpdateDone(EventForm form, ModelAndView mav) {
		EventDao.update((String) session.getAttribute("eventId"), form.getEventTitle(),
				form.getEventContent(), form.getUpdateDate());
		mav.addObject("title", "イベント更新完了");
		mav.addObject("msg", "イベントの更新");
		mav.addObject("url", "/toppage");
		mav.addObject("btn", "トップページへ");
		mav.setViewName("/Admin/Done/myUpdateDone");
		return mav;
	}

}
