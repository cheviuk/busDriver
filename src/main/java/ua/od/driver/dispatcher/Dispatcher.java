package ua.od.driver.dispatcher;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by cheviuk on 2/21/2017.
 * driver
 * PACKAGE_NAME
 */

@Path(value = "/dispatcher")
public class Dispatcher {
   static private LinkedList<Driver> drivers = new LinkedList<Driver>();
   static private LinkedList<Route> routes = new LinkedList<Route>();

   public static void addDriver(Driver driver){
       drivers.add(driver);
   }

   public static Driver getDriverByID(BigInteger id){
       for(Driver driver : drivers){
           if(driver.getId().equals(id)){
               return driver;
           }
       }
       return null;
   }

    @GET
    @Path(value = "/drivers/{route:^\\d*$}")
    @Produces(MediaType.APPLICATION_JSON)
    public static ArrayList<Driver> getDriversByRouteNumber(@PathParam(value = "route")int routeNumber) {
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        for(Driver driver : drivers){
            if(driver.getRouteNumber() == routeNumber){
                drivers.add(driver);
            }
        }
        return drivers;
    }

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(){
        Driver driver = new Driver("Vasyan", new Position(0.0, 0.0), new BigInteger("123"), 201);
        Dispatcher.addDriver(driver);
        return Response.status(200).entity("{\"message\":\"добавлен тестовый водила\"}").build();
    }
}
