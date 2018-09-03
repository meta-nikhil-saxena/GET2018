package com.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.enums.Status;
import com.facade.CategoryFacade;
import com.google.gson.Gson;
import com.model.Category;

@Path("/CategoryResource")
public class CategoryResource {

	CategoryFacade categoryfacade = CategoryFacade.getInstance();

	@POST
	@Path("/insertData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Function to add category to database
	 * 
	 * @param name
	 * @return
	 */
	public String insertIntoCategories(
			@HeaderParam("Authorization") String authorizationString,
			Category category) {

		if (!"GET-2018".equals(authorizationString)) {
			return "error";
		}

		if (categoryfacade.insertStatus(category) == Status.CREATED) {
			return category.getName() + " !! inserted !!";
		}
		return "Duplicate Entry";
	}

	@GET
	@Path("/GetList")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Function to get list of category from database
	 * 
	 * @return
	 */
	public String getList(
			@HeaderParam("Authorization") String authorizationString) {

		if (!"GET-2018".equals(authorizationString)) {
			return "error";
		}

		List<Category> listOfCategory = categoryfacade.getList();
		Gson gson = new Gson();
		String categorylist = gson.toJson(listOfCategory);
		return categorylist;
	}

	@PUT
	@Path("/Update/{name}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Function to update data in the table 
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	public String updateCategory(
			@HeaderParam("Authorization") String authorizationString,
			@PathParam("name") String name, @PathParam("id") int id) {

		if (!"GET-2018".equals(authorizationString)) {
			return "error";
		}

		Category category = new Category(name);
		category.setId(id);

		if (categoryfacade.updateStatus(category) == Status.UPDATED) {
			return name + " !!UPDATED!!";
		}
		return "!!NOT UPDATED!!";
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Function to delete category by id
	 * 
	 * @param id
	 * @return
	 */
	public String deleteCategoryById(
			@HeaderParam("Authorization") String authorizationString,
			@PathParam("id") int id) {

		if (!"GET-2018".equals(authorizationString)) {
			return "error";
		}

		if (categoryfacade.deleteStatus(id) == Status.DELETED) {
			return "!!DELETED!!";
		}
		return "!!NOT DELETED!!";
	}
}
