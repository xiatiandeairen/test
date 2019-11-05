package com.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.dao.domain.Customer;

class DAOTest {
	CustomerDao dao=new CustomerDaoImpl();

	@Test
	void testDAO() {
	}

	@Test
	void testGetForValue() {
		long l = dao.getCountWithName("张三");
		System.out.println(l);
		
	}

	@Test
	void testGetForList() {
		List<Customer> all = dao.getAll();
		System.out.println(all);
	}

	@Test
	void testGet() {
		Customer customer = dao.get(1);
		System.out.println(customer);
	}

	@Test
	void testSave() {
		Customer cust=new Customer();
		cust.setAddress("shanghai");
		cust.setName("xia");
		cust.setPhone("21412");
		dao.save(cust);
	}

}
