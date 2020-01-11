package ie.gmit.sw;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	// Member Variables
	private Socket connection;
	private String message;
	private Scanner console;
	private String ip = "40.68.35.156";
	private int port = 10000;
	private ObjectOutputStream out;
	private ObjectInputStream in;

	// Default Constructor
	public Client() {
		console = new Scanner(System.in);
	}

	private void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void registerClub() {
		try {

			System.out.println("Preparing to Register Club ...");
			// 1 - establish server connection
			connection = new Socket(ip, port);

			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// ask for yes or no
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			// 2 - read first message from server
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);

			message = (String) in.readObject();
			System.out.println(message);

			out.close();
			in.close();
			connection.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void registerAgent() {
		try {

			System.out.println("Preparing to Register Agent ...");
			// 1 - establish server connection
			connection = new Socket(ip, port);

			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// 2 - read first message from server

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			out.close();
			in.close();
			connection.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean PlayerAgentlogin() {
		boolean isSuccessful = false;

		System.out.println("Preparing to Player login ...");

		try {

			// 1 - establish server connection
			connection = new Socket(ip, port);
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// Initialise request sequence

			// Enter account no.
			message = (String) in.readObject();
			System.out.println(message);
			message = ((Integer) getPositiveInteger()).toString();
			sendMessage(message);

			// Enter username
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			console.nextLine();
			sendMessage(message);

			// Enter password
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			console.nextLine();
			sendMessage(message);

			// Print response from server
			message = (String) in.readObject();
			System.out.println(message);

			if (!isError(message)) {
				isSuccessful = true;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		return isSuccessful;
	}

	// Continue to prompt the user for an input until they enter a positive integer
	// and return it.
	private int getPositiveInteger() {
		int number;

		do {
			while (!console.hasNextInt()) {
				System.out.println("Please enter a positive whole number!");
				console.next();
			}

			number = console.nextInt();

			if (number < 0) {
				System.out.println("Please enter a positive whole number!");
			}
		} while (number < 0);

		console.nextLine();

		return number;
	}

	public boolean ClubLogin() {

		boolean isSuccessful = false;

		System.out.println("Preparing to Club login ...");

		try {
			// 1 - establish server connection
			connection = new Socket(ip, port);
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// Initialise request sequence

			// Enter account no.
			message = (String) in.readObject();
			System.out.println(message);
			message = ((Integer) getPositiveInteger()).toString();
			sendMessage(message);

			// Enter username
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			console.nextLine();
			sendMessage(message);

			// Enter password
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			console.nextLine();
			sendMessage(message);

			// Print response from server
			message = (String) in.readObject();
			System.out.println(message);

			if (!isError(message)) {
				isSuccessful = true;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}

		return isSuccessful;
	}

	// Return true if the given message starts with "ERROR".
	// Used to check if messages returned from the server are error messages.
	private boolean isError(String msg) {
		String firstFiveLetters = msg.substring(0, Math.min(msg.length(), 5));
		return firstFiveLetters.equals("ERROR");
	}

	public void AddNewPlayer() {
		try {

			System.out.println("Preparing to Add Player  ...");
			// 1 - establish server connection
			connection = new Socket(ip, port);

			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// ask for yes or no
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			// 2 - read first message from server
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

			message = (String) in.readObject();
			System.out.println(message);

			message = (String) in.readObject();
			System.out.println(message);

			out.close();
			in.close();
			connection.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatePlayerValuation() {
		System.out.println("Preparing to update Player Value ....");
		try {

			System.out.println("Preparing to update Player  ....");

			// 1 - establish server connection
			connection = new Socket(ip, port);

			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// ask for yes or no
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void updatePlayerStatus() {
		System.out.println("Preparing to update Player status ....");
		try {

			System.out.println("Preparing to update Player status ....");

			// 1 - establish server connection
			connection = new Socket(ip, port);

			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// ask for yes or no
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void SearchForAllPlayersInPosition() {
		System.out.println("Preparing to search Player Positions ....");
		try {

			System.out.println("Preparing to search Player Positions ....");

			// 1 - establish server connection
			connection = new Socket(ip, port);

			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// ask for yes or no
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void SearchForAllPlayersForSale() {
		System.out.println("Preparing or All players for Sale ....");

		try {

			System.out.println("Preparing or All players for Sale ....");

			// 1 - establish server connection
			connection = new Socket(ip, port);

			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// ask for yes or no
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void SuspendAndResumePlayer() {
		System.out.println("SuspendAndResumePlayer");
		try {

			System.out.println("Suspend And Resume Player");

			// 1 - establish server connection
			connection = new Socket(ip, port);

			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// ask for yes or no
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void PurchaseAPlayer() {
		System.out.println("Purchase A Player Loading .....");
		try {

			System.out.println("Purchase A Player Loading Menu");

			// 1 - establish server connection
			connection = new Socket(ip, port);

			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();

			in = new ObjectInputStream(connection.getInputStream());
			System.out.println("client side ready...");

			// ask for yes or no
			message = (String) in.readObject();
			System.out.println(message);
			message = console.next();
			sendMessage(message);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void logout() {
		System.out.println("Logging Out");
	}
}