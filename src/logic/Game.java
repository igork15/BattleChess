package logic;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;

import javax.imageio.ImageIO;

import listeners.MouseListen;
import listeners.PieceListener;
import pieces.Piece;
import visual.Board;
import visual.ChessPanel;

public class Game implements Observer{
	private Board board;
	public static boolean whiteTurn = true;
	public static Piece[] pieces;
	
	public static String from;
	public static String to;
	
	public static HashMap<String, Piece> map = new HashMap<String, Piece>();
	public static HashMap<String, Location> locMap = new HashMap<String, Location>();
	private MouseListen mouseEvent;
	
	
	
	
	private String bgFile = "src\\images\\background.jpg";
	
	public static Location[] locations;
	

	
	public Game() {
		
		from = null;
		to = null;
		pieces = new Piece[32];
		populatePieces();
		locations = new Location[64];
		populateLocations();


		try {
			
			ChessPanel chess = new ChessPanel(bgFile);
			mouseEvent = new MouseListen(this, chess);
			
			
			chess.addMouseListener(mouseEvent );
			chess.addMouseMotionListener(mouseEvent);
			
			
			board = new Board(chess);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
			
			
		
		
		
	}

	private void populatePieces() {
		try {
			
			////////////////////////////BLACK PIECES////////////////////////////
			
			Piece blackRookA = new Piece(ImageIO.read
					(new File
					("src\\images\\blackRook-removebg.png")), 
					new Location(90, 75), "Rook", false, new ArrayList<String>());
			pieces[0] = blackRookA;
			
			ArrayList<String> bKnightM = new ArrayList<String>();
			bKnightM.add("C6");
			bKnightM.add("A6");
			Piece blackNight = new Piece(ImageIO.read
					(new File
					("src\\images\\blackNight-removebg.png")), 
					new Location(170, 75), "Knight", false, bKnightM);
			pieces[1] = blackNight;
			
			Piece blackBishopL = new Piece(ImageIO.read
					(new File
					("src\\images\\blackBishopL-removebg.png")), 
					new Location(250, 79), "Bishop", false, new ArrayList<String>());
			pieces[2] = blackBishopL;
			
			Piece blackQueen = new Piece(ImageIO.read
					(new File
					("src\\images\\blackQueen-removebg.png")), 
					new Location(340, 75), "Queen", false, new ArrayList<String>());
			pieces[3] = blackQueen;
			
			Piece blackKing = new Piece(ImageIO.read
					(new File
					("src\\images\\blackKing-removebg.png")), 
					new Location(420, 75), "King", false, new ArrayList<String>());
			pieces[4] = blackKing;
			
			Piece blackBishopD = new Piece(ImageIO.read
					(new File
					("src\\images\\blackBishopL-removebg.png")), 
					new Location(500, 79), "Bishop", false, new ArrayList<String>());
			pieces[5] = blackBishopD;
			
			ArrayList<String> gbKnightM = new ArrayList<String>();
			gbKnightM.add("F6");
			gbKnightM.add("H6");
			Piece blackNightG = new Piece(ImageIO.read
					(new File
					("src\\images\\blackNight-removebg.png")), 
					new Location(580, 75), "Knight", false, gbKnightM);
			pieces[6] = blackNightG;
			
			Piece blackRookH = new Piece(ImageIO.read
					(new File
					("src\\images\\blackRook-removebg.png")), 
					new Location(660, 75), "Rook", false, new ArrayList<String>());
			pieces[7] = blackRookH;
			
			////////////////////BLACK PAWNS//////////////////////////////////////////////////
			Piece blackPawnA = new Piece(ImageIO.read
					(new File
					("src\\images\\blackPawn-removebg.png")), 
					new Location(90, 165), "Pawn", false, new ArrayList<String>(Arrays.asList(new String[] {"A6", "A5"})));
			pieces[8] = blackPawnA;
			blackPawnA.firstMove = true;
			
			Piece blackPawnB = new Piece(ImageIO.read
					(new File
					("src\\images\\blackPawn-removebg.png")), 
					new Location(170, 165), "Pawn", false, new ArrayList<String>(Arrays.asList(new String[] {"B6", "B5"})));
			pieces[9] = blackPawnB;
			blackPawnB.firstMove = true;
			
			Piece blackPawnC = new Piece(ImageIO.read
					(new File
					("src\\images\\blackPawn-removebg.png")), 
					new Location(255, 165), "Pawn", false, new ArrayList<String>(Arrays.asList(new String[] {"C6", "C5"})));
			pieces[10] = blackPawnC;
			blackPawnC.firstMove = true;
			
			Piece blackPawnD = new Piece(ImageIO.read
					(new File
					("src\\images\\blackPawn-removebg.png")), 
					new Location(340, 165), "Pawn", false, new ArrayList<String>(Arrays.asList(new String[] {"D6", "D5"})));
			pieces[11] = blackPawnD;
			blackPawnD.firstMove = true;
			
			Piece blackPawnE = new Piece(ImageIO.read
					(new File
					("src\\images\\blackPawn-removebg.png")), 
					new Location(420, 165), "Pawn", false, new ArrayList<String>(Arrays.asList(new String[] {"E6", "E5"})));
			pieces[12] = blackPawnE;
			blackPawnE.firstMove = true;
			
			Piece blackPawnF = new Piece(ImageIO.read
					(new File
					("src\\images\\blackPawn-removebg.png")), 
					new Location(500, 165), "Pawn", false, new ArrayList<String>(Arrays.asList(new String[] {"F6", "F5"})));
			pieces[13] = blackPawnF;
			blackPawnF.firstMove = true;
			
			Piece blackPawnG = new Piece(ImageIO.read
					(new File
					("src\\images\\blackPawn-removebg.png")), 
					new Location(580, 165), "Pawn", false, new ArrayList<String>(Arrays.asList(new String[] {"G6", "G5"})));
			pieces[14] = blackPawnG;
			blackPawnG.firstMove = true;
			
			Piece blackPawnH = new Piece(ImageIO.read
					(new File
					("src\\images\\blackPawn-removebg.png")), 
					new Location(660, 165), "Pawn", false, new ArrayList<String>(Arrays.asList(new String[] {"H6", "H5"})));
			pieces[15] = blackPawnH;
			blackPawnH.firstMove = true;
			
			/////////////////////White Pieces///////////////////////////////////
			Piece whiteRookA = new Piece(ImageIO.read
					(new File
					("src\\images\\whiteRook-removebg.png")), 
					new Location(90, 645), "Rook", true, new ArrayList<String>());
			pieces[16] = whiteRookA;
			
			Piece whiteKnight = new Piece(ImageIO.read
					(new File
					("src\\images\\whiteKnight-removebg.png")), 
					new Location(170, 650), "Knight", true, new ArrayList<String>(Arrays.asList(new String[] {"A3", "C3"})));
			pieces[17] = whiteKnight;
			
			Piece whiteBishopD = new Piece(ImageIO.read
					(new File
					("src\\images\\whiteBishop-removebg.png")), 
					new Location(260, 650), "Bishop", true, new ArrayList<String>());
			pieces[18] = whiteBishopD;
			
			Piece whiteQueen = new Piece(ImageIO.read
					(new File
					("src\\images\\whiteQueen-removebg.png")), 
					new Location(340, 645), "Queen", true, new ArrayList<String>());
			pieces[19] = whiteQueen;
			
			Piece whiteKing = new Piece(ImageIO.read
					(new File
					("src\\images\\whiteKing-removebg.png")), 
					new Location(420, 645), "King", true, new ArrayList<String>());
			pieces[20] = whiteKing;
			
			Piece whiteBishopL = new Piece(ImageIO.read
					(new File
					("src\\images\\whiteBishop-removebg.png")), 
					new Location(500, 650), "Bishop", true, new ArrayList<String>());
			pieces[21] = whiteBishopL;
			
			Piece whiteKnightB = new Piece(ImageIO.read
					(new File
					("src\\images\\whiteKnight-removebg.png")), 
					new Location(580, 650), "Knight", true, new ArrayList<String>(Arrays.asList(new String[] {"F3", "H3"})));
			pieces[22] = whiteKnightB;
			
			Piece whiteRookH = new Piece(ImageIO.read
					(new File
					("src\\images\\whiteRook-removebg.png")), 
					new Location(660, 645), "Rook", true, new ArrayList<String>());
			pieces[23] = whiteRookH;
			
			////////////////////////////WHITE PAWNS///////////////////////////
			Piece whitePawnA = new Piece(ImageIO.read
					(new File
					("src\\images\\whitePawn-removebg.png")), 
					new Location(90, 570), "Pawn", true, new ArrayList<String>(Arrays.asList(new String[] {"A3", "A4"})));
			pieces[24] = whitePawnA;
			whitePawnA.firstMove = true;
			
			Piece whitePawnB = new Piece(ImageIO.read
					(new File
					("src\\images\\whitePawn-removebg.png")), 
					new Location(170, 570), "Pawn", true, new ArrayList<String>(Arrays.asList(new String[] {"B3", "B4"})));
			pieces[25] = whitePawnB;
			whitePawnB.firstMove = true;
			
			Piece whitePawnC = new Piece(ImageIO.read
					(new File
					("src\\images\\whitePawn-removebg.png")), 
					new Location(255, 570), "Pawn", true, new ArrayList<String>(Arrays.asList(new String[] {"C3", "C4"})));
			pieces[26] = whitePawnC;
			whitePawnC.firstMove = true;
			
			Piece whitePawnD = new Piece(ImageIO.read
					(new File
					("src\\images\\whitePawn-removebg.png")), 
					new Location(335, 570), "Pawn", true, new ArrayList<String>(Arrays.asList(new String[] {"D3", "D4"})));
			pieces[27] = whitePawnD;
			whitePawnD.firstMove = true;
			
			Piece whitePawnE = new Piece(ImageIO.read
					(new File
					("src\\images\\whitePawn-removebg.png")), 
					new Location(420, 570), "Pawn", true, new ArrayList<String>(Arrays.asList(new String[] {"E3", "E4"})));
			pieces[28] = whitePawnE;
			whitePawnE.firstMove = true;
			
			Piece whitePawnF = new Piece(ImageIO.read
					(new File
					("src\\images\\whitePawn-removebg.png")), 
					new Location(500, 570), "Pawn", true, new ArrayList<String>(Arrays.asList(new String[] {"F3", "F4"})));
			pieces[29] = whitePawnF;
			whitePawnF.firstMove = true;
			
			Piece whitePawnG = new Piece(ImageIO.read
					(new File
					("src\\images\\whitePawn-removebg.png")), 
					new Location(580, 570), "Pawn", true, new ArrayList<String>(Arrays.asList(new String[] {"G3", "G4"})));
			pieces[30] = whitePawnG;
			whitePawnG.firstMove = true;
			
			Piece whitePawnH = new Piece(ImageIO.read
					(new File
					("src\\images\\whitePawn-removebg.png")), 
					new Location(660, 570), "Pawn", true, new ArrayList<String>(Arrays.asList(new String[] {"H3", "H4"})));
			pieces[31] = whitePawnH;
			whitePawnH.firstMove = true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void populateLocations() {
		int x = 75;
		int y = 75;
		int x2 = 155;
		int y2 = 155;
		
		String[] letterAr = {"A", "B", "C", "D", "E", "F", "G", "H"};
		int numLoc = 8;
		
		
		int l = 0;
		int pieceIndex = 0;
		for(int i = 0; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				Location location = new Location(x, y, x2, y2);
				
				locMap.put(letterAr[j] + String.valueOf(numLoc), location);
				if(i == 0 || i == 1) {
					location.piece = pieces[pieceIndex];
				}else {
					location.piece = new Piece();
				}
				
				locations[l] = location;
				x += 82;
				x2 += 82;
				l++;
				pieceIndex++;
			}
			
			numLoc--;
			if(numLoc > 8) {
				numLoc = 1;
			}
			x = 75;
			y += 82;
			x2 = 155;
			y2 += 82;
		}
		pieceIndex = 24;
		numLoc = 2;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 8; j++) {
				Location location = new Location(x, y, x2, y2);
				if(location.letterCoord == 'E' && location.numCoord == 1) {
					location.piece = pieces[pieceIndex];
				}else if(location.letterCoord == 'D' && location.numCoord == 1) {
					location.piece = pieces[pieceIndex];
				}else {
					location.piece = pieces[pieceIndex];
				}
				
				locMap.put(letterAr[j] + String.valueOf(numLoc), location);
				
				locations[l] = location;
				x += 82;
				x2 += 82;
				l++;
				pieceIndex++;
			}
			pieceIndex = 16;
			numLoc--;

			x = 75;
			y += 82;
			x2 = 155;
			y2 += 82;
		}
		
		for(int i = 0; i < locations.length; i++) {
			map.put(locations[i].letterCoord+""+locations[i].numCoord, locations[i].piece);		
		}
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(from != null && to != null) {
			makeMove();
			from = null;
			to = null;
		}
		
	}
	
