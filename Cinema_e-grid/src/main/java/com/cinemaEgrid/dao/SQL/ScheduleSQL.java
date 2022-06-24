package com.cinemaEgrid.dao.SQL;
//吉田
public class ScheduleSQL {

	//スケジュール全件表示
	public final static String ALLSCHEDULE ="SELECT TO_CHAR(schedule_date,'YYYY-MM-DD') as schedule_date, schedule_no, schedule_time, schedule_name, schedule_movie_time, schedule_age_level, schedule_content, schedule_status FROM schedule_table";

	//スケジュール選択後確認画面
	public final static String SELECTSCHEDULE = "SELECT TO_CHAR(schedule_date,'YYYY-MM-DD') as schedule_date, schedule_no, schedule_time, schedule_name, schedule_movie_time, schedule_age_level, schedule_content, schedule_status FROM schedule_table　WHERE schedule_date = ? AND schedule_no = ?";


}
