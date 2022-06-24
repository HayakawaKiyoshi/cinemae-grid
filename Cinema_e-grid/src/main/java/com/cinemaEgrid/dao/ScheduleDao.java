package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cinemaEgrid.bean.Schedule;
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
				Schedule schedule = new Schedule(schedule_date,schedule_no,schedule_time,schedule_name,schedule_movie_time, schedule_age_level, schedule_content);
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
				schedule = new Schedule(schedule_date,schedule_no,schedule_time,schedule_name,schedule_movie_time, schedule_age_level, schedule_content);


		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			//e.printStackTrace();
			return null;
		}
		//return empList;
		return schedule;

	}
}

