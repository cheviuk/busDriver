package ua.od.driver.dispatcher;

import com.google.gson.Gson;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;

/**
 * Created by cheviuk on 2/24/2017.
 * driver
 * ua.od.driver.dispatcher
 */

@Path("/manager")
public class Manager {



    /** {"name":"Vasyan","busPosition":{"x":0.0,"y":0.0},"id":123,"routeNumber":201}*/
    @POST
    @Path("/driver")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDriver(String requestBody){

        Gson gson = new Gson();
        Driver driver = gson.fromJson(requestBody, Driver.class);
        if(Dispatcher.getDriverByID(driver.getId()) == null) {
            Dispatcher.addDriver(driver);
            return Response.status(201).entity(gson.toJson(driver)).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity("{\"message\":\"Driver with same id already exist.\"}").build();
        }
    }

    @GET
    @Path("/driver/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDriver(@PathParam("id") String id){
        Gson gson = new Gson();
        try {
            Driver driver = Dispatcher.getDriverByID(new BigInteger(id));
            return Response.status(200).entity(gson.toJson(driver)).build();
        } catch (NullPointerException npe){
            return Response.status(404).entity("{\"message\":\"NullPointerException\"}").build();
        }

    }

    @POST
    @Path("/driver/{id}/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDriver(@PathParam("id") String id, String requestBody){
        Gson gson = new Gson();
        try {
            Driver driver = Dispatcher.getDriverByID(new BigInteger(id));
            Driver newParamsDriver = gson.fromJson(requestBody, Driver.class);
            driver.setName(newParamsDriver.getName());
            driver.setId(newParamsDriver.getId());
            driver.setBusPosition(newParamsDriver.getBusPosition());
            driver.setRouteNumber(newParamsDriver.getRouteNumber());

            return Response.status(200).entity(gson.toJson(driver)).build();

        } catch (NullPointerException npe){
            return Response.status(404).entity("{\"message\":\"NullPointerException\"}").build();
        }
    }
}
