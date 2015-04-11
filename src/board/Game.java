package board;

public class Game {
	
	private final int NUM_TEAMS = 2;
	
	private Board[] boards;
	/*
	 * 
	 * 
	 */
	private Holding[][] holdings;
	
	public Game() {
		
		boards = new Board[NUM_TEAMS];
		holdings = new Holding[NUM_TEAMS][2];
		
		for (int i = 0; i < NUM_TEAMS; i++) {
			boards[i] = new Board();
			for (int j = 0; j < 2; j++)
				//fix this
				holdings[i][j] = new Holding(null);
		}
	}
	
	
}
