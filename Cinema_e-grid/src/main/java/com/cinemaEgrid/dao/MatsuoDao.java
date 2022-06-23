package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cinemaEgrid.bean.Movie;

public class MatsuoDao {
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
			//					"movie_id\tmovie_pass\tmovie_name\tgender\taddress\tbirthday");
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
		Movie movie = new Movie();

		try {
			conn = manager.getConn();
			String sql = "SELECT * FROM movie_table";
			// String sql = "SELECT E.movie_id, E.movie_pass, E.movie_name, E.gender, E.address,
			//TO_CHAR(E.birthday, 'YYYY-MM-DD') AS birthday, E.authority, D.dept_name
			//FROM movie_table E INNER JOIN dept_table D ON E.dept_id = D.dept_id ORDER BY E.movie_id";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				movie.setMovie_no(rs.getInt("movie_no"));
				movie.setMovie_title(rs.getString("movie_title"));
				movie.setGenre1(rs.getInt("genre1"));
				movie.setGenre2(rs.getInt("genre2"));
				movie.setTime(rs.getString("time"));
				movie.setAge_level(rs.getInt("age_level"));
				movie.setRelease_day(rs.getString("release_day"));
				movie.setMovie_del_flg(rs.getInt("movie_del_flg"));
				movieList.add(movie);
			}
			System.out.println(movieList);
			return movieList;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return movieList;
	}

}
