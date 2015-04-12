package graphics;

import java.awt.*;
import javax.swing.*;
import util.Constants;

public class GUI {
	public JFrame frame;
	
	/**
	 * Initialize image icons
	 */
	ImageIcon blank = new ImageIcon("blank.png");
	ImageIcon black_bishop = new ImageIcon(getClass().getResource("black_bishop.png"));
	ImageIcon black_king = new ImageIcon("black_king.png");
	ImageIcon black_knight = new ImageIcon("black_knight.png");
	ImageIcon black_pawn = new ImageIcon("black_pawn.png");
	ImageIcon black_queen = new ImageIcon("black_queen.png");
	ImageIcon black_rook = new ImageIcon("black_rook.png");
	ImageIcon white_bishop = new ImageIcon("white_bishop.png");
	ImageIcon white_king = new ImageIcon("white_king.png");
	ImageIcon white_knight = new ImageIcon("white_knight.png");
	ImageIcon white_pawn = new ImageIcon("white_pawn.png");
	ImageIcon white_queen = new ImageIcon("white_queen.png");
	ImageIcon white_rock = new ImageIcon("white_rock.png");
	
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
				pieces[i][j] = new JButton();
				panel.add(pieces[i][j]);
				pieces[i][j].addActionListener(new onClick(1, i, j));
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
				pieces2[i][j].addActionListener(new onClick(2, i, j));
				if ((i + j) % 2 == 0) {
					pieces2[i][j].setBackground(Color.cyan);
				} else
					pieces2[i][j].setBackground(Color.white);
			}
		}

	}
	
	private void startGame(){
		
	}

}
