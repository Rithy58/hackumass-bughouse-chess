package board;

import piece.Piece;

public class Board {
	private final int boardSize = 8;
	private final int playerSize = 2;
	private Loc[][] loc;
	private Holding[] holding;
	
	public Board() {
		loc = new Loc[boardSize][boardSize];
		for(int r = 0; r < boardSize; r++) {
			for(int c = 0; c < boardSize; c++){
				loc[r][c] = new Loc(r, c);
			}
		}
		holding = new Holding[2];
	}

	public Piece getPiece(int row, int column) {
		return loc[row][column].getPiece();
	}
	
	public void placePiece(Piece p, int row, int column) {
		loc[row][column].setPiece(p);
	}
	
	public Piece removePiece(int row, int column){
		Piece ret = loc[row][column].getPiece();
		loc[row][column].setPiece(null);
		return ret;
	}
	
	public void passToHolding(Piece p, Holding h){ 
		h.addPiece(p);
	}
	
	//TODO
	public void move(int iRow, int iColumn, int fRow, int fColumn){
		
	}
	
	//TODO
	public boolean isValid(int iRow, int iColumn, int fRow, int fColumn){
		return false;
	}
}
