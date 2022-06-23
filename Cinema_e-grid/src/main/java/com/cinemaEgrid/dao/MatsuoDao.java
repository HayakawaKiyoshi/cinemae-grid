package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
