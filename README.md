# FootballClubApplication

        2019 Operating Systems Multi-Threaded TCP Server Report 


Project Description : To write a Multi-threaded TCP Server Application, which allows multiple users to be registered, login and trade football players using Microsoft Azure as the host for your Server Machine 

Program Features : Functions for the client applications:  

Register with the System 
Log in to the player transfer system from the client Application to the server application.The log in is based on the clubs or the agents name and id .
Once logged in the agent can - Add a player , - Update the players valuation , - Update the player status .
Once logged in the club can   - Search for all players in a given position , - Search for all players for sale in their club , - Suspend/Resume the sale of a player in their club , - Purchase a player

Server
The server was provided by Azure with an IP address of 40.68.35.156 and an inbound + outbound 
Rule set for port 10000 for  TCP. After some difficulty I got the cloud server to work correctly.The server successfully speaks back and fourth with clients.Azure login 


(Azure) Server Package ;
Ie.gmit.sw
-Server.java
-Club.java
-Agent.java
-Player.java

(Local) Client  Package ;
ie.gmit.sw
-Client.java
-Runner.java
-Menu.java

The server is successfully Connecting and accommodating multiple Users 




++++++++++++++++++++++++++++++++++++++++++++++++++++++++++




User Interface : The  client application is accessed through the command line and the client is greeted with an opening menu (shown on the right) The menu lists all the main 5 features and can exit at this point by entering 5 .

The Main menu shown is stored in Menu.java in my client Side Application and called  from a Runner class in the program named Runner.java .


The program menu is controlled by the class menu.java which acts as a bridge for the client and the server to communicate.Once the user have entered their information it will be displayed in the client screen 

Club Registering
Through the command 
Line Interface

Club is prompted and
Requested for their information 


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


 
After the club is Registered its details are sent to a file named Clubs.txt

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


Agent Registering
Through the command 
Line Interface

Agent is prompted and
Requested for their information 

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


After the Agent is Registered its details are sent to a file named Agents.txt
I had difficulty storing the object in the txt file and a I was returned memory addressed as well as my input as shown


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


Login Menus

Agent login Menu: The agent can 
login after entering
their details I couldn’t get the
validation to work 
but the client is sent to the Agent menu and only
has the privileges of an agent and not a club. The menus are found in menu.java

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

The Agent can add a player with the attributes of their preference.The Player is outputted to a textFile named Player.txt and is then loaded when needed.

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Club login Menu: The Club can 
login after entering
their details I couldn’t get the
validation to work 
but the client is sent to the Club menu and only
has the privileges of an club and not an agent .


The menus are found in menu.java and are nested inside of a do while loop as there is guaranteed to be at least one input Whether its logout or add player. The menus functions are  held by a
Switch case and when the case it hit the function is called in client.

Server Messaging 
I had the same issue which I had with the agents file.
Output in Players.txt


