/**
 * @author Richard Cui
 */
package main;

import javax.swing.UIManager;

import menus.*;

public class Main {

	public static void main(String... args) {
		for (String string : args) {
			System.out.println(string + " ");
		}

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err
					.println("Exception.\nError code: Richard is not sure whats going on.");
			e.printStackTrace();
		}
		new MainMenu();
	}
}
