package piece;

public abstract class Piece {

	public abstract boolean getMoved();
	public abstract void setMoved(boolean moved);
	public abstract int getColor();
	public abstract void setColor(int color);
	public abstract boolean getPromoted();
	public abstract void setPromoted(boolean promoted);
}
