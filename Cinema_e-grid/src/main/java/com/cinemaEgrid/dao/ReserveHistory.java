package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.Reserve;
import com.cinemaEgrid.dao.SQL.ReserveHistorySQL;

/**
* 予約履歴関係
* @author matsuo
*
*/

public class ReserveHistory {

	//予約履歴取得メソッド
	public static ArrayList<Reserve> selectReserve() throws SQLException {
		ArrayList<Reserve> reserveList = new ArrayList<Reserve>();

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = manager.getConn();
			String sql = ReserveHistorySQL.RESERVE_HISTORY;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reserve reserve = new Reserve();
				reserve.setSchedule_date(rs.getString("schedule_date"));
				reserve.setUser_id(rs.getString("user_id"));
				reserve.setSchedule_no(rs.getInt("schedule_no"));
				reserve.setBook_date(rs.getString("book_date"));
				reserve.setBook_code(rs.getString("book_code"));
				reserveList.add(reserve);
			}
			//			for (Movie i : movieList) {
			//				System.out.println(i);
			//			}

			return reserveList;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return reserveList;
	}


}
