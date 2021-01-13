package roverSystem;

public class Position {
	private int x;
	private int y;
	private Planet planet;
	private char[][] planetMap;
	public Position(int x, int y, Planet planet) {
		super();
		this.x = x;
		this.y = y;
		planet.getPlanetMap()[x][y] = 'R'; //We put the position of the Rover on the map
		planet.createImgMap();
		this.planet = planet;
		this.planetMap = planet.getPlanetMap();
		
	}
	public void advancePosition(int direction) throws Exception { //We advance the position and we check for obstacles on the ground
		switch(direction) {
			case 0: //North Direction
				advanceNorth();
				break;
			case 1: //East Direction
				advanceEast();
				break;	
			case 2: //South Direction
				advanceSouth();
				break;
			case 3: //West Direction
				advanceWest();
				break;
		}
	}
	public void goBackPosition(int direction) throws Exception { //We do the same but going backwards
		switch(direction) {
			case 0: //North Direction
				advanceSouth(); //Going backwards North is going forward South
				break;
			case 1: //East Direction
				advanceWest();
				break;	
			case 2: //South Direction
				advanceNorth();
				break;
			case 3: //West Direction
				advanceEast();
				break;
		}
	}
	public void advanceNorth() throws Exception {
		if (this.getY()!= 0) {
			if(planetMap[this.getX()][this.getY()-1]=='X') {  //We check for obstacles in the way
				throw new Exception("Obstacle at("+ this.getX()+"," + (this.getY()-1) +")");  // if there's some obstacle, then we throw exception
			}
			else {
				this.setY(this.getY()-1);;
			}
		}
		else {
			if(planetMap[this.getX()][planetMap[0].length-1]=='X') {
				throw new Exception("Obstacle at("+ this.getX()+"," + (planetMap[0].length - 1) +")");
			}
			else {
				this.setY(planetMap[0].length - 1);
			}
		}
	}
	public void advanceSouth() throws Exception {
		if (this.getY()!= planetMap[0].length - 1) {
			if(planetMap[this.getX()][this.getY()+1]=='X') {
				throw new Exception("Obstacle at("+ this.getX()+"," + (this.getY()+1) +")");
			}
			else {
				this.setY(this.getY()+1);
			}
		}
		else {
			if(planetMap[this.getX()][0]=='X') {
				throw new Exception("Obstacle at("+ this.getX()+",0");
			}
			else {
				this.setY(0);
			}
		}
	}
	public void advanceEast() throws Exception {
		if (this.getX()!= planetMap.length - 1) {
			if(planetMap[this.getX()+1][this.getY()]=='X') {
				throw new Exception("Obstacle at("+ (this.getX()+1)+"," + this.getY() +")");
			}
			else {
				this.setX(this.getX()+1);
			}
		}
		else {
			if(planetMap[0][this.getY()]=='X') {
				throw new Exception("Obstacle at(0,"+this.getY()+")");
			}
			else {
				this.setX(0);
			}
		}
	}
	public void advanceWest() throws Exception {
		if (this.getX()!= 0) {
			if(planetMap[this.getX()-1][this.getY()]=='X') {
				throw new Exception("Obstacle at("+ (this.getX()-1)+"," + this.getY() +")");
			}
			else {
				this.setX(this.getX()-1);
			}
		}
		else {
			if(planetMap[planetMap[0].length-1][this.getY()]=='X') {
				throw new Exception("Obstacle at("+ (planetMap.length - 1)+"," + this.getY() +")");
			}
			else{
				this.setX(planetMap.length - 1);
			}
		}
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public char[][] getPlanetMap() {
		return planetMap;
	}
	public void setPlanetMap(char[][] transposedPlanetMap) {
		this.planetMap = transposedPlanetMap;
	}
		
}
