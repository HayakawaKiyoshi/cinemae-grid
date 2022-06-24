package com.cinemaEgrid.dao.SQL;
//吉田
public class ScheduleSQL {

	//スケジュール全件表示
	public final static String ALLSCHEDULE ="SELECT * FROM schedule_table";

	//スケジュール選択後確認画面
	public final static String SELECTSCHEDULE = "SELECT * FROM schedule_table　WHERE schedule_date = ?,schedule_no = ?";


}
