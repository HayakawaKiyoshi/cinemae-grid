package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.Movie;
import com.cinemaEgrid.dao.SQL.MovieSQL;
import com.cinemaEgrid.form.MovieForm;

/**
* 映画関係
* @author matsuo
* */

public class MovieDao {

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

		System.out.println(title);
		System.out.println(genre);
		System.out.println(genre2);

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

	//ジャンル検索取得メソッド
	public static ArrayList<Movie> searchGenreMovie(String genre, String genre2) throws SQLException {
		ArrayList<Movie> movieList = new ArrayList<Movie>();

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;

		System.out.println(genre);
		System.out.println(genre2);

		try {
			conn = manager.getConn();
			String sql = MovieSQL.SEARCH_GENRE_MOVIE;
			ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			ps.setString(2, genre2);

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

			ps.executeUpdate();

		} catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static void updateMovie(MovieForm movie , int no) {
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//接続する
			conn = manager.getConn();
			//選択された映画を更新する
			ps = conn.prepareStatement(MovieSQL.UPDATE_MOVIE);
			ps.setString(1, movie.getMovie_title());
			ps.setInt(2,movie.getGenre_1());
			ps.setInt(3, movie.getGenre_2());
			ps.setString(4, movie.getTime());
			ps.setInt(5, movie.getAge_level());
			ps.setString(6,movie.getRelease_day());
			ps.setString(7, movie.getRemarks());
			ps.setInt(8, no);
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
