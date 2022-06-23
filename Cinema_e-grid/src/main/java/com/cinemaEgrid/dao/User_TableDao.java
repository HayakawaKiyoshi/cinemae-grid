package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class User_TableDao {

	public static String[] login(String id, String pass) {
		String[] user = new String[3];		//ログインしたユーザーの情報
		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn();	// 接続する

			String sql = "SELECT User_id, Authority, User_name "
							+ "FROM User_table "
							+ "WHERE User_id = ? AND Password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("User_id");
				String authority = rs.getString("Authority");
				String userName = rs.getString("User_name");
				user = new String[]{userId, authority, userName};
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
			manager.close(conn);	// 切断処理
		}
		return user;
	}

}
