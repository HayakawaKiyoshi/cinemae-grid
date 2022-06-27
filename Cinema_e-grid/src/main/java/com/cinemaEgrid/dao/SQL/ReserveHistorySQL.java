package com.cinemaEgrid.dao.SQL;

public class ReserveHistorySQL {


	public static final String RESERVE_HISTORY = "SELECT"
			+ "TO_CHAR(schedule_date, 'YYYY-MM-DD') AS schedule_date,"
			+ "user_id, schedule_no,"
			+ "TO_CHAR(book_date, 'YYYY-MM-DD') AS book_date,"
			+ "book_code"
			+ "FROM reserve_table";

}
