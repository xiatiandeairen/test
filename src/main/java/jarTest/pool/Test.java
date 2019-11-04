package jarTest.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.JDBC.test.DBUtil;
import com.JDBC.test.JDBCUtils;

public class Test {
	public static void main(String[] args) throws SQLException {
//		Connection conn = C3p0Test.getConnection2();
//		Connection conn= DbcpTest.getConnection2();
		Connection conn= DruidTest.getConnection2();
		String sql="select * from users";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+rs.getString(2)+rs.getObject(3));
		}
		DBUtil.closeResource(conn, ps, rs);
	}

}
