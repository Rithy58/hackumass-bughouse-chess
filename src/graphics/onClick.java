package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class onClick implements ActionListener {
	
	private int row;
	private int column;
	
	public onClick(int r, int c) {
		row = r;
		column = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//call some function on r and c
	}

}
