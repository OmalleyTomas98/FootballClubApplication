package ie.gmit.sw;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServerSocket listener;
		int clientid=0;
		try 
		{
			 listener = new ServerSocket(10000,10);
			 
			 while(true)
			 {
				System.out.println("Main thread listening for incoming new connections");
				Socket newconnection = listener.accept();
				
				System.out.println("New connection received and spanning a thread");
				Connecthandler t = new Connecthandler(newconnection, clientid);
				clientid++;
				t.start();
			 }
			
		} 
		
		catch (IOException e) 
		{
			System.out.println("Socket not opened");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


class Connecthandler extends Thread
{

	Socket individualconnection;
	int socketid;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	
	public Connecthandler(Socket s, int i)
	{
		individualconnection = s;
		socketid = i;
	}
	
	public void run()
	{
		
		try 
		{
		
			out = new ObjectOutputStream(individualconnection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(individualconnection.getInputStream());
			System.out.println("Connection"+ socketid+" from IP address "+individualconnection.getInetAddress());
		
		} 
		
		//Commence the conversation with the client......
		
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try 
			{
				out.close();
				in.close();
				individualconnection.close();
			}
			
	
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
