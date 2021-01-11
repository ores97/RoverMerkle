package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import roverSystem.Planet;
import roverSystem.Position;
import roverSystem.Rover;

class PositionTest {

    //TESTS OF MOVING IN THE X-AXIS
    @Test
    public void moveForwardEast() { //A test in a 4x4 planet of a Rover at 0,0 going up East to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,1);
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition().getX(),1);
    }
    @Test
    public void moveBackwardEast() { //A test in a 4x4 planet of a Rover at 1,0 going up East to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(1,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,1);
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition().getX(),0);
    }
    @Test
    public void moveForwardWest() { //A test in a 4x4 planet of a Rover at 1,0 going up West to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(1,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,3);
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition().getX(),0);
    }
    @Test
    public void moveBackwardWest() { //A test in a 4x4 planet of a Rover at 0,0 going up West to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,3);
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition().getX(),1);
    }
    
    //TESTS OF WRAPPING WORLD IN X-AXIS
    @Test
    public void moveForwardEastWithWrapping() { //A test in a 4x4 planet of a Rover at 3,0 going up East to move successfully and going to 0,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(3,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,1);
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition().getX(),0);
    }
    @Test
    public void moveForwardWestWithWrapping() { //A test in a 4x4 planet of a Rover at 0,0 going up West to move successfully and going to 3,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,3);
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition().getX(),3);
    }
    @Test
    public void moveBackwardEastWithWrapping() { //A test in a 4x4 planet of a Rover at 3,0 going up East to move successfully and going to 0,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,1);
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition().getX(),3);
    }
    @Test
    public void moveBackwardWestWithWrapping() { //A test in a 4x4 planet of a Rover at 0,0 going up West to move successfully and going to 3,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(3,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,3);
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition().getX(),0);
    }
    
    //TESTS OF MOVING IN THE Y-AXIS
    @Test
    public void moveForwardNorth() { //A test in a 4x4 planet of a Rover at 0,1 going up North to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,1,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,0);
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition().getY(),0);
    }
    @Test
    public void moveBackwardNorth() { //A test in a 4x4 planet of a Rover at 0,0 going up North to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,0);
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition().getY(),1);
    }
    @Test
    public void moveForwardSouth() { //A test in a 4x4 planet of a Rover at 0,0 going up South to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,2);
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition().getY(),1);
    }
    @Test
    public void moveBackwardSouth() { //A test in a 4x4 planet of a Rover at 0,1 going up South to move successfully
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,1,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,2);
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition().getY(),0);
    }
    
  //TESTS OF WRAPPING WORLD IN Y-AXIS
    @Test
    public void moveForwardNorthWithWrapping() { //A test in a 4x4 planet of a Rover at 0,0 going up North to move successfully and going to 0,3
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,0);
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition().getY(),3);
    }
    @Test
    public void moveForwardSouthWithWrapping() { //A test in a 4x4 planet of a Rover at 0,3 going up South to move successfully and going to 0,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,3,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,2);
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition().getY(),0);
    }
    @Test
    public void moveBackwardNorthWithWrapping() { //A test in a 4x4 planet of a Rover at 0,3 going up North to move successfully and going to 0,0
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,3,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,0);
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition().getY(),0);
    }
    @Test
    public void moveBackwardSouthWithWrapping() { //A test in a 4x4 planet of a Rover at 0,0 going up South to move successfully and going to 0,3
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,2);
    	roverTest.doOneCommand('b');
    	assertEquals(roverTest.getPosition().getY(),3);
    }
  //TESTS OF MULTIPLE COMMANDS
    @Test
    public void moveMultiplesCommands() { //A test in a 4x4 planet of a Rover at 0,0 going up West first and be given multiple commands to move successfully and going to 3,2
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	char[] commands = new char[] {'l','r','l','l','f','f','f','r','b','b'};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,3);
    	roverTest.doCommands(commands);
    	assertEquals(roverTest.getPosition().getX(),3);
    	assertEquals(roverTest.getPosition().getY(),2);
    	
    }
    @Test
    public void moveMultiplesCommandsWithWrapping() { //A test in a 4x4 planet of a Rover at 0,0 going up West first and be given multiple commands to move successfully and going to 1,3
    	char[][] map = new char[][] {{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	char[] commands = new char[] {'f','r','l','l','f','f','f','r','b','b'};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,3);
    	roverTest.doCommands(commands);
    	assertEquals(roverTest.getPosition().getX(),1);
    	assertEquals(roverTest.getPosition().getY(),3);
    	
    }
  //TESTS OF OBSTACLES
    @Test
    public void singleCommandWithObstacle() { //A test in a 4x4 planet of a Rover at 0,0 going up East to move unsuccessfully and staying at 0,0
    	char[][] map = new char[][] {{'O','X','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,1);
    	roverTest.doOneCommand('f');
    	assertEquals(roverTest.getPosition().getX(),0);
    	assertEquals(roverTest.getPosition().getY(),0);
    }
    @Test
    public void multipleCommandWithObstacle() { //A test in a 4x4 planet of a Rover at 0,0 going up East to move unsuccessfully and staying at 0,0
    	char[][] map = new char[][] {{'O','X','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
    	char[] commands = new char[] {'r','f','l','l','f','r','b','b','b','r','r'}; //Here goes to 0,0 to 0,1 then to 0,0 then to 3,0 to 2,0, then it has a obstacle ahead and it doesnt move
    	Planet planetTest = new Planet("Mars",map);
    	Position pos = new Position(0,0,planetTest.getPlanetMap());
    	Rover roverTest = new Rover(pos,1);
    	roverTest.doCommands(commands);
    	assertEquals(roverTest.getPosition().getX(),2);
    	assertEquals(roverTest.getPosition().getY(),0);
    }
}
