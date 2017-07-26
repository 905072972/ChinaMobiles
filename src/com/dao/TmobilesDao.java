package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBUtil;

public class TmobilesDao {
	DBUtil dbu = new DBUtil();

	public void piliangtianjia(String start, String end, String type) {
		Connection con = dbu.getConn();
		PreparedStatement ps=null;
		try {
			con.setAutoCommit(false);
			long startt = Long.parseLong(start);
			long endt = Long.parseLong(end);
			long count =startt;
			String sql="insert into tmobiles(mobile_number,mobile_type,card_number,status)"
				+"values(?,?,'123456789',0)";
			//0可用 1预占  2在用 3停机 4停机保号
			ps=con.prepareStatement(sql);
			for (; startt < endt; startt++) {
				ps.setLong(1, startt);
				ps.setString(2,type);
				ps.addBatch();//34464上限
				if((startt-count)%20000==0){
					ps.executeBatch();
				}
			}
			ps.executeBatch();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}
		}finally{
			try {
				ps.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
