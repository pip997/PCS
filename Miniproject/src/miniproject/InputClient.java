package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

public class InputClient extends Thread{

	private static Socket server;
	private Scanner userEntry;
	private PrintWriter output;
	
	InputClient(Socket socket)
	{
		try {
			server = socket;
			userEntry = new Scanner(System.in);
		
			output = new PrintWriter(server.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run()
	{
		String message;
		
		do{
			System.out.println("Enter Message:");
			message = userEntry.nextLine();
			System.out.println("Sending message...");
			
			output.println(message);
			System.out.println("Message sent: " + message);
			//System.out.println("\nMessage: " + message);
		}
		while(!message.equals("***CLOSE***"));
		
		try{
			System.out.println("Closing connection...");
			server.close();
		}
		catch(IOException ioEx){
			System.out.println("Unable to close connection...");
			System.exit(1);
		}
			
		
	}
}
