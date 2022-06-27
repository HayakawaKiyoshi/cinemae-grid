package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.ScheduleExecutive;
import com.cinemaEgrid.dao.SQL.ScheduleExecutiveSQL;

public class ScheduleExecutiveDao {

	public static ArrayList<ScheduleExecutive> search(String noS, String timeS, String dateS) {
		ArrayList<ScheduleExecutive> userList = new ArrayList<ScheduleExecutive>();
		boolean value = false;

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = ScheduleExecutiveSQL.SELECT_ID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, noS);
			ps.setString(2, timeS);
			ps.setString(3, dateS);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				value = true;
				String date = rs.getString("Schedule_date");
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
			String name, String movie, String age, String content, String statusS) {

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = ScheduleExecutiveSQL.UPDATE_ID;
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
			ps.setDate(11, date);

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
