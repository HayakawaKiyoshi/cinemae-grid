package com.cinemaEgrid.dao.SQL;

public class ReserveLogSQL {


	//予約履歴取得SQL
	public static final String RESERVE_LOG = " SELECT "
			+ " TO_CHAR(schedule_date, 'YYYY-MM-DD') AS scheduleDate, "
			+ " reserve_name, "
			+ " schedule_no, "
			+ " TO_CHAR(book_date, 'YYYY-MM-DD') AS bookDate, "
			+ " book_code "
			+ " FROM reserve_table WHERE user_id = ? ";
}