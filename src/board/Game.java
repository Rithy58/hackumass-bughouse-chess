package board;

import piece.*;
import util.Constants;

public class Game {

	private Board[] boards;
	/*
	 * 
	 * 
	 */
	private Holding[][] holdings;

	public Game() {

		boards = new Board[Constants.NUM_TEAMS];
		holdings = new Holding[Constants.NUM_TEAMS][2];

		for (int i = 0; i < Constants.NUM_TEAMS; i++) {
			boards[i] = new Board();
			for (int j = 0; j < 2; j++)
				// fix this
				holdings[i][j] = new Holding(null);
		}
	}

	public void move(Board b, int iRow, int iColumn, int fRow, int fColumn) {
		Piece p = b.getPiece(iRow, iColumn);
		if (p instanceof Pawn) {

		} else if (p instanceof Knight) {

		} else if (p instanceof Bishop) {

		} else if (p instanceof Rook) {

		} else if (p instanceof Queen) {

		} else if (p instanceof King) {

		}
	}

	public boolean isValidMove(int row, int column) {
		return false;
	}

	public void passToHolding(Piece p, Holding h) {
		h.addPiece(p);
	}
}
