package com.dao;

public interface Category extends BaseDao<com.model.Category> {
	// Extra query required for the entity will come here
	
	public boolean CheckCategory(String name);
	
	public void deleteById(int id);
}
