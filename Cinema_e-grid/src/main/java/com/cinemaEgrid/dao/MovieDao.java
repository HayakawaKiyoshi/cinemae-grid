package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cinemaEgrid.bean.Movie;

public class MovieDao {
	public static void main(String[] args) throws SQLException {

	}

	public static void select() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		// DBManagerのインスタンスを生成
		DBManager manager = new DBManager();
		try {
			// 接続する
			conn = manager.getConn();
			st = conn.createStatement();
			String sql = "SELECT * FROM movie_table";
			rs = st.executeQuery(sql);
			//			System.out.println(
			//					"emp_id\temp_pass\temp_name\tgender\taddress\tbirthday");
			//			while (rs.next()) {
			//				System.out.print(rs.getString("movie_title") + "\t");
			//			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Oracleエラーコード:" + e.getErrorCode());
			System.err.println("SQLStateコード:" + e.getSQLState());
			System.err.println("エラーメッセージ:" + e.getMessage());
			e.printStackTrace();
		} finally {
			// ResultSetをクローズ
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// Statementをクローズ
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
			// 切断する
			manager.close(conn);
		}
	}

	//全件取得メソッド
	public static ArrayList<Movie> selectAllmovie() throws SQLException {
		ArrayList<Movie> movieList = new ArrayList<Movie>();

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = manager.getConn();
			String sql = "SELECT\r\n"
					+ "M.movie_no,\r\n"
					+ "M.movie_title, \r\n"
					+ "G.genre_name, \r\n"
					+ "G2.genre_name,\r\n"
					+ "M.time,\r\n"
					+ "M.age_level, \r\n"
					+ "TO_CHAR(M.release_day, 'YYYY-MM-DD') AS release_day,\r\n"
					+ "M.remarks\r\n"
					+ "FROM movie_table M INNER JOIN genre_table G\r\n"
					+ "ON M.genre1 = G.genre_id INNER JOIN genre_table G2\r\n"
					+ "ON M.genre2 = G2.genre_id";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Movie emp = new Movie();
				emp.setMovie_no(rs.getInt("movie_no"));
				emp.setMovie_title(rs.getString("movie_title"));
				emp.setGenre1(rs.getInt("genre1"));
				emp.setGenre2(rs.getInt("genre2"));
				emp.setTime(rs.getString("time"));
				emp.setAge_level(rs.getInt("age_level"));
				emp.setRelease_day(rs.getString("release_day"));
				emp.setRemarks(rs.getString("remarks"));
				emp.setMovie_del_flg(rs.getInt("movie_del_flg"));
				movieList.add(emp);
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
