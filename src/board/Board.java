package board;

import piece.Piece;

public class Board {
	private final int size = 8;
	private Loc[][] loc;

	public Piece getPiece(int row, int column) {
		return loc[row][column].getPiece();
	}
}
