package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.User;
import com.cinemaEgrid.dao.SQL.UserSQL;

public class UserDao {

	public static String[] login(String id, String pass) {
		String[] user = new String[3]; //ログインしたユーザーの情報
		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = UserSQL.SELECT_ID_PASS;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String userId = rs.getString("User_id");
				String authority = rs.getString("Authority");
				String userName = rs.getString("User_name");
				String uerDelFlg = rs.getString("User_del_flg");
				user = new String[] { userId, authority, userName, uerDelFlg };
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
		return user;
	}

	public static ArrayList<User> submit(String id, String name, String email, String pass,
			String auth, String del_flg) {
		ArrayList<User> empList = new ArrayList<User>();

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = UserSQL.INSERT;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, email);
			ps.setString(3, name);
			ps.setString(4, pass);
			ps.setString(5, auth);
			ps.setString(6, del_flg);

			ps.executeUpdate();

			sql = UserSQL.SELECT_ID;
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String user_id = rs.getString("User_id");
				String user_mail = rs.getString("User_mail");
				String user_name = rs.getString("User_name");
				String password = rs.getString("Password");
				String authority = rs.getString("Authority");
				String user_del_flg = rs.getString("User_del_flg");
				User userT = new User(user_id, user_mail, user_name, password, authority,
						user_del_flg);
				empList.add(userT);
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
		return empList;
	}

	public static ArrayList<User> findAll() {
		ArrayList<User> userList = new ArrayList<User>();

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn();	// 接続する

			String sql = UserSQL.SELECT_ALL;
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String user_id = rs.getString("User_id");
				String user_mail = rs.getString("User_mail");
				String user_name = rs.getString("User_name");
				String password = rs.getString("Password");
				String authority = rs.getString("Authority");
				String user_del_flg = rs.getString("User_del_flg");
				User userT = new User(user_id, user_mail, user_name,
							password, authority, user_del_flg);
				userList.add(userT);
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
		return userList;
	}


}
