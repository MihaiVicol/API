package com.example.api;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.ws.rs.*;
import com.google.gson.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/user/")
public class HelloResource {
    @GET
    @Produces({"application/json"})
    @JsonAnyGetter
    public Response hello(@QueryParam("role") String role) {
        try {
            List<Person> person = DataStore.getInstance().getPersonRole(role);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            if (person.isEmpty()) return Response.status(Response.Status.NOT_FOUND).entity("Not found!").build();
            return Response.ok(gson.toJson(person)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    @JsonAnyGetter
    public Response getUserFromId(@PathParam("id") String id) {
        try {
            Person person = DataStore.getInstance().getPerson(id);
            if (person == null) return Response.status(Response.Status.NOT_FOUND).entity("Not found!").build();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return Response.ok(gson.toJson(person)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
        }
    }

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @JsonAnyGetter
    public Response postUser(String json) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement elem = gson.fromJson(json, JsonElement.class);
            JsonObject obj = elem.getAsJsonObject();
            Person person = new Person(obj.get("name").getAsString(), obj.get("role").getAsString());
            DataStore.getInstance().putPerson(person);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.toString()).build();
        }
    }
}

