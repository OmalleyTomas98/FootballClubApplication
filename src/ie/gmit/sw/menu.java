package ie.gmit.sw;

import java.util.Scanner;

public class menu {
	// Instantiate client object
	Client client = new Client();
	Scanner sc = new Scanner(System.in);

	// Start the client connection and close it again once the user exits the
	// application
	public void start() {
		// client.open();
		mainmenu();
		// client.close();
	}

	// Display menu to allow user to register or login
	public void mainmenu() {
		int option;

		do {
			do {
				// Command line prompt displaying functions to choose
				System.out.println("=============================================");
				System.out.println("=======FOOTBALL TCP MANAGEMENT SYSTEM========");
				System.out.println("=============================================");

				System.out.println("1) Register Club");
				System.out.println("2) Register Agent");
				System.out.println("3) Player Agent Login");
				System.out.println("4) Club Login");
				System.out.println("5) Exit");

				option = sc.nextInt();
			} while (option < 1 || option > 5);

			switch (option) {
			case 1:
				// Register
				client.registerClub();
				break;
			case 2:
				// Register
				client.registerClub();
				break;

			case 3:
				// Login
				if (client.PlayerAgentlogin()) {
					Agentsubmenu();
				}
				break;
			case 4:
				// Login
				if (client.ClubLogin()) {
					Clubsubmenu();
				}
				break;
			}
		} while (option != 5);
	}

	// Display menu after Agent successfully logs in
	public void Agentsubmenu() {
		int option;

		do {
			do {
				// Command line prompt displaying functions to choose
				System.out.println("-------------------------------");
				System.out.println("++++Welcome to Agent Menu++++++");
				System.out.println("-------------------------------");
				System.out.println("6) Add a new Player");
				System.out.println("7) Update player’s valuation");
				System.out.println("8) Update player’s status");
				System.out.println("9) Logout");
				System.out.println("-------------------------------");

				option = sc.nextInt();
			} while (option < 6 || option > 9);

			switch (option) {
			case 6:
				// Add New a Player
				client.AddNewPlayer();
				break;
			case 7:
				// Update a Players Valuation
				client.updatePlayerValuation();
				break;
			case 8:
				// Update a Players Status
				client.updatePlayerStatus();
				break;

			}
		} while (option != 9);

		// Log client out
		client.logout();
	}

	// Display menu after Club successfully logs in
	public void Clubsubmenu() {
		int option;

		do {
			do {
				// command line prompt displaying functions to choose
				System.out.println("-----------------------------------------------------");
				System.out.println("+++++++++++++Welcome to Club Menu++++++++++++++++++++");
				System.out.println("10) Search for all players in a given position");
				System.out.println("11) Search for all players for sale in their club");
				System.out.println("12) Suspend/Resume the sale of a player in their club");
				System.out.println("13) Purchase a player");
				System.out.println("14) Logout");
				System.out.println("-----------------------------------------------------");

				option = sc.nextInt();
			} while (option < 10 || option > 14);

			switch (option) {
			case 10:
				// Call client obj to Search For All Players In Position
				client.SearchForAllPlayersInPosition();
				break;
			case 11:
				// Call client obj to Search For All Players For Sale
				client.SearchForAllPlayersForSale();
				break;
			case 12:
				// Call client obj to Suspend And Resume Player
				client.SuspendAndResumePlayer();
				break;
			case 13:
				// Call client obj to Purchase A Player
				client.PurchaseAPlayer();
				break;
			}
		} while (option != 14);

		// Log client out
		client.logout();
	}

}