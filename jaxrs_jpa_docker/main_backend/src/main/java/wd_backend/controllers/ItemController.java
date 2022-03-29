package wd_backend.controllers;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import wd_backend.models.Item;
import wd_backend.repositories.ItemRepository;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {
	
	@EJB
	private ItemRepository itemRepository;

	@GET
	public Response selectAllItems() {
		return Response.ok(itemRepository.selectAllItems()).build();
	}
	
	@POST
	public Response insertItem(Item item) {
		itemRepository.insertItem(item);
		return Response.ok().build();
	}
	
}
