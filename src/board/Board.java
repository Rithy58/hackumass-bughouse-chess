package board;

import piece.*;

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
		Loc start = loc[iRow][iColumn];
		Loc end = loc[fRow][fColumn];
		boolean[] valid = isValidMove(iRow, iColumn, fRow, fColumn);
		
		if (!valid[0]) return;
		else if (valid[1]) {
			end.setColumn(-1);
			end.setRow(-1);
		}
	}
	
	//TODO
	public boolean[] isValidMove(int iRow, int iColumn, int fRow, int fColumn){
		Piece moving = loc[iRow][iColumn].getPiece();
		boolean[] valid = {false, false};
		int scl = moving.getColor();
		
		if (moving instanceof Pawn && moving.getColor() == 0) {
			if (!moving.getMoved() && 
					iRow == fRow && iColumn == fColumn - 2*scl && 
					loc[iRow][iColumn - scl].getPiece() == null && loc[iRow][fColumn].getPiece() == null) {
				valid[0] = true;
				valid[1] = false;
			}
			else if (moving.getMoved() && 
					iRow == fRow - 1 && iColumn == fColumn - 1 &&
					loc[fRow][fColumn].getPiece() != null) {
				valid[0] = true;
				valid[1] = true;
			}
//			else if (moving.getMoved() &&
//					iRow == fRow + 1&& iColumn == fColumn - 1 &&
//					)
		}
		return valid;
	}
	
	public Holding getWhiteHolding() {
		return holding[0];
	}
	
	public Holding getBlackHolding() {
		return holding[1];
	}
}
