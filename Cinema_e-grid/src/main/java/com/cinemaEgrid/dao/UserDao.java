package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.User;
import com.cinemaEgrid.dao.SQL.UserSQL;

public class UserDao {

	/**
	 * ログイン
	 * @param id
	 * @param pass
	 * @return
	 */
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

	/**
	 * 新規会員登録
	 * @param id
	 * @param name
	 * @param email
	 * @param pass
	 * @param auth
	 * @param del_flg
	 * @return
	 */
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

	/**
	 * 全会員表示
	 * @return
	 */
	public static ArrayList<User> findAll() {
		ArrayList<User> userList = new ArrayList<User>();

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

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
			manager.close(conn); // 切断処理
		}
		return userList;
	}

	/**
	 * 会員1名検索
	 * @param id
	 * @return
	 */
	public static ArrayList<User> search(String id) {
		ArrayList<User> userList = new ArrayList<User>();
		boolean value = false;

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = UserSQL.SELECT_ID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				value = true;
				String userId = rs.getString("User_id");
				String userMail = rs.getString("User_mail");
				String userName = rs.getString("User_name");
				String password = rs.getString("Password");
				String authority = rs.getString("Authority");
				String del_flg = rs.getString("User_del_flg");
				User userT = new User(userId, userMail, userName, password, authority, del_flg);
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
			manager.close(conn); // 切断処理
		}
		if (value) {
			return userList;
		} else {
			return null;
		}
	}

	/**
	 * プロフィール変更
	 * @param userId
	 * @param userMail
	 * @param userName
	 * @param password
	 * @param authority
	 * @param userDelFlg
	 */
	public static void update(String userId, String userMail, String userName,
			String password, String authority, String userDelFlg) {

		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = UserSQL.UPDATE_ID;
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, userId);
			ps.setString(2, userMail);
			ps.setString(3, userName);
			ps.setString(4, password);
			ps.setString(5, authority);
			ps.setString(6, userDelFlg);
			ps.setString(7, userId);

			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			System.err.println("Oracleエラーコード:" + e.getErrorCode());
			System.err.println("SQLStateコード:" + e.getSQLState());
			System.err.println("エラーメッセージ:" + e.getMessage());
			e.printStackTrace();

		} finally {
			manager.close(conn); // 切断処理
		}
	}

	/**
	 * 会員退会
	 * @param userId
	 * @param userMail
	 * @param userName
	 * @param password
	 * @param authority
	 */
	public static void delete(String userId, String userMail, String userName,
			String password, String authority) {
		Connection conn = null;
		DBManager manager = new DBManager();

		try {
			conn = manager.getConn(); // 接続する

			String sql = UserSQL.DELETE_ID;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userMail);
			ps.setString(3, userName);
			ps.setString(4, password);
			ps.setString(5, authority);
			ps.setString(6, userId);
			ps.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			System.err.println("Oracleエラーコード:" + e.getErrorCode());
			System.err.println("SQLStateコード:" + e.getSQLState());
			System.err.println("エラーメッセージ:" + e.getMessage());
			e.printStackTrace();

		} finally {
			manager.close(conn); // 切断処理
		}
	}

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
			String sql = UserSQL.FIND_ONE_STORE;
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("更新：" + id + "件");
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
		int count = 0;

		try {
			// 接続する
			conn = manager.getConn();
			// SQL構文構築
			String sql = UserSQL.UPDATE_ADMIN_USER;
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
		PreparedStatement pst = null;
		int count = 0;
		System.out.println( id + "件");
		try {
			// 接続する
			conn = manager.getConn();
			// SQL構文構築
			String sql = UserSQL.DERETE_ADMIN_RESERVE;
			ps = conn.prepareStatement(sql);
			String sqls = UserSQL.DERETE_ADMIN_USER;
			pst = conn.prepareStatement(sqls);
			ps.setString(1, id);
			pst.setString(1, id);
			ps.executeUpdate();
			count = pst.executeUpdate();
			System.out.println("削除：" + count + "件");
		} catch (Exception e) {
			System.out.println("DB文字列検索操作中にエラーが発生しました。");
		} finally {
			// 切断処理
			manager.close(conn);
		}
	}
}