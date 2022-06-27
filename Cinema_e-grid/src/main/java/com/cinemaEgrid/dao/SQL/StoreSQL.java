package com.cinemaEgrid.dao.SQL;

/**
* 店舗SQL
* @author iwai
*
*/
public class StoreSQL {

	/**
	 * 一覧表示
	 */
	public static final String SELECT_STORE =
			"SELECT * FROM store_table";

	/**
	* 更新・削除選択
	*/
	public static final String FIND_STORE =
			"SELECT * FROM store_table WHERE store_no = ?";

	/**
	 * 登録
	 */
	public static final String SUBMIT_STORE =
			"INSERT INTO store_table"
			+ " VALUES (store_seq.nextval, ?, ?, ?)";

	/**
	 * 更新
	 */
	public static final String UPDATE_STORE =
			"UPDATE store_table"
			+ " SET store_name = ?, store_location = ?, store_del_flg = 0"
			+ " WHERE store_no = ?";

	/**
	 * 削除
	 */
	public static final String DELETE_STORE =
			"UPDATE store_table "
			+ " SET store_name = ?, store_location = ?, store_del_flg = 1"
			+ " WHERE store_no = ?";
//			"DELETE FROM store_table WHERE store_no = ?";

}
