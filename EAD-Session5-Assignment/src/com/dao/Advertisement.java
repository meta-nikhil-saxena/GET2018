package com.dao;

import java.util.List;

import com.view.AdvertisementView;

public interface Advertisement extends BaseDao<com.model.Advertisement> {
	// Extra query used by this Entity should be here

	public boolean CheckAdvertisement(String name);

	public List<AdvertisementView> getListById(int category_id);

	public void deleteById(int id);
}
