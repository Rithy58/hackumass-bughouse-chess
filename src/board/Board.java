package board;

import piece.Piece;
import util.Constants;

public class Board {
	private Loc[][] loc;
	private Holding[] holding;

	public Board() {
		loc = new Loc[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		for (int r = 0; r < Constants.BOARD_SIZE; r++) {
			for (int c = 0; c < Constants.BOARD_SIZE; c++) {
				loc[r][c] = new Loc(r, c);
			}
		}
		holding = new Holding[Constants.NUM_TEAMS * 2];
	}

	public Piece getPiece(int row, int column) {
		return loc[row][column].getPiece();
	}

	public void placePiece(Piece p, int row, int column) {
		loc[row][column].setPiece(p);
	}

	public Piece removePiece(int row, int column) {
		Piece ret = loc[row][column].getPiece();
		loc[row][column].setPiece(null);
		return ret;
	}

	public void passToHolding(Piece p, Holding h) {
		h.addPiece(p);
	}
}
