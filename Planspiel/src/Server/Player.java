package Server;

import java.net.Socket;

/**
 * 
 * @author D059270 Speichert entsprechende Daten des Spielers. �ber getter und
 *         setter kann auf die Attribute zugegriffen werden.
 * 
 */

public class Player {

	private String name = "";
	private String password = "";
	private Socket clientSocket;

	/**
	 * Legt einen neuen Spieler mit den Parametern:
	 * 
	 * @param name
	 * @param password
	 * @param clientSocket
	 *            an.
	 */
	public Player(String name, String password, Socket clientSocket) {
		setName(name);
		setPassword(password);
		setClientSocket(clientSocket);
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}