package visual;
import visual.ChessPanel;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import listeners.MouseListen;
import javax.swing.*;
import logic.Location;

public class Board {
	private  Dimension size = new Dimension(805, 825);
	
	private  JFrame frame;
	
	
	
	
	
	public Board (ChessPanel panel) {
		setup(panel);
		
	}
	private void setup(ChessPanel panel) {
		
		
		frame = new JFrame();
		
		
		

		frame.setSize(size);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
	
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
