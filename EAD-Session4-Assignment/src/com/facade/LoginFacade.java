package com.facade;

import com.dao.UserDao;
import com.enums.DBType;
import com.enums.EntityName;
import com.enums.Status;
import com.factory.DaoFactory;

public class LoginFacade {
	
	public static LoginFacade loginfacade = new LoginFacade();

	public static LoginFacade getInstance() {
		return loginfacade;
	}

	UserDao userdao = (UserDao) DaoFactory.getDaoForEntity(EntityName.USER,
			DBType.MY_SQL);

	/**
	 * Function to check wether the email and password exist in database
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public Status checkEmailAndPassword(String email, String password) {
		if (userdao.CheckUserByEmailAndPassword(email, password)) {
			return Status.FOUND;
		} else {
			return Status.NOT_FOUND;
		}
	}
}
