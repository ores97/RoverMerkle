
package roverSystem;

import java.lang.reflect.Array;
import java.util.Random;

public class MainRoverSystem {
	
	
	public static void main(String[] args){
		Planet planetMars = new Planet();
		for (int i=0;i<planetMars.getPlanetMap().length;i++) {
			for (int j=0;j<planetMars.getPlanetMap()[0].length;j++) {
				System.out.print(planetMars.getPlanetMap()[i][j]);
			}
			System.out.println("");
		}
		Rover roverPrincipal = new Rover(planetMars.getPlanetMap());
	
	}
	
}
