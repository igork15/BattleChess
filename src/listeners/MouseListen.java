package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Observable;

import logic.Game;
import logic.Location;
import visual.ChessPanel;

import javax.swing.JPanel;

public class MouseListen extends Observable implements MouseListener, MouseMotionListener{
	public int x;
	public int y;
	public int translateX = 60;
	public int translateY = 135;
	
	public boolean change = true;
	int square;
	
	public MouseListen(Game game, ChessPanel panel) {
		
		addObserver(game);
		addObserver(panel);
		x = 0;
		y = 0;
		square = -1;
		
	}
	@Override
	public void mouseClicked(MouseEvent click) {
		x = click.getX();
		y = click.getY();
		
		

		for(int i = 0; i < Game.locations.length; i++) {
			
			if(x > Game.locations[i].x && x < Game.locations[i].x2) {
				if(y > Game.locations[i].y && y < Game.locations[i].y2) {
					//System.out.println(Game.locations[i].piece.name);
					
					if(Game.from == null) {
						Game.from = Game.locations[i].letterCoord + "" + Game.locations[i].numCoord;
						break;
					}else if(Game.to == null) {
						Game.to = Game.locations[i].letterCoord + "" + Game.locations[i].numCoord;
						break;
					}
				}
			}
		}
		
		
		setChanged();
		notifyObservers();
	}
	


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent click) {


	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	@Override
	public void mouseDragged(MouseEvent drag) {
		
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
