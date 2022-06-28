package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.EventExecutive;
import com.cinemaEgrid.dao.SQL.EventExecutiveSQL;

public class EventExecutiveDao {

	public static ArrayList<EventExecutive> search(String id) {
		ArrayList<EventExecutive> userList = new ArrayList<EventExecutive>();
		boolean value = false;

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = EventExecutiveSQL.SELECT_ID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				value = true;
				String eventId = rs.getString("Event_id");
				String title = rs.getString("Event_title");
				String content = rs.getString("Event_Content");
				String updateDate = rs.getString("Update_date");
				EventExecutive eventE = new EventExecutive(eventId, title, content, updateDate);
				userList.add(eventE);
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

	public static void update(String eventId, String updateTitle,
			String eventContent, String updateDate) {

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = EventExecutiveSQL.UPDATE_ID;
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, eventId);
			ps.setString(2, updateTitle);
			ps.setString(3, eventContent);
			ps.setString(4, updateDate);
			ps.setString(5, eventId);

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
