package graphics;

import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;

import javax.swing.*;

import piece.*;
import board.Game;
import util.Constants;

public class GUI extends TimerTask {
	public JFrame frame;
	private Game game;
	private int state;
	private int savedRow, savedColumn;
	private JButton[][] pieces = new JButton[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
	private JButton[][] pieces2 = new JButton[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

	//ImageIcon black_bishop_sm = new ImageIcon(getClass().getResource("black_bishop_sm.png"));

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		game = new Game();
		game.init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(0, 0, 1000, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		Panel panel = new Panel();
		panel.setLayout(new GridLayout(8, 8));
		panel.setBounds(0, 0, 400, 400);
		frame.getContentPane().add(panel);

		JPanel space = new JPanel();
		space.setBackground(Color.PINK);
		space.setLayout(new GridLayout(2, 2));
		space.setBounds(400, 0, 200, 400);
		frame.getContentPane().add(space);

		JPanel holding1 = new JPanel();
		holding1.setBackground(Color.GREEN);
		holding1.setLayout(new GridLayout(8, 4));
		//holding1.setBounds(0,800,400,400);
		space.add(holding1);
		

		JButton[][] hold1 = new JButton[Constants.BOARD_SIZE][4];
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < 4; j++) {
				hold1[i][j] = new JButton();
				holding1.add(hold1[i][j]);
				hold1[i][j].setBackground(Color.green);
			}
		}

		JPanel holding2 = new JPanel();
		holding2.setBackground(Color.MAGENTA);
		holding2.setLayout(new GridLayout(8, 4));
		//holding2.setBounds(100,100,100,100);
		space.add(holding2);

		JButton[][] hold2 = new JButton[Constants.BOARD_SIZE][4];
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < 4; j++) {
				hold2[i][j] = new JButton();
				holding2.add(hold2[i][j]);
				hold2[i][j].setBackground(Color.magenta);
			}
		}

		JPanel holding3 = new JPanel();
		holding3.setBackground(Color.ORANGE);
		holding3.setLayout(new GridLayout(8, 4));
		space.add(holding3);
		JButton[][] hold3 = new JButton[Constants.BOARD_SIZE][4];
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < 4; j++) {
				hold3[i][j] = new JButton();
				holding3.add(hold3[i][j]);
				hold3[i][j].setBackground(Color.orange);
			}
		}

		JPanel holding4 = new JPanel();
		holding4.setBackground(Color.PINK);
		holding4.setLayout(new GridLayout(8, 4));
		//holding4.setBounds(200,200,100,100);
		space.add(holding4);

		JButton[][] hold4 = new JButton[Constants.BOARD_SIZE][4];
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < 4; j++) {
				hold4[i][j] = new JButton();
				holding4.add(hold4[i][j]);
				hold4[i][j].setBackground(Color.pink);
			}
		}

		Panel panel_1 = new Panel();
		panel_1.setLayout(new GridLayout(8, 8));
		panel_1.setBounds(600,0,400,400);
		frame.getContentPane().add(panel_1);

		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < Constants.BOARD_SIZE; j++) {
				pieces[i][j] = new JButton();
				panel.add(pieces[i][j]);
				pieces[i][j].addActionListener(new ButtonListener(0, i, j));
				if ((i + j) % 2 == 0) {
					pieces[i][j].setBackground(Color.red);
				} else
					pieces[i][j].setBackground(Color.white);
			}
		}

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

	public void update() {
		for (int i = 0; i < Constants.BOARD_SIZE; i++) {
			for (int j = 0; j < Constants.BOARD_SIZE; j++) {
				if (game.getBoard(0).getPiece(i, j) == null) {
					pieces[i][j].setIcon(new ImageIcon(getClass().getResource(
							"null.png")));
				} else {
					pieces[i][j].setIcon(new ImageIcon(getClass()
							.getResource(
									game.getBoard(0).getPiece(i, j).getImage()
											+ ".png")));
				}
				if (game.getBoard(1).getPiece(i, j) == null) {
					pieces2[i][j].setIcon(new ImageIcon(getClass().getResource(
							"null.png")));
				} else {
					pieces2[i][j].setIcon(new ImageIcon(getClass()
							.getResource(
									game.getBoard(1).getPiece(i, j).getImage()
											+ ".png")));
				}
			}
		}
		/*
		 * frame.validate(); frame.repaint();
		 */
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
			if (state == 0) {
				System.out.println("State = 0");
				if (game.getBoard(board).getPiece(row, column) != null) {
					savedRow = row;
					savedColumn = column;
					System.out.println("Saved coord");
					state = 1;
					System.out.println("State = 1");
				}
			} else {
				System.out.println("second press");
				if (game.getBoard(board).getPiece(row, column) == null) {
					// move
					game.move(board, savedRow, savedColumn, row, column);
					System.out.println("moved");
					state = 0;
				} else {
					// captured
					int h;
//					if (game.getBoard(board).getPiece(row, column)
//							.getColor() == 0) {
//						h = 0;
//					} else {
//						h = 1;
//					}
//					int b;
//					if (board == 0) {
//						b = 1;
//					} else {
//						b = 0;
//					}
					Piece captured = game.getBoard(board).getPiece(row, column);
					if (board == 0 && captured.getColor() == 0)
						h = 0;
					else if (board == 0)
						h = 3;
					else if (board == 1 && captured.getColor() == 0)
						h = 2;
					else
						h = 1;
					game.passToHolding(captured, game.getHolding(h));
					game.getBoard(board).removePiece(row, column);
					System.out.println("captured");
					game.move(board, savedRow, savedColumn, row, column);
					state = 0;
					
					// remove then pass to holding
//					game.getBoard(board).passToHolding(
//							game.getBoard(board).removePiece(savedRow,
//									savedColumn), game.getHolding(h));
//					System.out.println("captured");
					// move
//					game.move(board, savedRow, savedColumn, row, column);
//					System.out.println("moved");
//					state = 0;
				}
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		update();
	}
}
