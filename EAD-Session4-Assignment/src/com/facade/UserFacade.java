package com.facade;

import java.util.ArrayList;
import java.util.List;

import com.dao.UserDao;
import com.enums.DBType;
import com.enums.EntityName;
import com.enums.Status;
import com.factory.DaoFactory;
import com.models.User;
import com.view.Friend;

public class UserFacade {

	public static UserFacade userfacade = new UserFacade();

	// singleton object for userfacade
	public static UserFacade getInstance() {
		return userfacade;
	}

	UserDao userdao = (UserDao) DaoFactory.getDaoForEntity(EntityName.USER,
			DBType.MY_SQL);

	/**
	 * Function to return insert status in user table
	 * 
	 * @param user
	 * @return status
	 */
	public Status insertStatus(User user) {
		boolean statusofuser = userdao.CheckUserByEmail(user.getEmail());

		if (statusofuser) {
			return Status.DUPLICATE;
		}

		// Insert query from database dao
		userdao.insert(user);
		return Status.CREATED;
	}

	/**
	 * Function to return list of friends
	 * 
	 * @param email
	 * @return
	 */
	public List<Friend> getFriendList(String email) {
		List<Friend> listOfFriend = new ArrayList<Friend>();
		listOfFriend = userdao.displayFriendList(email);
		return listOfFriend;
	}

	/**
	 * Function to update in the database table
	 * 
	 * @param user
	 * @return status
	 */
	public Status updateStatus(User user) {
		userdao.update(user);
		return Status.UPDATED;
	}

	/**
	 * Function to get list of User for profile
	 * 
	 * @param email
	 * @return user
	 */
	public com.view.User getListOfUser(String email) {
		User user = userdao.getUserData(email);

		com.view.User userview = new com.view.User(user.getFirstName(),
				user.getLasttName(), user.getProfileImage(), user.getAddress(),
				user.getContact(), user.getCompany(), user.getEmail());

		return userview;
	}
}
