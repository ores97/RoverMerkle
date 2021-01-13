//ORIOL RESINA SANCHO 183869
package roverSystem;

import java.awt.*;
import java.io.File;
import java.util.List;

import javax.ws.rs.core.*;
import javax.imageio.ImageIO;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
@Path("/rover")
public class RoverServices {
	 //To make commands to the Rover and get the JSON format of the direction of the Rover
	 @GET
	 @Path("/command/{command}")
	 @Produces(MediaType.APPLICATION_JSON)
		
	public String commandAndGetPosition(@PathParam("command") String command) {	
		char[] commands = command.toCharArray();
		MainRoverSystem.getRoverPrincipal().doCommands(commands);
		return MainRoverSystem.getRoverPrincipal().toString();
	}
	//To get the image of the map of Planet with the Rover on it
	@GET
	@Path("/getMap")
	@Produces("image/jpg")
	public File getMap() {	
		return MainRoverSystem.getPlanetMars().getPlanetImg();
	}
}
