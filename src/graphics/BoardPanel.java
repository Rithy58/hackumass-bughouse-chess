package graphics;

import java.awt.*;
import javax.swing.*;
import java.util.*;
public class BoardPanel extends JPanel {
	
	private static final int width = 600; // size of panel
	private static final int height = 600;

	private JLabel[][] board1 = new JLabel[8][8];
	private JLabel[][] board2 = new JLabel[8][8];
	private JButton[][] board1Squares = new JButton[8][8];
	private JButton[][] board2Squares = new JButton[8][8];
	private Image [][] pieceImages = new Image[8][8];
	
	public BoardPanel(){
		Dimension boardSize = new Dimension(600,600);
		setBackground(Color.GREEN);
		
		
	}

//	public void paint(Graphics g) {
//		g.fillRect(100, 100, 400, 400);
//		for (int i = 100; i <= 400; i += 100) {
//			for (int j = 100; j <= 400; j += 100) {
//				g.clearRect(i, j, 50, 50);
//			}
//		}
//
//		for (int i = 150; i <= 450; i += 100) {
//			for (int j = 150; j <= 450; j += 100) {
//				g.clearRect(i, j, 50, 50);
//			}
//		}
//	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("HackUMass - Bughouse Chess");
		//frame.setSize(600, 600);
		frame.getContentPane().add(new BoardPanel());
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}