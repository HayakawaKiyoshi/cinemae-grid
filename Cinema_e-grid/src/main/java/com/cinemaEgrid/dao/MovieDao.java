package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cinemaEgrid.bean.Movie;
import com.cinemaEgrid.dao.SQL.MovieSQL;

/**
* 映画関係
* @author matsuo
* */

public class MovieDao {

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
			String sql = MovieSQL.SELECT_MOVIE;
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

	//検索取得メソッド
	public static ArrayList<Movie> searchSelectMovie(String title, String genre, String genre2) throws SQLException {
		ArrayList<Movie> movieList = new ArrayList<Movie>();

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = manager.getConn();
			String sql = MovieSQL.SEARCH_SELECT_MOVIE;
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + title + "%");
			ps.setString(2, genre);
			ps.setString(3, genre2);

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

			//System.out.println(genre);

			return movieList;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return movieList;
	}
	//yoshida 編集中

	//movieを削除するdeleteMovie
	public static void deleteMovie(int no) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//接続する
			conn = manager.getConn();
			//選択された映画noのデータを削除する
			ps = conn.prepareStatement(MovieSQL.DELETE_MOVIE);
			ps.setInt(1, no);

			System.out.println("削除:" + ps.executeUpdate()+"削除しました。");

		} catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static void updateMovie(Movie movie) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//接続する
			conn = manager.getConn();
			//選択された映画を更新する
			ps = conn.prepareStatement(MovieSQL.UPDATE_MOVIE);
			ps.setString(1, movie.getMovie_title());
			ps.setString(2,movie.getGenre_name1());
			ps.setString(3, movie.getGenre_name2());
			ps.setString(4, movie.getTime());
			ps.setInt(5, movie.getAge_level());
			ps.setString(6,movie.getRelease_day());
			ps.setString(7, movie.getRemarks());
			System.out.println("更新：" +  ps.executeUpdate() + "件");
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//変更・削除する際に選択されたデータを抽出するDao
	public static Movie selectMovie(int no) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		Movie movie = new Movie();
		try {
			//接続する
			conn = manager.getConn();
			//選択された映画を更新する
			ps = conn.prepareStatement(MovieSQL.MOVIE_SELECT);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();

			//検索されたデータをbeanへ
			rs.next();
			movie.setMovie_no(rs.getInt("movie_no"));
			movie.setMovie_title(rs.getString("movie_title"));
			movie.setGenre_name1(rs.getString("genre_name1"));
			movie.setGenre_name2(rs.getString("genre_name2"));
			movie.setTime(rs.getString("time"));
			movie.setAge_level(rs.getInt("age_level"));
			movie.setRelease_day(rs.getString("release_day"));
			movie.setRemarks(rs.getString("remarks"));
			movie.setMovie_del_flg(rs.getInt("movie_del_flg"));

			return movie;

		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
