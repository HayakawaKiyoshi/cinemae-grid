package com.cinemaEgrid.dao.SQL;

public class EventExecutiveSQL {

	public static final String SELECT_ID =
			"SELECT "
				+ "Event_id, "
				+ "Event_title, "
				+ "Event_content, "
				+ "Update_date "
				+ "FROM Event_table "
				+ "WHERE Event_id = ?";

	public static final String UPDATE_ID =
			"UPDATE Event_table SET "
				+ "Event_id = ?, "
				+ "Event_title = ?, "
				+ "Event_content = ?, "
				+ "Update_date = ?"
				+ "WHERE Event_id = ?";

}
