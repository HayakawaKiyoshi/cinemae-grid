package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.Event;
import com.cinemaEgrid.dao.SQL.EventSQL;

public class EventDao {
	//全件取得メソッド
	public static ArrayList<Event> selectAllmovie() throws SQLException {
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
				event.setEvent_id(rs.getInt("movie_no"));
				event.setEvent_title(rs.getString("movie_title"));
				event.setEvent_content(rs.getString("genre_name1"));
				event.setUpdate_date(rs.getString("genre_name2"));
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

}
