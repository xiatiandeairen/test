package com.dao.test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.JDBC.test.DBUtil;
import com.dao.domain.Customer;

public class DAO<T> {
	public DAO(){
		System.out.println(this.getClass());
		Class<?>[] interfaces = this.getClass().getInterfaces();
		System.out.println("----------------");
		System.out.println(Arrays.toString(interfaces));
		System.out.println("-------------");
		Class<?> class1 = this.getClass().getSuperclass();
		System.out.println(class1);
		System.out.println("-----------");
		Type superclass = this.getClass().getGenericSuperclass();
		System.out.println(superclass);
		System.out.println("-------------");
		if(superclass instanceof ParameterizedType) {
			ParameterizedType pt=(ParameterizedType) superclass;
			Type[] types = pt.getActualTypeArguments();
			System.out.println(Arrays.toString(types));
		}
		System.out.println("调用了一次");
	}
	{
		System.out.println("构造块");
	}
	static {
		System.out.println("静态构造块");
	}

	private Class<T> clazz;

	/**
	 * 返回某一个字段的值
	 * @param sql:SQL语句
	 * @param args:填充SQL语句占位符
	 * @return
	 */
	public <E> E getForValue(String sql,Object...args) {
		return null;
	}

	/**
	 * 返回T所对应的list
	 * @param sql:SQL语句
	 * @param args:填充SQL语句占位符
	 * @return
	 */
	public List<T> getForList(String sql,Object...args){
		return null;
	}

	/**
	 * 返回对应T的一个实体类对象
	 * @param sql:SQL语句
	 * @param args:填充SQL语句占位符
	 * @return
	 */
	public T get(String sql,Object...args){
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			connection = DBUtil.getConnection();
			ps = connection.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				ps.setObject(i+1, args[i]);
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsma = rs.getMetaData();
			int count = rsma.getColumnCount();
			if(rs.next()) {
				T cust = clazz.newInstance();
				for(int i=0;i<count;i++) {
					Object object = rs.getObject(i+1);
					String columnLabel = rsma.getColumnLabel(i+1);
					Class clazz=Customer.class;
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(cust, object);
				}
				return cust;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeResource(connection, ps, rs);
		}
		return null;
	}

	/**
	 * 封装了insert ，delete，update操作
	 * @param sql:SQL语句
	 * @param args:填充SQL语句占位符
	 */
	public void save(String sql,Object...args) {
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<args.length;i++) {
				ps.setObject(i+1, args[i]);
			}
			int update = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeResource(conn, ps);
		}
	}
}
