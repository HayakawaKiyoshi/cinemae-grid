package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cinemaEgrid.bean.Schedule;
import com.cinemaEgrid.bean.ScheduleExecutive;
import com.cinemaEgrid.dao.SQL.ScheduleSQL;

//吉田
public class ScheduleDao {

	public static List<Schedule> getScheduleList() {

		List<Schedule> scheduleList = new ArrayList<>();
		DBManager manager = new DBManager();

		//データベースへ接続
		try (Connection conn = manager.getConn()) {

			//SELECT文を準備
			PreparedStatement pStmt = conn.prepareStatement(ScheduleSQL.ALLSCHEDULE);

			//SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			//結果票に格納されたレコードの内容を
			//Employeeインスタンスに設置し、ArrayListインスタンスに追加
			while (rs.next()) {
				String schedule_date = rs.getString("schedule_date");
				int schedule_no = rs.getInt("schedule_no");
				String schedule_time = rs.getString("schedule_time");
				String schedule_name = rs.getString("schedule_name");
				String schedule_movie_time = rs.getString("schedule_movie_time");
				String schedule_age_level = rs.getString("schedule_age_level");
				String schedule_content = rs.getString("schedule_content");
				int schedule_status = rs.getInt("schedule_status");
				Schedule schedule = new Schedule(schedule_date,schedule_no,schedule_time,schedule_name,schedule_movie_time, schedule_age_level, schedule_content,schedule_status);
				scheduleList.add(schedule);
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			//e.printStackTrace();
			return null;
		}
		//return empList;
		return scheduleList;
	}
	public static Schedule getScheduleDone(String date,String no) {
		Schedule schedule;
		//DBManager起動
		DBManager manager = new DBManager();
		try (Connection conn = manager.getConn()) {

			//SELECT文を準備
			PreparedStatement pStmt = conn.prepareStatement(ScheduleSQL.SELECTSCHEDULE);

			pStmt.setString(1, date);
			pStmt.setString(2, no);
			//SELECTを実行し、結果票を取得
			ResultSet rs = pStmt.executeQuery();

			//結果票に格納されたレコードの内容を
			//Employeeインスタンスに設置し、ArrayListインスタンスに追加
			rs.next();
				String schedule_date = rs.getString("schedule_date");
				int schedule_no = rs.getInt("schedule_no");
				String schedule_time = rs.getString("schedule_time");
				String schedule_name = rs.getString("schedule_name");
				String schedule_movie_time = rs.getString("schedule_movie_time");
				String schedule_age_level = rs.getString("schedule_age_level");
				String schedule_content = rs.getString("schedule_content");
				int schedule_status = rs.getInt("schedule_status");
				schedule = new Schedule(schedule_date,schedule_no,schedule_time,schedule_name,schedule_movie_time, schedule_age_level, schedule_content,schedule_status);


		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			//e.printStackTrace();
			return null;
		}
		//return empList;
		return schedule;

	}

	public static ArrayList<ScheduleExecutive> search(String noS, String timeS, String dateS) {
		ArrayList<ScheduleExecutive> userList = new ArrayList<ScheduleExecutive>();
		boolean value = false;

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = ScheduleSQL.SELECT_ID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, noS);
			ps.setString(2, timeS);
			ps.setString(3, dateS);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				value = true;
				Date date = rs.getDate("Schedule_date");
				String no = rs.getString("Schedule_no");
				String time = rs.getString("Schedule_time");
				String name = rs.getString("Schedule_name");
				String movieTime = rs.getString("Schedule_movie_time");
				String ageLevel = rs.getString("Schedule_age_level");
				String content = rs.getString("Schedule_content");
				String status = rs.getString("Schedule_status");
				ScheduleExecutive scheduleE =
						new ScheduleExecutive(date, no, time, name, movieTime, ageLevel,
								content, status);
				userList.add(scheduleE);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			System.err.println("Oracleエラーコード:" + e.getErrorCode());
			System.err.println("SQLStateコード:" + e.getSQLState());
			System.err.println("エラーメッセージ:" + e.getMessage());
			e.printStackTrace();
			return null;

		} finally {
			manager.close(conn); // 切断処理
		}
		if (value) {
			return userList;
		} else {
			return null;
		}
	}

	public static void update(Date date, String no, String time,
			String name, String movie, String age, String content, String statusS, String day) {

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = ScheduleSQL.UPDATE_ID;
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDate(1, date);
			ps.setString(2, no);
			ps.setString(3, time);
			ps.setString(4, name);
			ps.setString(5, movie);
			ps.setString(6, age);
			ps.setString(7, content);
			ps.setString(8, statusS);
			ps.setString(9, no);
			ps.setString(10, time);
			ps.setString(11, day);

			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			System.err.println("Oracleエラーコード:" + e.getErrorCode());
			System.err.println("SQLStateコード:" + e.getSQLState());
			System.err.println("エラーメッセージ:" + e.getMessage());
			e.printStackTrace();

		} finally {
			manager.close(conn); // 切断処理
		}
	}
}

