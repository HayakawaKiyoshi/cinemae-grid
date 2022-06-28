package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cinemaEgrid.bean.User;
import com.cinemaEgrid.dao.SQL.UserAdminSQL;

public class UserAdminDao {

	/**
	* 更新・削除選択のメソッド
	* @throws SQLException
	 */
	public static User findOneUser(String id) {

		// DBManagerのインスタンスを生成
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = new User();

		try {
			// 接続する
			conn = manager.getConn();
			// SQL構文構築
			String sql = UserAdminSQL.FIND_ONE_STORE;
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("選択：" + id);
			rs = ps.executeQuery();
			//結果表に格納されたレコードの内容を表示
			rs.next();

				user.setUser_id(rs.getString("user_id"));
				user.setUser_mail(rs.getString("user_mail"));
				user.setUser_name(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setAuthority(rs.getString("authority"));
				user.setUser_del_flg(rs.getString("user_del_flg"));

				return user;

		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	* 更新のメソッド
	* @throws SQLException
	 */
	public static void updateAdminUser(User user) throws SQLException {

		// DBManagerのインスタンスを生成
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			// 接続する
			conn = manager.getConn();
			// SQL構文構築
			String sql = UserAdminSQL.UPDATE_ADMIN_USER;
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser_mail());
			ps.setString(2, user.getUser_name());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getAuthority());
			ps.setString(5, user.getUser_del_flg());
			ps.setString(6, user.getUser_id());
			count = ps.executeUpdate();
			System.out.println("更新：" + count + "件");
		} catch (Exception e) {
			System.out.println("DB文字列検索操作中にエラーが発生しました。");
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
			if (ps != null) {
				ps.close();
			}
			// 切断処理
			manager.close(conn);
		}
	}

	/**
	*  削除のメソッド
	* @throws SQLException
	 */
	public static void deleteAdminUser(String id) throws SQLException {

		// DBManagerのインスタンスを生成
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			// 接続する
			conn = manager.getConn();
			// SQL構文構築
			String sql = UserAdminSQL.DERETE_ADMIN_USER;
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			count = ps.executeUpdate();
			System.out.println("削除：" + count + "件");
		} catch (Exception e) {
			System.out.println("DB文字列検索操作中にエラーが発生しました。");
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
			if (ps != null) {
				ps.close();
			}
			// 切断処理
			manager.close(conn);
		}
	}
}
