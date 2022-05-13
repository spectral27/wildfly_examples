package individual.jaxrs_ejb_jpa_mysql;

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

@Path("/records")
public class RecordController {

	@EJB
	private RecordRepository recordRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectAllRecords() {
		return Response.ok(recordRepository.selectAllRecords()).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectRecord(@PathParam("id") String id) {
		return Response.ok(recordRepository.selectRecord(id)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertRecord(Record record) {
		recordRepository.insertRecord(record);
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRecord(@PathParam("id") String id, Record record) {
		return Response.ok(recordRepository.updateRecord(id, record)).build();
	}

	@DELETE
	public Response deleteRecord(@QueryParam("id") String id) {
		recordRepository.deleteControl(id);
		return Response.ok().build();
	}

}
