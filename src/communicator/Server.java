/**
 * @author Richard Cui
 */
package communicator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import board.Game;

public class Server implements Communicator {
	
	private ServerSocket broadcastSocket = null;
	private ServerSocket serverSocket = null;

	private ArrayList<Socket> clientSockets = null;
	private ArrayList<ObjectOutputStream> objOutputs = null;
	private ArrayList<ObjectInputStream> objInputs = null;
	
	private Game game = null;
	private int writeCount = 0;
	
	public Object getNextObject(int client) {
		Object ret = null;
		try {
			ret = objInputs.get(client).readUnshared();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Connection lost: server.");
			removeFromClients(client);
			e.printStackTrace();
		}
		return ret;
	}

	public synchronized void sendObject(Object o) {
		for (int i = 0; i < objOutputs.size(); i++)
			sendObject(o);
		if (writeCount > 1000)
			reset();
		writeCount++;
	}
	
	public synchronized void sendObject(Object o, int client) {
		if (objOutputs.get(client) != null) {
			try {
				objOutputs.get(client).writeUnshared(o);
				if (writeCount > 1000)
					reset();
				writeCount++;
			} catch (IOException e) {
				System.err.println("Connection lost: server.");
				removeFromClients(client);
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void reset() {
		for (int i = 0; i < objOutputs.size(); i++) {
			try {
				if (objOutputs.get(i) != null) {
					objOutputs.get(i).reset();
					writeCount = 0;
				}
			} catch (IOException e) {
				System.err.println("Reset is broken.\nError code: Richard is too tired to code properly.");
				e.printStackTrace();
			}
		}
	}
	
	private void removeFromClients(int client) {
		objOutputs.set(client, null);
		objInputs.set(client, null);
		clientSockets.set(client, null);
	}

	public void close() {
		try {
			for (int i = 0; i < clientSockets.size(); i++) {
				objOutputs.get(i).close();
				objInputs.get(i).close();
				clientSockets.get(i).close();
				removeFromClients(i);
			}
			serverSocket.close();
		} catch (IOException e) {
			System.err.println("Sockets failed to close.\nError code: Richard really needs his sleep.");
			e.printStackTrace();
		}
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public int getNumClients() {
		return clientSockets.size();
	}
	
	public ArrayList<ObjectInputStream> getObjInputs() {
		return objInputs;
	}
	
	class Broadcast implements Runnable {
		public void run() {
			while (true) {
				try {
					broadcastSocket.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class Accepter implements Runnable {
		public void run() {
			int numClients = 0;
			while (numClients <= 3) {
				try {
					System.out.println("\nWaiting for Client!");
					Socket client = serverSocket.accept();
					ObjectInputStream in = new ObjectInputStream(client.getInputStream());
					ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
					clientSockets.add(client);
					objInputs.add(in);
					objOutputs.add(out);
					
					System.out.println("Client " + numClients + " connected.");
					Object name = getNextObject(numClients);
					//TODO Add prompts for connections
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
