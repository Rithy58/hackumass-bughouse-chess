package board;

import piece.*;
import player.*;

import java.util.ArrayList;
import java.util.List;

public class Holding {

	private List<Piece> pieces;

	public Holding() {
		pieces = new ArrayList<Piece>();
	}

	public void addPiece(Piece piece) {
		pieces.add(piece);
	}

	public Piece removePiece(Piece piece) {
		if (pieces.indexOf(piece) < 0)
			return null;
		return pieces.get(pieces.indexOf(piece));
	}

	public List<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}
	
	public void init() {
		pieces = new ArrayList<Piece>();
	}
}
