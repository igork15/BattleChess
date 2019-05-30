package logic;

import pieces.Piece;

public class Location {
	public int x;
	public int y;
	
	public int x2;
	public int y2;
	
	public Piece piece;
	
	public int drawX;
	public int drawY;
	
	public char letterCoord;
	public int numCoord;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Location(int x, int y, int x2, int y2) {
		
		
		
		
		if(x == 75) {
			letterCoord = 'A';
			
			
		}
		if(x == 157) {
			letterCoord = 'B';
			
			
		}
		if(x == 239) {
			letterCoord = 'C';
			
			
		}
		if(x == 321) {
			letterCoord = 'D';
			
			
		}
		if(x == 403) {
			letterCoord = 'E';
			
		}
		if(x == 485) {
			letterCoord = 'F';
			
			
		}
		if(x == 567) {
			letterCoord = 'G';
			
		}
		if(x == 649) {
			letterCoord = 'H';
			
		}
		
		
		
		//================================================//
		
		if(y == 75) {
			numCoord = 8;
			
		}
		if(y == 157) {
			numCoord = 7;			
		}
		if(y == 239) {
			numCoord = 6;			
		}
		if(y == 321) {
			numCoord = 5;			
		}
		if(y == 403) {
			numCoord = 4;			
		}
		if(y == 485) {
			numCoord = 3;			
		}
		if(y == 567) {
			numCoord = 2;			
		}
		if(y == 649) {
			numCoord = 1;			
		}
		
		this.x = x;
		this.y = y;
		
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public String toString() {
		String str = "X1 = ";
		str += x;
		str += "\nY1 = ";
		str += y;
		str += "\nX2 = ";
		str += x2;
		str += "\nY2 = ";
		str += y2;
		return str;
	}
}
