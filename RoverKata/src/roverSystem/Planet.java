package roverSystem;

import java.util.Random;

public class Planet {
	private String name;
	private char[][] planetMap;
	public Planet() {
		this.name = "Mars";
		this.planetMap = new char[64][64];
		for (int i=0;i<planetMap.length;i++) {
			for (int j=0;j<planetMap[0].length;j++) {
				if (new Random().nextInt(5)!=0) {//We put the info of obstacles on the map, with 80% of no obstacles and 20% of being a obstacles, we put and O if its free and an X if there's one
					planetMap[i][j] = 'O';
				}
				else {
					planetMap[i][j] = 'X';
				}
			}
		}
	}
	public Planet(int size) { //The same but if we want another size different than 64x64
		this.name = "Mars";
		this.planetMap = new char[size][size];
		for (int i=0;i<planetMap.length;i++) {
			for (int j=0;j<planetMap[0].length;j++) {
				if (new Random().nextInt(5)!=0) {
					planetMap[i][j] = 'O';
				}
				else {
					planetMap[i][j] = 'X';
				}
			}
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char[][] getPlanetMap() {
		return planetMap;
	}
	public void setPlanetMap(char[][] planetMap) {
		this.planetMap = planetMap;
	}
	public Planet(String name, char[][] planetMap) {
		super();
		this.name = name;
		this.planetMap = planetMap;
	}
	
}
