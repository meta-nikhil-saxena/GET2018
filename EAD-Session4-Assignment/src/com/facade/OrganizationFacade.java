package com.facade;

import java.util.List;

import com.dao.OrganizationDao;
import com.enums.DBType;
import com.enums.EntityName;
import com.factory.DaoFactory;
import com.models.Organization;

public class OrganizationFacade {
	public static OrganizationFacade organizationfacade = new OrganizationFacade();

	public static OrganizationFacade getInstance() {
		return organizationfacade;
	}

	OrganizationDao organizationdao = (OrganizationDao) DaoFactory
			.getDaoForEntity(EntityName.ORGANIZATION, DBType.MY_SQL);

	/**
	 * Function to return list of organization
	 * 
	 * @return list of organization
	 */
	public List<Organization> getListOfOrganization() {
		List<Organization> listOfOrganization = organizationdao.getList();
		return listOfOrganization;
	}
}
