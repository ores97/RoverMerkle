package roverSystem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Planet {
	private String name;
	private char[][] planetMap;
	private File planetImg;
	public Planet(){
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
		createImgMap();
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
		createImgMap();
	}
	public void createImgMap()  {
		BufferedImage img = new BufferedImage(planetMap.length*30,planetMap[0].length*30,BufferedImage.TYPE_INT_RGB);
		for(int r=0; r<planetMap.length; r++) {
			 for(int c=0; c<planetMap[0].length; c++)
			    {
				 	int rgb;
				 	if(getPlanetMap()[r][c]=='X') {
			        	rgb = 13112340; //red color for obstacle
			        }
				 	else if (getPlanetMap()[r][c]=='R'){
				 		rgb = 8421504; //grey color for the Rover
				 	}else {
				 		rgb = 16032864; //mars floor color for obstacle
				 	}
				 	int inicC = c*30; //I multiplied every array x 30 to have a big image of 1920x1920 (in a 64x64 map)
				 	int inicR = r*30;
				 	int finC = ((c+1) * 30)-1;
				 	int finR = ((r+1)*30 - 1);
				 	for(int i=inicR;i<finR;i++) {
				 		for(int j=inicC;j<finC;j++) {
				 			img.setRGB(i, j, rgb);
				 		}
				 	}
			        
			    }
		}
		try {
			planetImg = new File("planetMap.jpg");
			ImageIO.write(img,"jpg", planetImg); //Then, easily we put the info in a map
		} catch (IOException e) {
			e.printStackTrace();
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
		createImgMap();
	}
	public File getPlanetImg() {
		return planetImg;
	}
	public void setPlanetImg(File planetImg) {
		this.planetImg = planetImg;
	}
	
}
