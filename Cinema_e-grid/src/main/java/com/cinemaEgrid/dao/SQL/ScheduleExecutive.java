package com.cinemaEgrid.dao.SQL;

public class ScheduleExecutive {

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
				+ "WHERE Schedule_no = ? AND Schedule_time = ?";

	public static final String UPDATE_ID =
			"UPDATE Schedule_table SET "
				+ "Schedule_date, "
				+ "Schedule_no, "
				+ "Schedule_time, "
				+ "Schedule_name, "
				+ "Schedule_movie_time, "
				+ "Schedule_age_level, "
				+ "Schedule_content, "
				+ "Schedule_status "
				+ "WHERE Schedule_no = ? AND Schedule_time = ?";
;

}
