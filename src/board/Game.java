package board;
import util.Constants;

public class Game {
	
	private Board[] boards;
	/*
	 * 
	 * 
	 */
	private Holding[][] holdings;
	
	public Game() {
		
		boards = new Board[Constants.NUM_TEAMS];
		holdings = new Holding[Constants.NUM_TEAMS][2];
		
		for (int i = 0; i < Constants.NUM_TEAMS; i++) {
			boards[i] = new Board();
			for (int j = 0; j < 2; j++)
				//fix this
				holdings[i][j] = new Holding(null);
		}
	}
	
	
}
