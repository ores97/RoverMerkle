package roverSystem;

import java.util.Random;

public class Rover {
	private int[] position; //Instead of putting two variables called x and y, I 
	private int direction; //Now you would be wondering why it's an int and not a char, but for computing values it's easier to make it with number and the code is easier to understand
	private static final char [] possibleDirections =  {'N','E','S','W'};
	private char[][] planetMap; //Information of the map that the Rover is gonna travel 
	
	public Rover(char[][]planetMap) {
		this.planetMap= planetMap;
		this.position = new int[] {new Random().nextInt(planetMap.length),new Random().nextInt(planetMap[0].length)}; //We introduce the position randomly inside the map 
		this.direction = new Random().nextInt(possibleDirections.length); // We're also going to decide randomly the direction is heading the Rover		
		System.out.print(getCharRoverDirection() + " "+ position[0] +","+ position[1]);
	}
	
	public Rover(int[] position, int direction, char[][] planetMap) {
		super();
		this.position = position;
		this.direction = direction;
		this.planetMap = planetMap;
	}
	public void doCommands(char [] commands) { //the execution of commands go through here
		int i=0;
		try {
			for (i=0; i < commands.length; i++) {
				char command = commands[i];
				switch(command) {
					case 'f':
						this.advancePosition();
						break;
					case 'b':
						this.goBackPosition();
						break;
					case 'l':
						this.turnLeft();
						break;
					case 'r':
						this.turnRight();
						break;
				}
			}
		}catch (Exception e){ //If Rover finds a obstacle while moving, he goes back to his previous place so it does nothing and reports the obstacle
			System.out.println("Obstacle found in the command:" + commands[i] + ". Rover is now safe at position " + position[0] + "," + position[1]);
		}
	}
	public void doOneCommand(char command) { //the execution of a sole command
		try {
			switch(command) {
				case 'f':
					this.advancePosition();
					break;
				case 'b':
					this.goBackPosition();
					break;
				case 'l':
					this.turnLeft();
					break;
				case 'r':
					this.turnRight();
					break;
			}
	
		}catch (Exception e){
			System.out.println("Obstacle found in the command:" + command + ". Rover is now safe at position " + position[0] + "," + position[1]);
		}
	}
	public void advancePosition() throws Exception { //We advance the position and we check for obstacles on the ground
		switch(direction) {
			case 0: //North Direction
				if (position[1]!= 0) {
					if(planetMap[position[0]][position[1]-1]=='X') {  //We check for obstacles in the way
						throw new Exception("Obstacle at("+ position[0]+"," + (position[1]-1) +")");  // if there's some obstacle, then we throw exception
					}
					else {
					position[1]--;
					}
				}
				else {
					if(planetMap[position[0]][planetMap[0].length-1]=='X') {
						throw new Exception("Obstacle at("+ position[0]+"," + (planetMap[0].length - 1) +")");
					}
					else {
					position[1] = planetMap[0].length - 1;
					}
				}
				break;
				
			case 1: //East Direction
				if (position[0]!= planetMap.length - 1) {
					if(planetMap[position[0]+1][position[1]]=='X') {
						throw new Exception("Obstacle at("+ (position[0]+1)+"," + position[1] +")");
					}
					else {
					position[0]++;
					}
				}
				else {
					if(planetMap[0][position[1]]=='X') {
						throw new Exception("Obstacle at(0,"+position[1]+")");
					}
					else {
					position[0] = 0;
					}
				}
				break;
				
			case 2: //South Direction
				if (position[1]!= planetMap[0].length - 1) {
					if(planetMap[position[0]][position[1]+1]=='X') {
						throw new Exception("Obstacle at("+ position[0]+"," + (position[1]+1) +")");
					}
					else {
						position[1]++;
					}
				}
				else {
					if(planetMap[position[0]][0]=='X') {
						throw new Exception("Obstacle at("+ position[0]+",0");
					}
					else {
					position[1] = 0;
					}
				}
				break;
				
				
			case 3: //West Direction
				if (position[0]!= 0) {
					if(planetMap[position[0]-1][position[1]]=='X') {
						throw new Exception("Obstacle at("+ (position[0]-1)+"," + position[1] +")");
					}
					else {
						position[0]--;
					}
				}
				else {
					if(planetMap[planetMap[0].length-1][position[1]]=='X') {
						throw new Exception("Obstacle at("+ (planetMap.length - 1)+"," + position[1] +")");
					}
					else{
						position[0] = planetMap.length - 1;
					}
				}
				break;
			
		}
	}
	public void goBackPosition() throws Exception { //We do the same but going backwards
		switch(direction) {
			case 0: //North Direction
				if (position[1]!= planetMap[0].length - 1) {
					if(planetMap[position[0]][position[1]+1]=='X') {
						throw new Exception("Obstacle at("+ position[0]+"," + (position[1]+1) +")"); 
					}
					else {
						position[1]++;
					}
				}
				else {
					if(planetMap[position[0]][0]=='X') {
						throw new Exception("Obstacle at("+ position[0]+",0");
					}
					else {
					position[1] = 0;
					}
				}
				break;
				
			case 1: //East Direction
				if (position[0]!= 0) {
					if(planetMap[position[0]-1][position[1]]=='X') {
						throw new Exception("Obstacle at("+ (position[0]-1)+"," + position[1] +")");
					}
					else {
						position[0]--;
					}
				}
				else {
					if(planetMap[planetMap[0].length-1][position[1]]=='X') {
						throw new Exception("Obstacle at("+ (planetMap.length - 1)+"," + position[1] +")");
					}
					else{
						position[0] = planetMap.length - 1;
					}
				}
				break;
				
			case 2: //South Direction
				if (position[1]!= 0) {
					if(planetMap[position[0]][position[1]-1]=='X') { 
						throw new Exception("Obstacle at("+ position[0]+"," + (position[1]-1) +")");
					}
					else {
					position[1]--;
					}
				}
				else {
					if(planetMap[position[0]][planetMap[0].length-1]=='X') {
						throw new Exception("Obstacle at("+ position[0]+"," + (planetMap[0].length - 1) +")");
					}
					else {
					position[1] = planetMap[0].length - 1;
					}
				}
				break;
				
				
			case 3://West Direction
				if (position[0]!= planetMap.length - 1) {
					if(planetMap[position[0]+1][position[1]]=='X') {
						throw new Exception("Obstacle at("+ (position[0]+1)+"," + position[1] +")");
					}
					else {
					position[0]++;
					}
				}
				else {
					if(planetMap[0][position[1]]=='X') {
						throw new Exception("Obstacle at(0,"+position[1]+")");
					}
					else {
					position[0] = 0;
					}
				}
				break;	
		}
	}
	public void turnRight() { //By putting the directions in int values the turning right it's only a little summation with exception controls 
		direction = (direction + 1) % 4;
	}
	
	public void turnLeft() { //Turning left is the same but also working with the values negative, so we can not use mod like the above method
		if(direction != 0) {
			direction--;
		}
		else {
			direction = 3;
		}
	}
	
	public int[] getPosition() {
		return position;
	}
	public void setPosition(int[] position) {
		this.position = position;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public char[] getPossibleDirections() {
		return possibleDirections;
	}
	public char getCharRoverDirection() {
		return possibleDirections[direction];
	}
	public char getCharDirection(int dir) {
		return possibleDirections[dir];
	}
	public char[][] getPlanetMap() {
		return planetMap;
	}
	public void setPlanetMap(char[][] planetMap) {
		this.planetMap = planetMap;
	}

}
