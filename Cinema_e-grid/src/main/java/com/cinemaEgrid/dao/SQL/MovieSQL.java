package com.cinemaEgrid.dao.SQL;

/**
* 映画SQL
* @author matsuo
*
*/
public class MovieSQL {


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
			+ "ON M.genre2 = G2.genre_id";

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


	public static final String SEARCH_TITLE_MOVIE = "SELECT\r\n"
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
			+ "ON M.genre2 = G2.genre_id WHERE M.movie_title = ?";

}
