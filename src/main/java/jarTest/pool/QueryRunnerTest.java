package jarTest.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.JDBC.test.DBUtil;

public class QueryRunnerTest {
	public static void testInsert() {
		QueryRunner runner=new QueryRunner();
		Connection conn = DruidTest.getConnection2();
		String sql="insert into users values(default,?,?)";
		try {
			runner.update(conn, sql, "bbb","sss");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeResource(conn, null);
		}
	}
	
	public static  void testQuery() {
		QueryRunner runner=new QueryRunner();
		Connection conn = DruidTest.getConnection2();
		String sql="select * from users where id=?";
		String sql2="select * from users where id<?";
		try {
			BeanHandler<Users> bh=new BeanHandler<>(Users.class);
			MapListHandler handler=new MapListHandler();
			Users users = runner.query(conn, sql,bh,2);
			List<Map<String, Object>> list = runner.query(conn, sql2, handler,3);
			System.out.println(list);
			System.out.println(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeResource(conn, null);
		}
	}
	public static void main(String[] args) {
//		testInsert();
		testQuery();
	}

}
