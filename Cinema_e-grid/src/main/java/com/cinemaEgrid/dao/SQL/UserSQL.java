package com.cinemaEgrid.dao.SQL;

public class UserSQL {

	public static final String SELECT_ID_PASS =
			"SELECT User_id, Authority, User_name, User_del_flg  "
				+ "FROM User_table "
				+ "WHERE User_id = ? AND Password = ?";

	public static final String INSERT =
			"INSERT INTO User_table "
				+ "VALUES(?, ?, ?, ?, ?, ?)";

	public static final String SELECT_ID =
			"SELECT "
				+ "User_id, "
				+ "User_mail, "
				+ "User_name, "
				+ "Password, "
				+ "Authority, "
				+ "User_del_flg "
				+ "FROM User_table "
				+ "WHERE User_id = ?";

	public static final String SELECT_ALL =
			"SELECT "
				+ "User_id, "
				+ "User_mail, "
				+ "User_name, "
				+ "Password, "
				+ "Authority, "
				+ "User_del_flg "
				+ "FROM User_table";

	public static final String UPDATE_ID =
			"UPDATE USER_TABLE SET "
				+ "User_id = ?, "
				+ "User_mail = ?, "
				+ "User_name = ?, "
				+ "Password = ?, "
				+ "Authority = ?, "
				+ "User_del_flg = ?"
				+ "WHERE User_id = ?";

	public static final String DELETE_ID =
			"UPDATE USER_TABLE SET "
					+ "User_id = ?, "
					+ "User_mail = ?, "
					+ "User_name = ?, "
					+ "Password = ?, "
					+ "Authority = ?, "
					+ "User_del_flg = 1"
					+ "WHERE User_id = ?";

}