package board;

import piece.*;
import player.*;
import java.util.List;

public class Holding {

	private Player player;
	private List<Piece> pieces;
	
	public Holding(Player player) {
		this.player = player;
	}
	
	public void addPiece(Piece piece) {
		pieces.add(piece);
	}
	
	public Piece removePiece(Piece piece) {
		if (pieces.indexOf(piece) < 0) return null;
		return pieces.get(pieces.indexOf(piece));
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public List<Piece> getPieces() {
		return pieces;
	}
	
	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}
}
