package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class onClick implements ActionListener {
	
	private int row;
	private int column;
	private int board;
	
	public onClick(int b, int r, int c) {
		row = r;
		column = c;
		board = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//call some function on r and c
	}

}
