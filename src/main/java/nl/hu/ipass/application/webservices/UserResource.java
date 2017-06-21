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

import nl.hu.ipass.application.persistence.User;

@Path("/user")
public class UserResource {
	private MainService ms = new MainService();
	private String allUsersOutput = "";

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getUsers() {
		JsonObjectBuilder ojob = Json.createObjectBuilder();
		String output = "getUser";

		if (allUsersOutput.equals("")) {
			for (User u : ms.getAllUsers()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				
				job.add("id", u.getID()).add("role", u.getRole()).add("voornaam", u.getVoornaam())
						.add("achternaam", u.getAchternaam()).add("geboortedatum", u.getGeboortedatum())
						.add("wachtwoord", u.getWachtwoord()).add("emailadres", u.getEmailadres());
				ojob.add(Integer.toString(u.getID()), job.build());
			}
			output = ojob.build().toString();
			allUsersOutput = output;
		} else {
			output = allUsersOutput;
		}

		return Response.status(200).entity(output).build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("/new")
	public Response newUser(String data) {
		String[] allParams = data.split(",");

		User u = new User(Integer.parseInt(allParams[0]), allParams[1], allParams[2], allParams[3], allParams[4],
				allParams[5], allParams[6]);
		boolean succes = ms.newUser(u);
		System.out.println(succes);

		return Response.status(200).entity(succes).build();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("/update/{data}")
	public Response updateUser(String data) {

		String[] allParams = data.split(",");

		User u = ms.getUserByID(allParams[0]);
		u.setRole(allParams[1]);
		u.setVoornaam(allParams[2]);
		u.setAchternaam(allParams[3]);
		u.setGeboortedatum(allParams[4]);
		u.setWachtwoord(allParams[5]);
		u.setEmailadres(allParams[6]);

		boolean succes = ms.updateUser(u);
		System.out.println(succes);

		return Response.status(200).entity(succes).build();
	}

	@DELETE
	@Path("/delete/{data}")
	public Response deleteUser(@PathParam("data") String data) {
		return Response.status(200).entity(ms.removeUser(ms.getUserByID(data))).build();
	}

	@GET
	@Path("/{param}")
	public Response getUserById(@PathParam("param") int msg) {
		String output = "";

		for (User u : ms.getAllUsers()) {
			if (u.getID() == (msg)) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("id", u.getID()).add("role", u.getRole()).add("voornaam", u.getVoornaam())
						.add("achternaam", u.getAchternaam()).add("geboortedatum", u.getGeboortedatum())
						.add("wachtwoord", u.getWachtwoord()).add("emailadres", u.getEmailadres());

				output = job.build().toString();
				break;
			}
		}
		return Response.status(200).entity(output).build();
	}
}
