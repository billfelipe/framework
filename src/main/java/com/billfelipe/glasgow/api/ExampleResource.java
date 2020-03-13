//package com.billfelipe.glasgow.api;
//
//import java.time.LocalDate;
//import java.util.Date;
//
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//
//import com.billfelipe.glasgow.model.Example;
//
//@Path("/example")
//public class ExampleResource {
//
//	@GET
//	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getExample(@PathParam("id") long id) {
//		Example example = new Example();
//		example.setId(id);
//		example.setDate(LocalDate.now());
//		return Response.ok(new Example()).build();
//	}
//
//	@GET
//	@Path("/date/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getExampleDate(@PathParam("id") long id) {
//		return Response.ok(new Date(System.currentTimeMillis())).build();
//	}
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getExampleByName(@QueryParam("name") String name) {
//		Example example = new Example();
//		example.setName(name);
//		example.setDate(LocalDate.now());
//		return Response.ok(new Example()).build();
//	}
//
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response createExample() {
//		return Response.ok().build();
//	}
//
//	@DELETE
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response delete() {
//		return Response.status(Status.NOT_ACCEPTABLE).build();
//	}
//
//}
