package graphics;

import java.awt.*;
import javax.swing.*;
import util.Constants;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame.getContentPane().setLayout(new GridLayout(1,2));
		
		
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(8,8));
		frame.getContentPane().add(panel);
		
		JPanel space = new JPanel();
		space.setBackground(Color.PINK);
		frame.getContentPane().add(space);
		space.setLayout(new GridLayout(1, 0, 0, 0));
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(new GridLayout(8, 8));
		frame.getContentPane().add(panel_1);
		
		JButton[][] pieces = new JButton[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		for(int i = 0; i < Constants.BOARD_SIZE; i++){
			for(int j = 0; j < Constants.BOARD_SIZE; j++){
				pieces[i][j] = new JButton();
				panel.add(pieces[i][j]);
				if ((i+j) % 2 == 0){
					pieces[i][j].setBackground(Color.red);
				}
				else
					pieces[i][j].setBackground(Color.white);
			}
		}
		
		JButton[][] pieces2 = new JButton[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		for(int i = 0; i < Constants.BOARD_SIZE; i++){
			for(int j = 0; j < Constants.BOARD_SIZE; j++){
				pieces2[i][j] = new JButton();
				panel_1.add(pieces2[i][j]);
				if ((i+j) % 2 == 0){
					pieces2[i][j].setBackground(Color.cyan);
				}
				else
					pieces2[i][j].setBackground(Color.white);
			}
		}
		
	}

}
