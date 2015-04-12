package graphics;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import board.Game;
import util.Constants;

public class GUI {
	public JFrame frame;
	private Game game;
	private int board1Turn;
	private int board2Turn;
	private int state;
	private int savedRow, savedColumn;

	/**
	 * Initialize image icons
	 */
	ImageIcon blank = new ImageIcon(getClass().getResource("blank.png"));
	ImageIcon black_bishop = new ImageIcon(getClass().getResource(
			"black_bishop.png"));
	ImageIcon black_king = new ImageIcon(getClass().getResource(
			"black_king.png"));
	ImageIcon black_knight = new ImageIcon(getClass().getResource(
			"black_knight.png"));
	ImageIcon black_pawn = new ImageIcon(getClass().getResource(
			"black_pawn.png"));
	ImageIcon black_queen = new ImageIcon(getClass().getResource(
			"black_queen.png"));
	ImageIcon black_rook = new ImageIcon(getClass().getResource(
			"black_rook.png"));
	ImageIcon white_bishop = new ImageIcon(getClass().getResource(
			"white_bishop.png"));
	ImageIcon white_king = new ImageIcon(getClass().getResource(
			"white_king.png"));
	ImageIcon white_knight = new ImageIcon(getClass().getResource(
			"white_knight.png"));
	ImageIcon white_pawn = new ImageIcon(getClass().getResource(
			"white_pawn.png"));
	ImageIcon white_queen = new ImageIcon(getClass().getResource(
			"white_queen.png"));
	ImageIcon white_rook = new ImageIcon(getClass().getResource(
			"white_rook.png"));

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 500, 1500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 2));

		Panel panel = new Panel();
		panel.setLayout(new GridLayout(8, 8));
		frame.getContentPane().add(panel);

		JPanel space = new JPanel();
		space.setBackground(Color.PINK);
		frame.getContentPane().add(space);
		space.setLayout(new GridLayout(1, 0, 0, 0));

		Panel panel_1 = new Panel();
		panel_1.setLayout(new GridLayout(8, 8));
		frame.getContentPane().add(panel_1);

		JButton[][] pieces = new JButton[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < Constants.BOARD_SIZE; j++) {
				panel.add(pieces[i][j]);
				pieces[i][j].addActionListener(new ButtonListener(0, i, j));
				if ((i + j) % 2 == 0) {
					pieces[i][j].setBackground(Color.red);
				} else
					pieces[i][j].setBackground(Color.white);
			}
		}

		JButton[][] pieces2 = new JButton[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < Constants.BOARD_SIZE; j++) {
				pieces2[i][j] = new JButton();
				panel_1.add(pieces2[i][j]);
				pieces2[i][j].addActionListener(new ButtonListener(1, i, j));
				if ((i + j) % 2 == 0) {
					pieces2[i][j].setBackground(Color.cyan);
				} else
					pieces2[i][j].setBackground(Color.white);
			}
		}

	}

	private class ButtonListener implements ActionListener {
		private int row;
		private int column;
		private int board;
		
		public ButtonListener(int b, int r, int c) {
			row = r;
			column = c;
			board = b;
		}
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(state == 0) {
				if(game.getBoard(board).getPiece(row, column) != null) {
					savedRow = row;
					savedColumn = column;
					state = 1;
				}
			} else {
				if(game.getBoard(board).getPiece(row, column) == null) {
					//move
					game.move(board, savedRow, savedColumn, row, column);
				} else {
					//captured
					int h;
					if(game.getBoard(board).getPiece(savedRow, savedColumn).getColor() == 0){
						h = 0;
					} else {
						h = 1;
					}
					int b;
					if(board == 0){
						b = 1;
					} else {
						b = 0;
					}
					//remove then pass to holding
					game.getBoard(board).passToHolding(
							game.getBoard(board).removePiece(savedRow, savedColumn)
							, game.getHolding(b, h));
					//move
					game.move(board, savedRow, savedColumn, row, column);
				}
				state = 0;
			}
			
			
			if(game.getBoard(board).getPiece(row, column) != null) {
				if(state == 0) {
					savedRow = row;
					savedColumn = column;
				} else {
					
					state = 0;
				}
			} else {
				
			}
		}
	}
}


