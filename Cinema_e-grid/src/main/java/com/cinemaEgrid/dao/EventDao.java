package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.Event;
import com.cinemaEgrid.bean.EventExecutive;
import com.cinemaEgrid.dao.SQL.EventSQL;

public class EventDao {
	//全件取得メソッド
	public static ArrayList<Event> selectEvent() throws SQLException {
		ArrayList<Event> eventList = new ArrayList<Event>();

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = manager.getConn();
			String sql = EventSQL.SELECT_EVENT;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Event event = new Event();
				event.setEvent_id(rs.getInt("event_id"));
				event.setEvent_title(rs.getString("event_title"));
				event.setEvent_content(rs.getString("event_content"));
				event.setUpdate_date(rs.getString("update_date"));
				;
				eventList.add(event);
			}
			//			for (Movie i : movieList) {
			//				System.out.println(i);
			//			}

			return eventList;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return eventList;
	}

	/**
	 * イベント検索
	 * @param id
	 * @return
	 */
	public static ArrayList<EventExecutive> search(String id) {
		ArrayList<EventExecutive> userList = new ArrayList<EventExecutive>();
		boolean value = false;

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = EventSQL.SELECT_ID;
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

	/**
	 * イベント更新
	 * @param eventId
	 * @param updateTitle
	 * @param eventContent
	 * @param updateDate
	 */
	public static void update(String eventId, String updateTitle,
			String eventContent, String updateDate) {

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = EventSQL.UPDATE_ID;
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
