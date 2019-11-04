package jarTest.pool;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0数据库连接池
 * @author xiatao
 *
 */
public class C3p0Test {
	public static void main(String[] args) {
		Connection connection = getConnection();
		System.out.println(connection);
		Connection connection2 = getConnection2();
		System.out.println(connection2);
	}


	/**
	 * 代码获得connection对象
	 * @return
	 */
	public static Connection getConnection() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
			cpds.setJdbcUrl( "jdbc:mysql:///ssm" );
			cpds.setUser("root");                                  
			cpds.setPassword("root");
			Connection connection = cpds.getConnection();
			return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	/**
	 * xml方式获取数据库连接池
	 * @return
	 */
	public static Connection getConnection2()  {
		try {
			ComboPooledDataSource cpds = new ComboPooledDataSource("mySource");  
			Connection connection = cpds.getConnection();
			String jdbcUrl = cpds.getJdbcUrl();
			System.out.println(jdbcUrl);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
