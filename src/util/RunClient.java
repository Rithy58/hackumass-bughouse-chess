/**
 * @author Richard Cui
 */
package util;

import java.util.Timer;
import java.util.TimerTask;

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
		client.sendObject(game);
//		TimerTask timerTask = new TimerTask() {
//			public void run() {
//				client.sendObject(game);
//			}
//		};
//		Timer timer = new Timer();
		while (true) {
			o = client.getNextObject();
			if (o instanceof Game) {
				this.game = (Game) o;
				client.sendObject(game);
			}
//			timer.scheduleAtFixedRate(timerTask, 200, 200);
		}
	}
}
