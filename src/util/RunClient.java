/**
 * @author Richard Cui
 */
package util;

import board.Game;
import communicator.Client;

public class RunClient implements Runnable{

	private Client client = null;
	Game game = null;
	
	public RunClient(Client client, Game game) {
		this.client = client;
		this.game = game;
	}
	
	public void run() {
		Object o;
		while (true) {
			o = client.getNextObject();
			if (o instanceof Game)
				this.game = (Game) o;
			else if (o instanceof String)
				System.out.println((String) o);
		}
	}
}
