package ie.gmit.sw;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		ServerSocket listener;
		int clientid = 0;

		try {
			// Open Listening Socket at Port 10000
			listener = new ServerSocket(10000, 10);

			// stay alive
			while (true) {

				System.out.println("main thread listening for incoming connections");
				Socket newConnection = listener.accept();

				// Display new Thread
				System.out.println("new connection received and spanning a thread");
				clientid++;

				// Spans a new Thread once there is a new connection
				Thread t = new Thread(new ConnectionHandler(newConnection, clientid));
				System.out.println(
						"new connection received and spanning a thread @ " + newConnection + "" + "client" + clientid);

				t.start();

			}
			// DEBUG
		} catch (IOException e) {
			System.out.println("socket not opened");
			e.printStackTrace();
		}

	}

	// Write the Club Registered to a file club.txt
	public void WriteClubToFile(Club club) {

		try {
			final String filepath = "clubs.txt";

			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(club);
			objectOut.close();
			System.out.println("The Object was succesfully written to a file");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Write the Club Registered to a file club.txt
	public void WritePlayerToFile(Player player) {

		try {
			final String filepath = "Players.txt";

			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(player);
			objectOut.close();
			System.out.println("The Object was succesfully written to a file");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Write the Club Registered to a file club.txt
	public void WriteAgentToFile(Agent agent) {

		try {
			final String filepath = "Agents.txt";

			FileOutputStream fileOut = new FileOutputStream(filepath);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(agent);
			objectOut.close();
			System.out.println("The Object was succesfully written to a file");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

class ConnectionHandler implements Runnable {

	// Member Variables

	Socket individualConnection;
	int socketId;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	int answer;
	String clubID;
	String email;
	String Clubname;
	String funds;
	int option;
	int userInput;
	int choice;
	String AgentName;
	String AgentID;
	String Agentemail;

	String Playername;
	String PlayerAge;
	String PlayerID;
	String Valuation;
	String PlayerStatus = "";
	String Position;

	// Constructor
	public ConnectionHandler(Socket individualConnection, int socketId) {
		this.individualConnection = individualConnection;
		this.socketId = socketId;
	}

	// Write Message to command line
	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			// display Message to command line
			System.out.println("client> " + msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {
			// Close previous socket and begin new path
			out = new ObjectOutputStream(individualConnection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(individualConnection.getInputStream());
			// Print connection info
			System.out.println("connection" + socketId + "from ip: " + individualConnection.getInetAddress());

			// Member Variables initialized

			// Print to console
			sendMessage("Press 1(register Club) Press 2 (register Agent) Press 3 (Player Login) Press 4 Club Login ");
			// Display message
			message = (String) in.readObject();
			// read users choice for 4 options in server
			choice += Integer.parseInt(message);

			// 1 - Registers a Club
			if (choice == 1) {

				// Send message to console
				sendMessage("Enter Club name ");
				message = (String) in.readObject();
				// assign var to message
				Clubname = message;

				// Send message to console
				sendMessage("enter club ID: ");
				message = (String) in.readObject();
				// assign var to message
				clubID = message;

				// Send message to console
				sendMessage("Enter Club Email: ");
				message = (String) in.readObject();
				// assign var to message
				email = message;

				// Send message to console
				sendMessage("Enter Clubs Funds: ");
				message = (String) in.readObject();
				// assign var to message
				funds = message;

				// DEBUG
				Server objectIO = new Server();

				// Create object holding instances entered by client
				Club club = new Club(this.Clubname, this.clubID, this.email, this.funds);
				objectIO.WriteClubToFile(club);

				// Display to client Entered Values
				sendMessage("Details Entered || -name:" + Clubname + " " + "clubID:" + clubID + " " + "email:" + email
						+ " " + "funds:" + funds);

				// Display Message to client-side
				sendMessage("Successfully Completed");

				// 2 - Allows Agent to Register
			} else if (choice == 2) {

				// Send message to client console
				sendMessage("Enter Agent Name ");
				message = (String) in.readObject();
				// assign var to message
				AgentName = message;

				sendMessage("Enter 	Agent ID: ");
				message = (String) in.readObject();
				// assign var to message
				AgentID = message;

				// Send message to client console
				sendMessage("Enter Email: ");
				message = (String) in.readObject();
				// assign var to message
				Agentemail = message;

				// DEBUG
				Server objectIO = new Server();

				Agent agent = new Agent(this.AgentName, this.AgentID, this.Agentemail);
				objectIO.WriteAgentToFile(agent);
				// Display to client Entered Values
				sendMessage(
						"Details Entered name:" + AgentName + " " + "AgentID:" + AgentID + " " + "email:" + Agentemail);

				// Display Message to client-side
				sendMessage("Successfully Completed");

			}

			// 3 - Allow player Agent to login
			else if (choice == 3) {

				// Send message to client console
				sendMessage("Enter Agent Name ");
				message = (String) in.readObject();
				// assign var to message
				AgentName = message;

				// Send message to client console
				sendMessage("Enter Agent  ID ");
				message = (String) in.readObject();
				// assign var to message
				AgentID = message;

				// Display to client Entered Values
				sendMessage("Details Entered : AgentName:" + AgentName + " " + "AgenTID:" + AgentID);

				// Display Message to client-side
				sendMessage("Successfully Completed");

			}
			// 4 - Club Log In
			else if (choice == 4) {
				// Send message to client console
				sendMessage("Enter Club Name ");
				message = (String) in.readObject();
				// assign var to message
				Clubname = message;

				sendMessage("Enter Club  ID ");
				message = (String) in.readObject();
				clubID = message;

				// Display to client Entered Values
				sendMessage("Details Entered  :  Clubname:" + Clubname + " " + "clubID:" + clubID);

				// Display Message to client-side
				sendMessage("Successfully Completed");
			}
			// 5 - Exit Program and return to menu
			else if (choice == 5) {
				sendMessage("Exiting ...");
				System.out.println("exiting the Program ");

				// Add a new Player
			} else if (choice == 6) {

				// Send message to console
				sendMessage("Enter Playername name ");
				message = (String) in.readObject();
				// assign var to message
				Playername = message;

				// Send message to console
				sendMessage("Enter Clubs Valuation: ");
				message = (String) in.readObject();
				// assign var to message
				Valuation = message;

				// Send message to console
				sendMessage("Enter Clubs PlayerStatus: ");
				message = (String) in.readObject();
				// assign var to message
				PlayerStatus = message;

				// Send message to console
				sendMessage("Enter Clubs Position: ");
				message = (String) in.readObject();
				// assign var to message
				Position = message;

				// DEBUG
				// DEBUG
				Server objectIO = new Server();

				// Create object holding instances entered by client
				Player player = new Player(this.Playername, this.PlayerAge, this.PlayerID, this.AgentID, this.Valuation,
						this.PlayerStatus, this.Position);
				objectIO.WritePlayerToFile(player);

				// Display to client Entered Values
				sendMessage("Details Entered || -Playername:" + Playername + " " + "Player Age:" + PlayerAge + " "
						+ "Player ID:" + PlayerID + " " + "Valuation:" + Valuation + " " + "PlayerStatus:"
						+ PlayerStatus + "" + "Position" + Position);

				// Display Message to client-side
				sendMessage("Successfully Completed");

			}

			// Update player’s valuation
			else if (choice == 7) {
			}

			// Update player’s status
			else if (choice == 8) {

			} else if (choice == 9) {

			}

			// Search for all players in a given position
			else if (choice == 10) {

			}

			// Search for all players for sale in their club
			else if (choice == 11) {

			}

			// Suspend/Resume the sale of a player in their club
			else if (choice == 12) {

			}
			// Purchase a player
			else if (choice == 13) {

			}
			// DEBUG- User enters a value outside of 1-5
			else {
				// DEBUG Message
				sendMessage("Incorrect Choice Please Restart The Program !");
				System.out.println("Incorrect Choice Please Restart The Program");
			}

			// Error handling
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

			// After conversation close socket
			try {
				out.close();
				in.close();
				individualConnection.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
