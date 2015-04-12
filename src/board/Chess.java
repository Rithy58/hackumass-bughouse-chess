package board;

import communicator.*;

public class Chess {

	private Game game = null;
	private Communicator comm = null;
	
	public Chess(Game game, Communicator comm) {
		this.comm = comm;
		this.game = game;
		
		if (comm instanceof Client) {
			initClient();
		} else {
			System.out.println("I'm a server!");
		}
	}
	
	public void initClient() {
		Object o;
		do {
			o = ((Client) comm).getNextObject();
		} while (!(o instanceof Game));
		
	}
	
	public void initServer() {
		
	}
}
