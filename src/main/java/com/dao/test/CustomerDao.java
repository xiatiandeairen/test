package com.dao.test;

import java.util.List;

import com.dao.domain.Customer;

public interface CustomerDao {
	
	public List<Customer> getAll();
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
	
	public void delete(Integer id);
	
	public long getCountWithName(String name);
	
}
