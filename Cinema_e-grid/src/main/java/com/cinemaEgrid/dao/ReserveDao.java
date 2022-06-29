package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.cinemaEgrid.bean.Reserve;
import com.cinemaEgrid.bean.Schedule;
import com.cinemaEgrid.dao.SQL.ReserveSQL;

/**
* 予約履歴関係
* @author matsuo
*
*/

public class ReserveDao {

	//予約履歴取得メソッド
	public static ArrayList<Reserve> selectReserve(String id) throws SQLException {
		ArrayList<Reserve> reserveList = new ArrayList<Reserve>();

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = manager.getConn();
			String sql = ReserveSQL.RESERVE_LOG;
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			//ps.setString(1, "1");

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
	public static Reserve reserveCancel(String id, String code) throws SQLException {

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		Reserve reserve = new Reserve();

		try {
			conn = manager.getConn();
			String sql = ReserveSQL.RESERVE_CANCEL;
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			//ps.setString(1, "1");
			ps.setString(2, code);
			//ps.setString(1, "a1b2c3d4e5f6g7h");

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
	public static void reserveCancelDone(String id, String code) throws SQLException {

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = manager.getConn();
			String sql = ReserveSQL.RESERVE_DELETE;
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, code);

			int count = ps.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	//予約テーブルに予約情報を追加するテーブル
	public static void addReserve(Schedule schedule, String user_id, String code) {

		DBManager manager = new DBManager();

		// 現在日時を取得
		Date nowDate = new Date();

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String formatNowDate = sdf1.format(nowDate);

		//データベースへ接続
		try (Connection conn = manager.getConn()) {

			//予約表にスケジュールを登録
			PreparedStatement pStmt = conn.prepareStatement(ReserveSQL.ADD_RESERVE);

			pStmt.setInt(1, schedule.getSchedule_no());
			pStmt.setString(2, schedule.getSchedule_date());
			pStmt.setString(3, schedule.getSchedule_name());
			pStmt.setString(4, user_id);
			pStmt.setString(5, formatNowDate);
			pStmt.setString(6, code);

			ResultSet rs = pStmt.executeQuery();

			rs.next();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			//e.printStackTrace();

		}
	}

}