	private void updateLegalMoves() {
		for(String s : locMap.keySet()) {
			ArrayList<String> temp = new ArrayList<String>();
			Piece piece = locMap.get(s).piece;
			
			
			Location loc = locMap.get(s);
			if(piece.loc != null) {
				System.out.print(loc.letterCoord);
				System.out.println(piece.loc.numCoord);
			}
			int low = 0;
			int high = 8;
			char clow = 'A';
			char chigh = 'H';
			
			if(piece.white) {
				if(piece.name.contentEquals("Pawn")) {
					String l = loc.letterCoord + "" + (loc.numCoord+1);
					String l2 = loc.letterCoord + "" + (loc.numCoord+2);
					
					if(locMap.get(l).piece.name.contentEquals("Empty")) {
						temp.add(l);
						
					}
					if(locMap.get(l2).piece.name.contentEquals("Empty") && piece.firstMove) {
						temp.add(l2);
						
					}
					piece.legalMoves = new ArrayList<String>(temp);
					
				}else if(piece.name.contentEquals("Knight")) {
					if(loc.letterCoord == piece.loc.letterCoord -2 && loc.numCoord == piece.loc.numCoord + 1) {
						char letter = loc.letterCoord;
						int num = loc.numCoord;
						
						if(locMap.get(letter +""+ num).piece.name.contentEquals("Empty") ||
								!locMap.get(letter +""+num).piece.white) {
							temp.add(letter +""+ num);
						}
					}
				}
				
			}
			
			
		}
	}
	private boolean checkLegal(Piece piece, Location loc) {
		if(piece.legalMoves == null || piece.legalMoves.size() < 1) {
			return false;
		}
		
		for(int i = 0; i < piece.legalMoves.size(); i++) {
			if(piece.legalMoves.get(i).contentEquals(loc.letterCoord + "" + loc.numCoord)) {
				return true;
			}
		}
		return false;
	}
	private void makeMove() {
		
		Piece b2Piece = map.get(from);
		
		
		Location b2 = locMap.get(from);
		
		Location b3 = locMap.get(to);
		
		if(b2Piece.white && whiteTurn && checkLegal(b2Piece, b3)) {
			if(b3.piece != null) {
				b3.piece = null;
			}
			
			
			b3.piece = b2Piece;
			
			
			b2Piece.loc = b3;
			if(b2Piece.name.contentEquals("Knight") && b2Piece.white) {
				b2Piece.loc.x += 8;
			}
			else {
				b2Piece.loc.x += 15;

			}
			
			
			
			map.put(from, new Piece());
			map.put(to, b3.piece);
			
			if(b2Piece.firstMove)
				b2Piece.firstMove = false;
			whiteTurn = !whiteTurn;
		}
		
		if(!b2Piece.white && !whiteTurn && checkLegal(b2Piece, b3)) {
			if(b3.piece != null) {
				b3.piece = null;
			}
			
			
			b3.piece = b2Piece;
			
			
			b2Piece.loc = b3;
			if(b2Piece.name.contentEquals("Knight")) {
				b2Piece.loc.x += 8;
			}else {
				b2Piece.loc.x += 15;

			}
			
			
			map.put(from, new Piece());
			map.put(to, b3.piece);

			whiteTurn = !whiteTurn;

		}
		
		updateLegalMoves();

	}

}
