/**
 * @author Richard Cui, Rithy Muth
 */
package board;

import piece.*;
import util.Constants;

public class Game {

	private Board[] boards;
	private Holding[] holdings;

	public Game() {

		boards = new Board[Constants.NUM_TEAMS];
		holdings = new Holding[Constants.NUM_PLAYERS];

		for (int i = 0; i < Constants.NUM_TEAMS; i++)
			boards[i] = new Board();
		for (int i = 0; i < Constants.NUM_PLAYERS; i++)
			holdings[i] = new Holding();
	}

	public void init() {
		for (Board b : boards) {
			b = new Board();
		}
		boards[0].setTurn(1);
		boards[1].setTurn(3);
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			boards[0].placePiece(new Pawn(0), 6, i);
			boards[0].placePiece(new Pawn(1), 1, i);
		}
		boards[0].placePiece(new Rook(0), 7, 0);
		boards[0].placePiece(new Rook(1), 0, 0);
		boards[0].placePiece(new Rook(0), 7, 7);
		boards[0].placePiece(new Rook(1), 0, 7);

		boards[0].placePiece(new Knight(0), 7, 1);
		boards[0].placePiece(new Knight(1), 0, 1);
		boards[0].placePiece(new Knight(0), 7, 6);
		boards[0].placePiece(new Knight(1), 0, 6);

		boards[0].placePiece(new Bishop(0), 7, 2);
		boards[0].placePiece(new Bishop(1), 0, 2);
		boards[0].placePiece(new Bishop(0), 7, 5);
		boards[0].placePiece(new Bishop(1), 0, 5);

		boards[0].placePiece(new Queen(0), 7, 3);
		boards[0].placePiece(new King(1), 0, 3);
		boards[0].placePiece(new King(0), 7, 4);
		boards[0].placePiece(new Queen(1), 0, 4);
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			boards[1].placePiece(new Pawn(1), 6, i);
			boards[1].placePiece(new Pawn(0), 1, i);
		}
		boards[1].placePiece(new Rook(1), 7, 0);
		boards[1].placePiece(new Rook(0), 0, 0);
		boards[1].placePiece(new Rook(1), 7, 7);
		boards[1].placePiece(new Rook(0), 0, 7);

		boards[1].placePiece(new Knight(1), 7, 1);
		boards[1].placePiece(new Knight(0), 0, 1);
		boards[1].placePiece(new Knight(1), 7, 6);
		boards[1].placePiece(new Knight(0), 0, 6);

		boards[1].placePiece(new Bishop(1), 7, 2);
		boards[1].placePiece(new Bishop(0), 0, 2);
		boards[1].placePiece(new Bishop(1), 7, 5);
		boards[1].placePiece(new Bishop(0), 0, 5);

		boards[1].placePiece(new Queen(1), 7, 4);
		boards[1].placePiece(new King(0), 0, 4);
		boards[1].placePiece(new King(1), 7, 3);
		boards[1].placePiece(new Queen(0), 0, 3);
		for (Holding h : holdings)
			h.init();
	}

	public void move(int b, int iRow, int iColumn, int fRow, int fColumn) {
		// boards[b].removePiece(fRow, fColumn);
		
		/*
		 * This bit of code below doesn't work...I dunno why
		 */
//		if (iRow == fRow && iColumn == fColumn){
//			return;
//		}
//		else{
		Piece removed = boards[b].removePiece(iRow, iColumn);
		Piece captured = boards[b].getPiece(fRow, fColumn); 
		if (captured == new Queen(1)) // set as new Queen for testing purposes...can we not have a "null" piece?s
			passToHolding(captured, holdings[1]);
		boards[b].placePiece(removed, fRow,fColumn);
		System.out.println("Holdings:" + getHolding(1).getPieces());
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

	public Holding getHolding(int holding) {
		return holdings[holding];
	}
}
