package com.cinemaEgrid.dao.SQL;

public class UserAdminSQL {

	/**
	* 更新・削除選択
	*/
	public static final String FIND_ONE_STORE =
			"SELECT * FROM user_table WHERE user_id = ?";

	/**
	 * 更新
	 */
	public static final String UPDATE_ADMIN_USER =
			"UPDATE user_table"
			+ " SET user_mail = ?, user_name = ?, password = ?, authority = ?, user_del_flg = ?"
			+ " WHERE user_id = ?";

	/**
	 * 削除
	 */
	public static final String DERETE_ADMIN_USER =
			"DELETE FROM user_table WHERE user_id = ?";


}
