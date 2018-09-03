package com.dao;

import java.util.List;

import com.models.User;
import com.view.Friend;

//Interface for User Dao Operations
public interface UserDao extends BaseDao<User> {
	
	public boolean CheckUserByEmail(String email);
	
	public boolean CheckUserByEmailAndPassword(String email,String password);

	public List<Friend> displayFriendList(String email);
}
