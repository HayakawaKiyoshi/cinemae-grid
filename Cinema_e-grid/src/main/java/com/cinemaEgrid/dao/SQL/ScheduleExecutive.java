package com.cinemaEgrid.dao.SQL;

public class ScheduleExecutive {

	public static final String SELECT_ID =
			"SELECT "
				+ "Shedule_date, "
				+ "Update_title, "
				+ "Event_content, "
				+ "Update_date "
				+ "FROM Event_table "
				+ "WHERE Event_id = ?";

	public static final String UPDATE_ID =
			"UPDATE Event_table SET "
				+ "Event_id = ?, "
				+ "Update_title = ?, "
				+ "Event_content = ?, "
				+ "Update_date = ?"
				+ "WHERE Event_id = ?";

}
