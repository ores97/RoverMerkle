package roverSystem;

public class Position {
	private int x;
	private int y;
	private char[][] planetMap;
	
	public Position(int x, int y, char[][] planetMap) {
		super();
		this.x = x;
		this.y = y;
		
		char[][] transposedPlanetMap = new char[planetMap.length][planetMap[0].length]; //We make for the calculations a transposed array, so the X relates to East and West and not the other way around
		for(int i = 0; i<planetMap.length;i++) {
			for(int j = 0; j<planetMap[i].length;j++) {
				transposedPlanetMap[i][j] = planetMap[j][i];
			}
		}
		this.planetMap = transposedPlanetMap;
		
	}
	public void advancePosition(int direction) throws Exception { //We advance the position and we check for obstacles on the ground
		switch(direction) {
			case 0: //North Direction
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
				break;
				
			case 1: //East Direction
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
				break;
				
			case 2: //South Direction
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
				break;
				
				
			case 3: //West Direction
				if (this.getX()!= 0) {
					if(planetMap[this.getX()-1][this.getY()]=='X') {
						throw new Exception("Obstacle at("+ (this.getX()-1)+"," + this.getY() +")");
					}
					else {
						this.setX(this.getX()-1);;
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
				break;
			
		}
	}
	public void goBackPosition(int direction) throws Exception { //We do the same but going backwards
		switch(direction) {
			case 0: //North Direction
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
				break;
				
			case 1: //East Direction
				if (this.getX()!= 0) {
					if(planetMap[this.getX()-1][this.getY()]=='X') {
						throw new Exception("Obstacle at("+ (this.getX()-1)+"," + this.getY() +")");
					}
					else {
						this.setX(this.getX()-1);;
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
				break;
				
			case 2: //South Direction
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
				break;
				
				
			case 3://West Direction
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
				break;
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
		
}
