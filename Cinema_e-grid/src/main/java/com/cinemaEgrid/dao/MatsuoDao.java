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
			System.out.println(
					"emp_id\temp_pass\temp_name\tgender\taddress\tbirthday");
			while (rs.next()) {
				System.out.print(rs.getString("movie_title") + "\t");
			}
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
	public static ArrayList<Movie> selectAll() throws SQLException {
		ArrayList<Movie> movieList = new ArrayList<Movie>();

		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = manager.getConn();
			String sql = "SELECT emp_id, emp_pass, emp_name, gender, address, \r\n"
					+ "TO_CHAR(birthday, 'YYYY-MM-DD') AS birthday, authority, dept_id\r\n"
					+ "FROM emp_table ORDER BY emp_id";
			// String sql = "SELECT E.emp_id, E.emp_pass, E.emp_name, E.gender, E.address,
			//TO_CHAR(E.birthday, 'YYYY-MM-DD') AS birthday, E.authority, D.dept_name
			//FROM emp_table E INNER JOIN dept_table D ON E.dept_id = D.dept_id ORDER BY E.emp_id";
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
				emp.setMovie_del_flg(rs.getInt("movie_del_flg"));
				movieList.add(emp);
			}

			return movieList;

		} catch (SQLException | ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return movieList;
	}

}
