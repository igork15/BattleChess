package visual;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import logic.Game;
import logic.Location;
import pieces.Piece;
import listeners.PieceListener;

public class ChessPanel extends JPanel implements Observer{
	private Image background;
	
	
	public ChessPanel(String fileName) throws IOException{
		background = ImageIO.read(new File(fileName));
		
		

	}

	@Override
	public void paintComponent(Graphics g) {
		
		g.drawImage(background, 0, 0, this);
		
		for(String s : Game.map.keySet()) {
			
			Piece piece = Game.map.get(s);
			
			if(piece.loc != null) {
				g.drawImage(piece.img, piece.loc.x, piece.loc.y, this);
			}
			
		}

	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

} 
