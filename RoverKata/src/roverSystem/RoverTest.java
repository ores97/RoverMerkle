package roverSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class RoverTest {

    @Test
    public void startingXPointOfRover() { //A test in a 10x10 planet of a Rover at 0,0 going up North to know the X position of Rover
    	Planet planetTest = new Planet(10);
    	int [] pos = {5,3};
    	Rover roverTest = new Rover(pos,0,planetTest.getPlanetMap());
    	assertEquals(roverTest.getPosition()[0],5);
    }
    @Test
    public void startingYPointOfRover() { //A test in a 10x10 planet of a Rover at 0,0 going up North to know the Y position of Rover
    	Planet planetTest = new Planet(10);
    	int [] pos = {5,3};
    	Rover roverTest = new Rover(pos,0,planetTest.getPlanetMap());
    	assertEquals(roverTest.getPosition()[1],3);
    }
    @Test
    public void startingDirectionOfRover() { //A test in a 10x10 planet of a Rover at 0,0 going up North to know the direction of Rover
    	Planet planetTest = new Planet(10);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,0,planetTest.getPlanetMap());
    	assertEquals(roverTest.getCharRoverDirection(),'N');
    }
    @Test
    public void changeDirectionRight() { //A test in a 10x10 planet of a Rover at 0,0 going up North to change to East
    	Planet planetTest = new Planet(10);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,0,planetTest.getPlanetMap());
    	roverTest.doOneCommand('r');
    	assertEquals(roverTest.getCharRoverDirection(),'E');
    }
    @Test
    public void changeDirectionLeft() { //A test in a 10x10 planet of a Rover at 0,0 going up North to change to West
    	Planet planetTest = new Planet(10);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,0,planetTest.getPlanetMap());
    	roverTest.doOneCommand('l');
    	assertEquals(roverTest.getCharRoverDirection(),'W');
    }
    
    
    
    //TESTS OF MOVING IN THE X-AXIS
    @Test
    public void moveForwardEast() { //A test in a 4x4 planet of a Rover at 0,0 going up East to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,1,planetTest.getPlanetMap());
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition()[0],1);
    }
    @Test
    public void moveBackwardEast() { //A test in a 4x4 planet of a Rover at 1,0 going up East to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {1,0};
    	Rover roverTest = new Rover(pos,1,planetTest.getPlanetMap());
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition()[0],0);
    }
    @Test
    public void moveForwardWest() { //A test in a 4x4 planet of a Rover at 1,0 going up West to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {1,0};
    	Rover roverTest = new Rover(pos,3,planetTest.getPlanetMap());
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition()[0],0);
    }
    @Test
    public void moveBackwardWest() { //A test in a 4x4 planet of a Rover at 0,0 going up West to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,3,planetTest.getPlanetMap());
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition()[0],1);
    }
    
    //TESTS OF WRAPPING WORLD IN X-AXIS
    @Test
    public void moveForwardEastWithWrapping() { //A test in a 4x4 planet of a Rover at 3,0 going up East to move successfully and going to 0,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {3,0};
    	Rover roverTest = new Rover(pos,1,planetTest.getPlanetMap());
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition()[0],0);
    }
    @Test
    public void moveForwardWestWithWrapping() { //A test in a 4x4 planet of a Rover at 0,0 going up West to move successfully and going to 3,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,3,planetTest.getPlanetMap());
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition()[0],3);
    }
    @Test
    public void moveBackwardEastWithWrapping() { //A test in a 4x4 planet of a Rover at 3,0 going up East to move successfully and going to 0,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,1,planetTest.getPlanetMap());
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition()[0],3);
    }
    @Test
    public void moveBackwardWestWithWrapping() { //A test in a 4x4 planet of a Rover at 0,0 going up West to move successfully and going to 3,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {3,0};
    	Rover roverTest = new Rover(pos,3,planetTest.getPlanetMap());
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition()[0],0);
    }
    
    //TESTS OF MOVING IN THE Y-AXIS
    @Test
    public void moveForwardNorth() { //A test in a 4x4 planet of a Rover at 0,1 going up North to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,1};
    	Rover roverTest = new Rover(pos,0,planetTest.getPlanetMap());
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition()[1],0);
    }
    @Test
    public void moveBackwardNorth() { //A test in a 4x4 planet of a Rover at 0,0 going up North to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,0,planetTest.getPlanetMap());
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition()[1],1);
    }
    @Test
    public void moveForwardSouth() { //A test in a 4x4 planet of a Rover at 0,0 going up South to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,2,planetTest.getPlanetMap());
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition()[1],1);
    }
    @Test
    public void moveBackwardSouth() { //A test in a 4x4 planet of a Rover at 0,1 going up South to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,1};
    	Rover roverTest = new Rover(pos,2,planetTest.getPlanetMap());
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition()[1],0);
    }
    
  //TESTS OF WRAPPING WORLD IN Y-AXIS
    @Test
    public void moveForwardNorthWithWrapping() { //A test in a 4x4 planet of a Rover at 0,0 going up North to move successfully and going to 0,3
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,0,planetTest.getPlanetMap());
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition()[1],3);
    }
    @Test
    public void moveForwardSouthWithWrapping() { //A test in a 4x4 planet of a Rover at 0,3 going up South to move successfully and going to 0,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,3};
    	Rover roverTest = new Rover(pos,2,planetTest.getPlanetMap());
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition()[1],0);
    }
    @Test
    public void moveBackwardNorthWithWrapping() { //A test in a 4x4 planet of a Rover at 0,3 going up North to move successfully and going to 0,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,3};
    	Rover roverTest = new Rover(pos,0,planetTest.getPlanetMap());
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition()[1],0);
    }
    @Test
    public void moveBackwardSouthWithWrapping() { //A test in a 4x4 planet of a Rover at 0,0 going up South to move successfully and going to 0,3
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,2,planetTest.getPlanetMap());
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition()[1],3);
    }
  //TESTS OF MULTIPLE COMMANDS
    @Test
    public void moveMultiplesCommands() { //A test in a 4x4 planet of a Rover at 0,0 going up West first and be given multiple commands to move successfully and going to 3,2
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	char[] commands = new char[] {'l','r','l','l','f','f','f','r','b','b'};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,3,planetTest.getPlanetMap());
    	roverTest.doCommands(commands);
    	assertEquals(roverTest.getPosition()[0],3);
    	assertEquals(roverTest.getPosition()[1],2);
    	
    }
    @Test
    public void moveMultiplesCommandsWithWrapping() { //A test in a 4x4 planet of a Rover at 0,0 going up West first and be given multiple commands to move successfully and going to 1,3
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	char[] commands = new char[] {'f','r','l','l','f','f','f','r','b','b'};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,3,planetTest.getPlanetMap());
    	roverTest.doCommands(commands);
    	assertEquals(roverTest.getPosition()[0],1);
    	assertEquals(roverTest.getPosition()[1],3);
    	
    }
  //TESTS OF OBSTACLES
    @Test
    public void singleCommandWithObstacle() { //A test in a 4x4 planet of a Rover at 0,0 going up East to move unsuccessfully and staying at 0,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','X','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,1,planetTest.getPlanetMap());
    	roverTest.doOneCommand('f');
    	System.out.print(roverTest.getPosition()[0]+","+roverTest.getPosition()[1]);
    	assertEquals(roverTest.getPosition()[1],0);
    }
    @Test
    public void multipleCommandWithObstacle() { //A test in a 4x4 planet of a Rover at 0,0 going up East to move unsuccessfully and staying at 0,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','X','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	char[] commands = new char[] {'f','r','l','l','f','f','f','r','b','b'};
    	Planet planetTest = new Planet("Mars",map);
    	int [] pos = {0,0};
    	Rover roverTest = new Rover(pos,1,planetTest.getPlanetMap());
    	roverTest.doOneCommand('f');
    	System.out.print(roverTest.getPosition()[0]+","+roverTest.getPosition()[1]);
    	assertEquals(roverTest.getPosition()[1],0);
    }
}
