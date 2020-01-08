package ie.gmit.sw;

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
			listener = new ServerSocket(10000, 10);

			while (true) {
				System.out.println("main thread listening for incoming connections");
				Socket newConnection = listener.accept();

				System.out.println("new connection received and spanning a thread");
				// ConnectionHandler t = new ConnectionHandler(newConnection, clientid);
				clientid++;

				Thread t = new Thread(new ConnectionHandler(newConnection, clientid));
				t.start();

			}
		} catch (IOException e) {
			System.out.println("socket not opened");
			e.printStackTrace();
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

	// Constructor
	public ConnectionHandler(Socket individualConnection, int socketId) {
		this.individualConnection = individualConnection;
		this.socketId = socketId;
	}

	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("client> " + msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {

			out = new ObjectOutputStream(individualConnection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(individualConnection.getInputStream());
			System.out.println("connection" + socketId + "from ip: " + individualConnection.getInetAddress());

			Clubname = "";
			clubID = "";
			email = "";
			funds = "";
			choice = 0;
			AgentName = "";
			AgentID = "";
			Agentemail = "";

			sendMessage("Press 1(register Club) Press 2 (register Agent) Press 3 (Player Login) Press 4 Club Login ");
			message = (String) in.readObject();
			choice += Integer.parseInt(message);

			// 1 - Registers a Club
			if (choice == 1) {

				sendMessage("Enter name ");
				message = (String) in.readObject();
				Clubname = message;

				sendMessage("enter clubID: ");
				message = (String) in.readObject();
				clubID = message;

				sendMessage("Enter Email: ");
				message = (String) in.readObject();
				email = message;

				sendMessage("Enter Funds: ");
				message = (String) in.readObject();
				funds = message;

				sendMessage("Details Entered || -name:" + Clubname + " " + "clubID:" + clubID + " " + "email:" + email
						+ " " + "funds:" + funds);

				sendMessage("Successfully Completed");

				// 2 - Allows Agent to Login
			} else if (choice == 2) {

				sendMessage("Enter Agent Name ");
				message = (String) in.readObject();
				AgentName = message;

				sendMessage("enter 	Agent ID: ");
				message = (String) in.readObject();
				AgentID = message;

				sendMessage("Enter Email: ");
				message = (String) in.readObject();
				Agentemail = message;

				sendMessage("Details Entered || -name:" + AgentName + " " + "clubID:" + AgentID + " " + "email:"
						+ Agentemail);

				sendMessage("Successfully Completed");

			}

			// 3 - Club Log in
			else if (choice == 3) {
				
				sendMessage("Enter Agent Name ");
				message = (String) in.readObject();
				AgentName = message;

				sendMessage("Enter Agent  ID ");
				message = (String) in.readObject();
				Agentemail = message;

				sendMessage("Details Entered || -AgentName:" + AgentName + " " + "AgenID:" + AgentID);

				sendMessage("Successfully Completed");

			}
			// 4 - Player Agent Log In
			else if (choice == 4) {
				sendMessage("Enter Club Name ");
				message = (String) in.readObject();
				AgentName = message;

				sendMessage("Enter Club  ID ");
				message = (String) in.readObject();
				Agentemail = message;

				sendMessage("Details Entered || -Clubname:" + Clubname + " " + "clubID:" + clubID);

				sendMessage("Successfully Completed");

			}

			else if (choice == 5) {
				sendMessage("Exiting ...");
				System.out.println("exiting the Program ");

			}

			else {
				sendMessage("Incorrect Choice Try again !");
				System.out.println("Incorrect Choice  Try again");
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

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
