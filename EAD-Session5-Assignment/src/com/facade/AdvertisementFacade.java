package com.facade;

import java.util.List;

import com.dao.Advertisement;
import com.enums.DBType;
import com.enums.EntityName;
import com.enums.Status;
import com.factory.DaoFactory;
import com.view.AdvertisementView;

public class AdvertisementFacade {

	static AdvertisementFacade advertisement = new AdvertisementFacade();

	Advertisement advertisementdao = (Advertisement) DaoFactory
			.getDaoForEntity(EntityName.ADVERTISEMENT, DBType.MY_SQL);

	public static AdvertisementFacade getInstance() {
		return advertisement;
	}

	/**
	 * Function to return the insert status of the Category
	 * 
	 * @param category
	 * @return
	 */
	public Status insertStatus(com.model.Advertisement advertisement) {
		boolean status = advertisementdao.CheckAdvertisement(advertisement
				.getTitle());

		if (status) {
			return Status.DUPLICATE;
		}

		advertisementdao.insert(advertisement);
		return Status.CREATED;
	}

	/**
	 * Function to return the update status of the Category
	 * 
	 * @param category
	 * @return
	 */
	public Status updateStatus(com.model.Advertisement advertisement) {

		advertisementdao.update(advertisement);
		return Status.UPDATED;
	}

	/**
	 * Function to get the List of category
	 * 
	 * @param category
	 * @return
	 */
	public List<com.model.Advertisement> getList() {
		List<com.model.Advertisement> listOfCategory = advertisementdao
				.getlist();
		return listOfCategory;
	}

	/**
	 * Function to get list of advertisement by id
	 * 
	 * @param id
	 * @return
	 */
	public List<AdvertisementView> getListById(int id) {
		List<AdvertisementView> listOfAdvertisement = advertisementdao
				.getListById(id);

		return listOfAdvertisement;
	}

	/**
	 * Function to delete the advertisement
	 * 
	 * @param advertisement
	 * @return status
	 */
	public Status deleteStatus(int id) {

		advertisementdao.deleteById(id);
		return Status.DELETED;

	}

}
