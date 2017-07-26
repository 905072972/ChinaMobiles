package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Toperator;
import com.util.DBUtil;

public class ToperatorDao {
	DBUtil dbu = new DBUtil();

	public Toperator login(String id, String pwd) {
		String sql = "select*from Toperator where operator_id=? and operator_pwd=? ";
		ResultSet rs=dbu.executeQuery(sql, id ,pwd);
		Toperator  t=null;
		
		try {
			while (rs.next()){
				t=new  Toperator();
				t.setOperatorId(rs.getInt("operator_id"));
				t.setIsAdmin(rs.getInt("is_admin"));
				t.setOperatorName(rs.getString("operator_name"));
				t.setOperatorPwd(rs.getString("operator_pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbu.closeAll();
		}
		return t;
	}

	
}
