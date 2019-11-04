package com.mvcapp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.JDBC.test.JDBCUtils;

class JDBCUtilsTest {

	@Test
	void testGetConnection() throws SQLException {
		Connection connection=JDBCUtils.getConnection();
		System.out.println(connection);
	}

}
