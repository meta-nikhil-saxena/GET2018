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
import com.facade.AdvertisementFacade;
import com.google.gson.Gson;
import com.model.Advertisement;
import com.view.AdvertisementView;

@Path("/AdvertisementResource")
public class AdvertisementResource {

	AdvertisementFacade advertisementfacade = AdvertisementFacade.getInstance();

	@POST
	@Path("/insertData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Function to insert data in database table
	 * 
	 * @param id
	 * @param name
	 * @return list
	 */
	public String insertAdvertisement(Advertisement advertisement,
			@HeaderParam("Authorization") String authorizationString) {

		if (!"GET-2018".equals(authorizationString)) {
			return "error";
		}

		if (advertisementfacade.insertStatus(advertisement) == Status.CREATED) {
			return advertisement.getTitle() + " !!INSERTED!!";
		}
		return "!!DUPLICATE!!";
	}

	@GET
	@Path("/GetList")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Function to get List Of advertisements along with their Id
	 * 
	 * @return list
	 */
	public String getList(
			@HeaderParam("Authorization") String authorizationString) {

		if (!"GET-2018".equals(authorizationString)) {
			return "error";
		}

		List<Advertisement> listOfAdvertisement = advertisementfacade.getList();
		Gson gson = new Gson();
		String advertisementlist = gson.toJson(listOfAdvertisement);
		return advertisementlist;
	}

	@GET
	@Path("/GetListById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Function to get list of Advertisement by id
	 * 
	 * @param id
	 * @return list
	 */
	public String getListbyid(
			@HeaderParam("Authorization") String authorizationString,
			@PathParam("id") int id) {

		if (!"GET-2018".equals(authorizationString)) {
			return "error";
		}

		List<AdvertisementView> listOfAdvertisement = advertisementfacade
				.getListById(id);
		Gson gson = new Gson();
		String advertisementListById = gson.toJson(listOfAdvertisement);
		if (advertisementListById.length() <= 0) {
			return "!!NOT FOUND!!";
		}
		return advertisementListById;
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

		Advertisement advertisement = new Advertisement(id, name);
		if (advertisementfacade.updateStatus(advertisement) == Status.UPDATED) {
			return name + " !!UPDATED!!";
		}
		return "!!NOT UPDATED!!";
	}

	@DELETE
	@Path("delete/{category_id}")
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Function to delete category by id
	 * 
	 * @param id
	 * @return
	 */
	public String deleteById(
			@HeaderParam("Authorization") String authorizationString,
			@PathParam("category_id") int id) {

		if (!"GET-2018".equals(authorizationString)) {
			return "error";
		}

		if (advertisementfacade.deleteStatus(id) == Status.DELETED) {
			return "!!DELETED!!";
		}
		return "!!NOT DELETED!!";
	}
}
