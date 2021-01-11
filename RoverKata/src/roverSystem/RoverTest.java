package roverSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class RoverTest {
	
    @Test
    public void startingXPointOfRover() { //A test in a 10x10 planet of a Rover at 0,0 going up North to know the X position of Rover
    	Planet planetTest = new Planet(10);
    	Position pos = new Position(5,3, planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,0);
    	assertEquals(roverTest.getPosition().getX(),5);
    }
    @Test
    public void startingYPointOfRover() { //A test in a 10x10 planet of a Rover at 0,0 going up North to know the Y position of Rover
    	Planet planetTest = new Planet(10);
    	Position pos = new Position(5,3,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,0);
    	assertEquals(roverTest.getPosition().getY(),3);
    }
    @Test
    public void startingDirectionOfRover() { //A test in a 10x10 planet of a Rover at 0,0 going up North to know the direction of Rover
    	Planet planetTest = new Planet(10);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,0);
    	assertEquals(roverTest.getCharRoverDirection(),'N');
    }
    @Test
    public void changeDirectionRight() { //A test in a 10x10 planet of a Rover at 0,0 going up North to change to East
    	Planet planetTest = new Planet(10);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,0);
    	roverTest.doOneCommand('r');
    	assertEquals(roverTest.getCharRoverDirection(),'E');
    }
    @Test
    public void changeDirectionLeft() { //A test in a 10x10 planet of a Rover at 0,0 going up North to change to West
    	Planet planetTest = new Planet(10);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,0);
    	roverTest.doOneCommand('l');
    	assertEquals(roverTest.getCharRoverDirection(),'W');
    }
    
    
  
}
