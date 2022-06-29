package com.cinemaEgrid.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cinemaEgrid.bean.Schedule;
import com.cinemaEgrid.dao.SQL.ReserveSQL;

//吉田　ReserveDao
public class ReserveDao {
	//予約テーブルに予約情報を追加するテーブル
	public static void addReserve(Schedule schedule,String user_id,String code) {

			DBManager manager = new DBManager();

			 // 現在日時を取得
	        Date nowDate = new Date();

	        SimpleDateFormat sdf1
	        = new SimpleDateFormat("yyyy-MM-dd");
	        String formatNowDate = sdf1.format(nowDate);

			//データベースへ接続
			try (Connection conn = manager.getConn()) {

				//予約表にスケジュールを登録
				PreparedStatement pStmt = conn.prepareStatement(ReserveSQL.ADD_RESERVE);

				pStmt.setInt(1,schedule.getSchedule_no());
				pStmt.setString(2,schedule.getSchedule_date());
				pStmt.setString(3,schedule.getSchedule_name());
				pStmt.setString(4,user_id);
				pStmt.setString(5,formatNowDate);
				pStmt.setString(6,code);


				ResultSet rs = pStmt.executeQuery();


				rs.next();
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				//e.printStackTrace();

			}

}
	}
