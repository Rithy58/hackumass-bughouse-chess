package main;

import graphics.GUI;
import java.awt.EventQueue;

public class GUIMain {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
					window.update();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
