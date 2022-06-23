package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cinemaEgrid.bean.Store;

/**
* 店舗情報
* @author iwai
*
*/
public class StoreDao {

	/**
	 * 一覧表示
	 * @throws SQLException
	 */
	public static ArrayList<Store> dispStore() throws SQLException {
		// DBManagerのインスタンスを生成
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		//データ格納配列変数
		ArrayList<Store> storeList = new ArrayList<Store>();

		try {
			// 接続する
			conn = manager.getConn();
			// SQL構文構築
			String sql ="SELECT * FROM store_table";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			//結果表に格納されたレコードの内容を表示
			while (rs.next()) {
				Store store = new Store();
				store.setStore_no(rs.getInt("store_no"));
				store.setStore_name(rs.getString("store_name"));
				store.setStore_location(rs.getString("store_location"));
				store.setStore_del_flg(rs.getInt("store_del_flg"));
				storeList.add(store);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("DB文字列検索操作中にエラーが発生しました。");
		} finally {
			// ResultSetをクローズ
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
			// Statementをクローズ
			if (ps != null) {
				ps.close();
			}
			// 切断処理
			manager.close(conn);
		}
			return storeList;
	}

	/**
	* 更新・削除選択のメソッド
	* @throws SQLException
	 */
	public static ArrayList<Store> findStore(int id) throws SQLException {

		// DBManagerのインスタンスを生成
		DBManager manager = new DBManager();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		//データ格納配列変数
		ArrayList<Store> storeList = new ArrayList<Store>();

		try {
			// 接続する
			conn = manager.getConn();
			// SQL構文構築
			String sql ="SELECT * FROM store_table WHERE store_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			//結果表に格納されたレコードの内容を表示
			while (rs.next()) {
				Store store = new Store();
				store.setStore_no(rs.getInt("store_no"));
				store.setStore_name(rs.getString("store_name"));
				store.setStore_location(rs.getString("store_location"));
				store.setStore_del_flg(rs.getInt("store_del_flg"));
				storeList.add(store);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("DB文字列検索操作中にエラーが発生しました。");
		} finally {
			// ResultSetをクローズ
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
			// Statementをクローズ
			if (ps != null) {
				ps.close();
			}
			// 切断処理
			manager.close(conn);
		}
		return storeList;
	}

	/**
	 * 登録のメソッド
	 * @throws SQLException
	 */
	public static void registStore(Store store) throws SQLException {

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
			String sql ="INSERT INTO store_table"
					+ " VALUES (store_seq.nextval, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, store.getStore_name());
			ps.setString(2, store.getStore_location());
			ps.setInt(3, store.getStore_del_flg());
			count = ps.executeUpdate();
			System.out.println("登録：" + count + "件");
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
	* 更新のメソッド
	* @throws SQLException
	 */
	public static void updateStore(Store store) throws SQLException {

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
			String sql ="UPDATE store_table"
					+ " SET store_name = ?, store_location = ?, store_del_flg = ?"
					+ " WHERE store_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, store.getStore_name());
			ps.setString(2, store.getStore_location());
			ps.setInt(3, store.getStore_del_flg());
			ps.setInt(4, store.getStore_no());
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
	* 削除のメソッド
	* @throws SQLException
	 */
	public static void deleteStore(int id) throws SQLException {

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
			String sql ="DELETE FROM store_table WHERE store_no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
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
