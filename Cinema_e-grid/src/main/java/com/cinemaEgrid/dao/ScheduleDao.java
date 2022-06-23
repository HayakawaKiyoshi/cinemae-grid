package com.cinemaEgrid.dao;

public class ScheduleDao {

	//public static List<Schedule> getEmployeeList() {
//
//		List<Schedule> empList = new ArrayList<>();
//		DBManager manager = new DBManager();
//
//		//データベースへ接続
//		try (Connection conn = manager.getConn()) {
//
//			//SELECT文を準備
//			PreparedStatement pStmt = conn.prepareStatement(SQL.ALLEMP);
//
//			//SELECTを実行し、結果票を取得
//			ResultSet rs = pStmt.executeQuery();
//
//			//結果票に格納されたレコードの内容を
//			//Employeeインスタンスに設置し、ArrayListインスタンスに追加
//			while (rs.next()) {
//				int emp_id = rs.getInt("emp_id");
//				String emp_name = rs.getString("emp_name");
//				String gender_name = rs.getString("gender_name");
//				String address = rs.getString("address");
//				String birthday = rs.getString("birthday");
//				String authority_name = rs.getString("authority_name");
//				String dept_name = rs.getString("dept_name");
//				Employee employee = new Employee(emp_id, emp_name, gender_name, address, birthday, authority_name,
//						dept_name);
//				empList.add(employee);
//			}
//		} catch (SQLException | ClassNotFoundException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//			return null;
//		}
//		return empList;
//	}
	}

