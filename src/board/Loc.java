package board;
import piece.Piece;

public class Loc {
	private int rank;
	private int file;
	private Piece piece;
	public int getRank(){
		return rank;
	}
	public int getFile(){
		return file;
	}
	public Piece getPiece(){
		return piece;
	}
	public void setPiece(Piece p){
		piece = p;
	}
}
