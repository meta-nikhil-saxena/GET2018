package com.factory;

import com.dao.BaseDao;
import com.dao.OrganizationDao;
import com.enums.DBType;
import com.enums.EntityName;
import com.dao.MYSQLUserDao;

public class DaoFactory {
	@SuppressWarnings("rawtypes")
	public static BaseDao getDaoForEntity(EntityName entityName, DBType dbType) {
		BaseDao basedao = null;
		switch (entityName) {
		case USER:
			switch (dbType) {
			case MY_SQL:
				basedao = MYSQLUserDao.getInstance();
			case IN_MEMORY:
				break;
			default:
				break;
			}
			break;

		case ORGANIZATION:
			switch (dbType) {
			case MY_SQL:
				basedao = OrganizationDao.getInstance();
			case IN_MEMORY:
				break;
			default:
				break;
			}
			break;

		}

		return basedao;
	}
}
