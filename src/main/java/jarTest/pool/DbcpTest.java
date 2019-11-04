package jarTest.pool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * DBCP数据库连接池
 * @author xiatao
 *
 */
public class DbcpTest {
	/**
	 * 硬编码方式
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///ssm");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		Connection connection = dataSource.getConnection();
		return connection;
	}
	
	/**
	 * 使用配置文件
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection2() {
		try {
			Properties properties = new Properties();
			InputStream is=new FileInputStream("src/main/java/db.properties");
			InputStream is2 = ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties");
			properties.load(is);
			BasicDataSource dataSource=BasicDataSourceFactory.createDataSource(properties);
			Connection connection = dataSource.getConnection();
			return connection;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
