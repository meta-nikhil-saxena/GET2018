package com.dao;

import java.util.List;

import com.models.User;

//Interface to get the basic operation
public interface BaseDao<T> {

	public List<T> getList();
	
	public User getUserData(String email);

	public void insert(T t);

	public void update(T t);

	public void delete(T t);
}
