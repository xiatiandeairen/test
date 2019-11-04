package com.JDBC.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	public static void releaseConnection(Connection connection) {
		
	}

	private static DataSource datasource=null;
	
	static {
		datasource=new ComboPooledDataSource();
	}
	
	/**
	 * 返回数据源的connection对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}
}
