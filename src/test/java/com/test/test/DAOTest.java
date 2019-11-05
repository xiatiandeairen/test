package com.test.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.dao.domain.Customer;
import com.dao.test.CustomerDao;
import com.dao.test.CustomerDaoImpl;
import com.dao.test.DAO;

class DAOTest {
	DAO<Customer> dao=new DAO<Customer>();
	
	
	@Test
	public void testGet() {
		String sql ="select * from customers ";
		Customer customer = dao.get(sql);
		System.out.println(customer);
	}
	
	@Test
	public void test() throws Exception {
		List<Integer> list = new ArrayList<>();
        list.add(1);
        //list.add("a"); // 这样直接添加肯定是不允许的

        //下面通过java的反射，绕过泛型  来给添加字符串
        Method add = list.getClass().getMethod("add", Object.class);
        add.invoke(list,"a");

        System.out.println(list); //[1, a] 输出没有没问题
        System.out.println(list.get(1)); //a
        
        Map<String, String> map = new HashMap<>();
        String key = "key";
        Integer val = new Integer(2); //备注：此方法在Java9后标注为过期了，建议使用valueOf，使用缓存来提高效率
        Method m = HashMap.class.getDeclaredMethod("put", new Class[]{Object.class, Object.class});
        m.invoke(map, key, val);
        System.out.println(m);
        Type returnType = m.getGenericReturnType();
        Type[] parameterTypes = m.getGenericParameterTypes();
        for(Type type:parameterTypes) {
        	System.out.println(type.getTypeName());
        	System.out.println(type.getClass());
        }
        System.out.println(returnType);

        System.out.println(map); //{key=1}
        //但是下面的输出会报错
//        System.out.println(map.get(key)); 
	}
	
	@Test
	public void testReflect() {
		new CustomerDaoImpl();
	}

}
