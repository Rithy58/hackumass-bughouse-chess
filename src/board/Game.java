package board;

import piece.*;
import util.Constants;

public class Game {

	private Board[] boards;
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
	
	public void init(){
		for(Board b : boards){
			b = new Board();
		}
		boards[0].setTurn(1);
		boards[1].setTurn(3);
		for(int i = 0; i < Constants.BOARD_SIZE; i++){
			
		}
		for(int i = 0; i < Constants.BOARD_SIZE; i++){
			
		}
		for(Holding[] hArray : holdings){
			for(Holding h : hArray){
				h = new Holding(null);
			}
		}
	}

	public void move(int b, int iRow, int iColumn, int fRow, int fColumn) {
		boards[b].placePiece(boards[b].removePiece(iRow, iColumn), fRow, fColumn);
	}

	public boolean isValidMove(int row, int column) {
		return true;
	}

	public void passToHolding(Piece p, Holding h) {
		h.addPiece(p);
	}
	public Board getBoard(int i) {
		return boards[i];
	}
	public Holding getHolding(int board, int holding){
		return holdings[board][holding];
	}
}
