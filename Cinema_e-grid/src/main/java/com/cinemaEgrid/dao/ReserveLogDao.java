package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.Reserve;
import com.cinemaEgrid.dao.SQL.ReserveLogSQL;

/**
* 予約履歴関係
* @author matsuo
*
*/

public class ReserveLogDao {

	//予約履歴取得メソッド
	public static ArrayList<Reserve> selectReserve(String id) throws SQLException {
		ArrayList<Reserve> reserveList = new ArrayList<Reserve>();

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = manager.getConn();
			String sql = ReserveLogSQL.RESERVE_LOG;
			ps = conn.prepareStatement(sql);
			//ps.setString(1, id);
			ps.setString(1, "1");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Reserve reserve = new Reserve();
				reserve.setSchedule_date(rs.getString("scheduleDate"));
				reserve.setReserve_name(rs.getString("reserve_name"));
				reserve.setSchedule_no(rs.getInt("schedule_no"));
				reserve.setBook_date(rs.getString("bookDate"));
				reserve.setBook_code(rs.getString("book_code"));
				reserveList.add(reserve);
			}

			return reserveList;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return reserveList;
	}

	//予約履歴取得メソッド(キャンセル)
	public static Reserve reserveCancel(String code) throws SQLException {

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		Reserve reserve = new Reserve();

		try {
			conn = manager.getConn();
			String sql = ReserveLogSQL.RESERVE_CANCEL;
			ps = conn.prepareStatement(sql);
			//ps.setString(1, id);
			//ps.setString(1, "1");
			//ps.setString(2, code);
			ps.setString(1, "a1b2c3d4e5f6g7h");

			ResultSet rs = ps.executeQuery();

			rs.next();
				reserve.setSchedule_date(rs.getString("scheduleDate"));
				reserve.setReserve_name(rs.getString("reserve_name"));
				reserve.setSchedule_no(rs.getInt("schedule_no"));
				reserve.setBook_date(rs.getString("bookDate"));
				reserve.setBook_code(rs.getString("book_code"));


			return reserve;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return reserve;
	}



	//予約削除メソッド
	public static void reserveCancelDone() throws SQLException {

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		Reserve reserve = new Reserve();

		try {
			conn = manager.getConn();
			String sql = ReserveLogSQL.RESERVE_DELETE;
			ps = conn.prepareStatement(sql);
			ps.setString(1, "a1b2c3d4e5f6g7h");

			int count = ps.executeUpdate();


		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
