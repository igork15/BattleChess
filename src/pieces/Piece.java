package pieces;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import logic.Location;

public class Piece extends JPanel{
	public ArrayList<String> legalMoves;
	public Image img;
	public Location loc;
	public String name;
	public boolean white;
	public boolean firstMove = false;
	public int x;
	public int y;
	
	public Piece() {
		name = "Empty";
	}
	public Piece(Image img, Location loc, String name, boolean white, ArrayList<String> legalMoves) {
		x = loc.x;
		y = loc.y;
		this.legalMoves = legalMoves;
		this.img = img;
		this.loc = loc;
		
		this.name = name;
		this.white = white;
		
		
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, loc.x, loc.y, this);
	}
}
