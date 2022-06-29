package com.cinemaEgrid.dao.SQL;

public class ReserveLogSQL {


	//予約履歴取得SQL
	public static final String RESERVE_LOG = " SELECT "
			+ " TO_CHAR(schedule_date, 'YYYY-MM-DD') AS scheduleDate, "
			+ " reserve_name, "
			+ " schedule_no, "
			+ " TO_CHAR(book_date, 'YYYY-MM-DD') AS bookDate, "
			+ " book_code "
			+ " FROM reserve_table WHERE user_id = ? ORDER BY book_date";


	//予約キャンセル確認情報取得SQL
	public static final String RESERVE_CANCEL = "SELECT\r\n"
			+ "TO_CHAR(schedule_date, 'YYYY-MM-DD') AS scheduleDate,\r\n"
			+ "reserve_name,\r\n"
			+ "schedule_no,\r\n"
			+ "TO_CHAR(book_date, 'YYYY-MM-DD') AS bookDate,\r\n"
			+ "book_code\r\n"
			+ "FROM reserve_table WHERE user_id = ? AND book_code = ?";


	//予約キャンセル(データ削除)SQL
	public static final String RESERVE_DELETE = "DELETE"
			+ " FROM reserve_table WHERE user_id = ? AND book_code = ?";

}