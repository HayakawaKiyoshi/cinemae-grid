package com.cinemaEgrid.dao.SQL;

/**
* 映画SQL
* @author matsuo
*
*/
public class MovieSQL {

	//一覧表示
	public static final String SELECT_MOVIE =  "SELECT\r\n"
			+ "M.movie_no,\r\n"
			+ "M.movie_title, \r\n"
			+ "G.genre_name AS \"genre_name1\",\r\n"
			+ "G2.genre_name AS \"genre_name2\",\r\n"
			+ "M.time,\r\n"
			+ "M.age_level,\r\n"
			+ "TO_CHAR(M.release_day, 'YYYY-MM-DD') AS release_day,\r\n"
			+ "M.remarks,\r\n"
			+ "M.movie_del_flg\r\n"
			+ "FROM movie_table M INNER JOIN genre_table G\r\n"
			+ "ON M.genre1 = G.genre_id INNER JOIN genre_table G2\r\n"
			+ "ON M.genre2 = G2.genre_id ORDER BY M.release_day";

	//検索した映画
	public static final String SEARCH_SELECT_MOVIE = "SELECT\r\n"
			+ "M.movie_no,\r\n"
			+ "M.movie_title,\r\n"
			+ "G.genre_name AS \"genre_name1\",\r\n"
			+ "G2.genre_name AS \"genre_name2\",\r\n"
			+ "M.time,\r\n"
			+ "M.age_level,\r\n"
			+ "TO_CHAR(M.release_day, 'YYYY-MM-DD') AS release_day,\r\n"
			+ "M.remarks,\r\n"
			+ "M.movie_del_flg\r\n"
			+ "FROM movie_table M INNER JOIN genre_table G\r\n"
			+ "ON M.genre1 = G.genre_id INNER JOIN genre_table G2\r\n"
			+ "ON M.genre2 = G2.genre_id WHERE M.movie_title LIKE ? OR M.genre1 = ?"
			+ "OR M.genre2 = ?";

	//yoshida 編集中
	//映画を登録する
	public static final String SUBMIT_MOVIE= "INSERT INTO movie_table VALUES(movie_seq.nextval,?,?,?,?,?,?,?,?,0)";

	//選択した映画を削除するSQL
	public static final String DELETE_MOVIE = "UPDATE movie_table SET movie_del_flg = 1 WHERE movie_no = ?";
//			"DELETE FROM movie_table WHERE movie_no = ?";

	//選択した映画を変更するSQL
	public static final String UPDATE_MOVIE =
			"UPDATE movie_table"
			+ " SET movie_title = ?, genre1 = ?, genre2 = ?, time = ?, age_level = ?, release_day = ?, remarks = ?"
			+ " WHERE movie_no = ?";

	//削除・更新するデータを抽出する
	public static final String MOVIE_SELECT = "SELECT * FROM movie_table WHERE movie_no ?";
}
