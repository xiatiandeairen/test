package jarTest.pool;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 德鲁伊获取数据库连接池
 * @author xiatao
 *
 */
public class DruidTest {
	/**
	 * 硬编码方式
	 * @return
	 */
	public static Connection getConnection() {
		DruidDataSource source=new DruidDataSource();
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql:///ssm");
		source.setUsername("root");
		source.setPassword("root");
		Connection connection=null;
		try {
			connection = source.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 配置文件方式
	 * @return
	 */
	public static Connection getConnection2() {
		Connection connection=null;
		try {
			Properties properties = new Properties();
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties");
			properties.load(is);
			DruidDataSource source=(DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
			connection = source.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

}
