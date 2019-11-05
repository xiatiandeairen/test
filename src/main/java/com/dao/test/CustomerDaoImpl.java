package com.dao.test;

import java.util.List;

import com.dao.domain.Customer;

public class CustomerDaoImpl extends DAO<Customer> implements CustomerDao{

	@Override
	public List<Customer> getAll() {
		String sql="select * from customer";
		return getForList(sql);
	}

	@Override
	public void save(Customer customer) {
		String sql="insert into customer values(default,?,?,?)";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone());
	}

	@Override
	public Customer get(Integer id) {
		String sql="select * from customer where id=?";
		return get(sql, id);
	}

	@Override
	public void delete(Integer id) {
		String sql="delete from customer where id=?";
		update(sql, id);
	}

	@Override
	public long getCountWithName(String name) {
		String sql="select count(id) from customer where name=?";
		return getForValue(sql, name);
	}

}
