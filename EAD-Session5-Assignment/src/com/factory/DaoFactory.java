package com.factory;

import com.dao.BaseDao;
import com.dao.MYSQLAdvertisement;
import com.dao.MYSQLCategory;
import com.enums.DBType;
import com.enums.EntityName;

//Factory to get object of database according to Entity name and database type
public class DaoFactory {

	@SuppressWarnings("rawtypes")
	public static BaseDao getDaoForEntity(EntityName entityName, DBType dbType) {
		BaseDao basedao = null;
		switch (entityName) {
		case CATEGORY:
			switch (dbType) {
			case MY_SQL:
				basedao = MYSQLCategory.getInstance();
			case IN_MEMORY:
				break;
			default:
				break;
			}
			break;

		case ADVERTISEMENT:
			switch (dbType) {
			case MY_SQL:
				basedao = MYSQLAdvertisement.getInstance();
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
