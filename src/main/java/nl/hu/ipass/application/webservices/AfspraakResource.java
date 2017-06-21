package nl.hu.ipass.application.webservices;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.hu.ipass.application.persistence.Afspraak;

@Path("/afspraak")
public class AfspraakResource {
	private MainService ms = new MainService();
	private String allAfsprakenOutput = "";

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAfspraak() {
		JsonObjectBuilder ojob = Json.createObjectBuilder();
		String output = "getAfspraak";

		if (allAfsprakenOutput.equals("")) {
			for (Afspraak a : ms.getAllAfspraken()) {
				JsonObjectBuilder job = Json.createObjectBuilder();

				job.add("id", a.getID()).add("naam_behandeling", a.getNaam_Behandeling()).add("datum", a.getDatum())
						.add("tijd", a.getTijd()).add("lengte", a.getLengte()).add("user_id", a.getUser_ID());
				ojob.add(Integer.toString(a.getID()), job.build());
			}
			output = ojob.build().toString();
			allAfsprakenOutput = output;
		} else {
			output = allAfsprakenOutput;

		}

		return Response.status(200).entity(output).build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("/new")
	public Response newAfspraak(String data) {
		String[] allParams = data.split(",");

		Afspraak a = new Afspraak(Integer.parseInt(allParams[0]), allParams[1], allParams[2], allParams[3],
				Integer.parseInt(allParams[4]), Integer.parseInt(allParams[5]));
		boolean success = ms.newAfspraak(a);
		return Response.status(200).entity(success).build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/update/{data}")
	public Response updateAfspraak(String data) {
		String[] allParams = data.split(",");
		
		Afspraak a = ms.getAspraakByID(allParams[0]);
		a.setNaam_Behandeling(allParams[1]);
		a.setDatum(allParams[2]);
		a.setTijd(allParams[3]);
		
		boolean success = ms.updateAfspraak(a);
		System.out.println(success);
		return Response.status(200).entity(success).build();
	}
	
	@DELETE
	@Path("/delete/{data}")
	public Response deleteAfspraak(@PathParam("data") String data) {
		return Response.status(200).entity(ms.removeAfspraak(ms.getAspraakByID(data))).build();
	}
}
