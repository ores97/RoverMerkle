package roverSystem;

import java.util.Random;

public class Rover {
	private Position position; //Instead of putting two variables called x and y, I 
	private int direction; //Now you would be wondering why it's an int and not a char, but for computing values it's easier to make it with number and the code is easier to understand
	private static final char [] possibleDirections =  {'N','E','S','W'};
	
	public Rover(Planet planetMars) {
		this.position = new Position(new Random().nextInt(planetMars.getPlanetMap().length),new Random().nextInt(planetMars.getPlanetMap()[0].length),planetMars); //We introduce the position randomly inside the map 
		this.direction = new Random().nextInt(possibleDirections.length); // We're also going to decide randomly the direction is heading the Rover	
	}
	public Rover(Position position, int direction) {
		super();
		this.position = position;
		this.direction = direction;
	}
	public void doCommands(char [] commands) { //the execution of commands go through here
		int i=0;
		try {
			position.getPlanet().getPlanetMap()[position.getX()][position.getY()] = 'O'; //Where the Rover was we put an O in the map
			for (i=0; i < commands.length; i++) {
				char command = commands[i];
				switch(command) {
					case 'f':
						position.advancePosition(direction);
						break;
					case 'b':
						position.goBackPosition(direction);
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
			System.out.println("Obstacle found in the command: " + commands[i] + ". Rover is now safe at position " + position.getX() + "," + position.getY() );
		}finally {
			position.getPlanet().getPlanetMap()[position.getX()][position.getY()] = 'R'; //We always put the Rover position in the map, even if it doesnt move for obstacles or turns
			position.getPlanet().createImgMap(); //We create the map again
		}
	}
	public void doOneCommand(char command) { //the execution of a sole command
		try {
			position.getPlanet().getPlanetMap()[position.getX()][position.getY()] = 'O'; //Where the Rover was we put an O in the map
			switch(command) {
				case 'f':
					position.advancePosition(direction);
					break;
				case 'b':
					position.goBackPosition(direction);
					break;
				case 'l':
					this.turnLeft();
					break;
				case 'r':
					this.turnRight();
					break;
			}
	
		}catch (Exception e){
			System.out.println("Obstacle found in the command: " + command + ". Rover is now safe at position "  +position.getX() + "," + position.getY());
		}finally {
			position.getPlanet().getPlanetMap()[position.getX()][position.getY()] = 'R';
			position.getPlanet().createImgMap();
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
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
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
	
	@Override
	public String toString() {
		return "Rover at: " + position.toString() + " Direction: " + possibleDirections[direction] + "]";
	}

}
