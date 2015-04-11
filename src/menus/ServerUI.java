/**
 * @author Richard Cui
 */
package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import board.Game;
import util.Constants;
import communicator.Server;

public class ServerUI extends JFrame{
	
	private JPanel contentPane;
	private Game game;
	private Server server;
	public static DefaultListModel listModel;
	private JList list;
	public static JTextField playersTextField;

	public ServerUI() {
		setTitle("Bughouse");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JLabel lblPlayers = new JLabel("Players:");
		lblPlayers.setBounds(47, 290, 33, 20);
		contentPane.add(lblPlayers);
		
		playersTextField = new JTextField();
		playersTextField.setBounds(80, 290, 86, 20);
		contentPane.add(playersTextField);
		playersTextField.setColumns(10);
		
		server = new Server();
		game = new Game();
		//TODO threading
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (server.getNumClients() == 0) {
					JOptionPane.showMessageDialog(getParent(), "Cannot start.\nError code: Richard wishes he had friends.");
					return;
				}
				try {
					int players = Integer.parseInt(playersTextField.getText());
					if (players > 0)
						Constants.NUM_PLAYERS = players;
					else
						System.out.println("Using default players");
				} catch (NumberFormatException e) {
					System.out.println("Try typing a number next time; using default players");
				}
				//TODO ready up?
				setVisible(false);
			}
		});
		btnStartGame.setBounds(47, 400, 200, 25);
		contentPane.add(btnStartGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(117, 436, 60, 25);
		contentPane.add(btnExit);
		
		listModel = new DefaultListModel();
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(47, 50, 200, 225);
		contentPane.add(list);
	}
}
