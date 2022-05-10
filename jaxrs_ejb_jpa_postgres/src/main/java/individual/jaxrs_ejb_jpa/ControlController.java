package individual.jaxrs_ejb_jpa;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/controls")
public class ControlController {
	
	@EJB
	private ControlRepository controlRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectAllItems() {
		return Response.ok(controlRepository.selectAllControls()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectControl(@PathParam("id") int id) {
		return Response.ok(controlRepository.selectControl(id)).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertControl(Control control) {
		controlRepository.insertControl(control);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateControl(@PathParam("id") int id, Control control) {
		return Response.ok(controlRepository.updateControl(id, control)).build();
	}
	
	@DELETE
	public Response deleteControl(@QueryParam("id") int id) {
		controlRepository.deleteControl(id);
		return Response.ok().build();
	}

}
