package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBUtil {
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		try {
			conn = DriverManager.getConnection(url, "scott", "tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// insert into xx() values(?,?,?)
	public int executeUpdate(String sql, Object... parm) {
		conn = getConn();
		int result = 0;
		try {
			st = conn.prepareStatement(sql);
			if (parm != null) {
				for (int i = 0; i < parm.length; i++) {
					st.setObject(i + 1, parm[i]);
				}
			}
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ResultSet executeQuery(String sql, Object... parm) {
		conn = getConn();
		try {
			st = conn.prepareStatement(sql);
			if (parm != null) {
				for (int i = 0; i < parm.length; i++) {
					st.setObject(i + 1, parm[i]);
				}
			}
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void closeAll() {
		try {
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
