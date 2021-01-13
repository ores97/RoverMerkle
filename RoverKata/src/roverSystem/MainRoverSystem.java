
package roverSystem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.Random;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;
import javax.imageio.ImageIO;
public class MainRoverSystem {
	
	private static Planet planetMars;
	private static Rover roverPrincipal;
	public static void main(String[] args) throws IOException{
		
		planetMars = new Planet();
		setRoverPrincipal(new Rover(planetMars));
		createServices(); //To create the REST API services
		System.out.println(roverPrincipal.toString());
	
	}
	public static void createServices() {
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(911).build();
		ResourceConfig config = new ResourceConfig(RoverServices.class);
		HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
		System.out.println("Server started...");
	}
	public static Planet getPlanetMars() {
		return planetMars;
	}
	public static void setPlanetMars(Planet planetMars) {
		MainRoverSystem.planetMars = planetMars;
	}
	public static Rover getRoverPrincipal() {
		return roverPrincipal;
	}
	public static void setRoverPrincipal(Rover roverPrincipal) {
		MainRoverSystem.roverPrincipal = roverPrincipal;
	}
	
}
