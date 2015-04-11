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
		frame.setBounds(500, 500, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(8,8,0,0));
		
		JButton[][] pieces = new JButton[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
		for(int i = 0; i < Constants.BOARD_SIZE; i++){
			for(int j = 0; j < Constants.BOARD_SIZE; j++){
				pieces[i][j] = new JButton();
				frame.getContentPane().add(pieces[i][j]);
			}
		}
		
	}

}
