package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.Movie;
import com.cinemaEgrid.dao.SQL.ReserveHistorySQL;

/**
* 予約履歴関係
* @author matsuo
*
*/

public class ReserveHistory {

	//予約履歴取得メソッド
	public static ArrayList<Movie> selectAllmovie() throws SQLException {
		ArrayList<Movie> movieList = new ArrayList<Movie>();

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = manager.getConn();
			String sql = ReserveHistorySQL.RESERVE_HISTORY;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovie_no(rs.getInt("movie_no"));
				movie.setMovie_title(rs.getString("movie_title"));
				movie.setGenre_name1(rs.getString("genre_name1"));
				movie.setGenre_name2(rs.getString("genre_name2"));
				movie.setTime(rs.getString("time"));
				movie.setAge_level(rs.getInt("age_level"));
				movie.setRelease_day(rs.getString("release_day"));
				movie.setRemarks(rs.getString("remarks"));
				movie.setMovie_del_flg(rs.getInt("movie_del_flg"));
				movieList.add(movie);
			}
			//			for (Movie i : movieList) {
			//				System.out.println(i);
			//			}

			return movieList;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return movieList;
	}


}
