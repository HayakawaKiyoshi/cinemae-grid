package com.cinemaEgrid.dao.SQL;

/**
* スケジュールSQL
*
*/
public class ScheduleSQL {

	//スケジュール全件表示
	public final static String ALLSCHEDULE =
			"SELECT TO_CHAR(schedule_date,'YYYY-MM-DD') as schedule_date, schedule_no, schedule_time, schedule_name, schedule_movie_time, schedule_age_level, schedule_content, schedule_status FROM schedule_table";

	//スケジュール選択後確認画面
	public final static String SELECTSCHEDULE =
			"SELECT TO_CHAR(schedule_date,'YYYY-MM-DD') as schedule_date, schedule_no, schedule_time, schedule_name, schedule_movie_time, schedule_age_level, schedule_content, schedule_status FROM schedule_table　WHERE schedule_date = ? AND schedule_no = ?";

	public static final String SELECT_ID =
			"SELECT "
				+ "Schedule_date, "
				+ "Schedule_no, "
				+ "Schedule_time, "
				+ "Schedule_name, "
				+ "Schedule_movie_time, "
				+ "Schedule_age_level, "
				+ "Schedule_content, "
				+ "Schedule_status "
				+ "FROM Schedule_table "
				+ "WHERE Schedule_no = ? AND Schedule_time = ? "
				+ "AND Schedule_date = ?";

	public static final String UPDATE_ID =
			"UPDATE Schedule_table SET "
				+ "Schedule_date = ?, "
				+ "Schedule_no = ?, "
				+ "Schedule_time = ?, "
				+ "Schedule_name = ?, "
				+ "Schedule_movie_time = ?, "
				+ "Schedule_age_level = ?, "
				+ "Schedule_content = ?, "
				+ "Schedule_status = ? "
				+ "WHERE Schedule_no = ? AND Schedule_time = ? "
				+ "AND Schedule_date = ?";

	public static final String UPDATE_ID1 =
			"UPDATE Schedule_table SET "
					+ "Schedule_status = ? "
					+ "WHERE Schedule_no = ? AND Schedule_time = ? "
					+ "AND Schedule_date = ?";
}
