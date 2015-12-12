package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

public class InputClient {

	private static InetAddress host;
	private static final int PORT = 1234;
	
	public static void main(String[] args) {
		try{
			host = InetAddress.getLocalHost();
		}
		catch (UnknownHostException uhEx){
			System.out.println("Host ID was not found...");
			System.exit(1);
		}
		accessServer();
	}
	
	private static void accessServer(){
		Socket link = null;
		try{
			link = new Socket(host,PORT);
			Scanner input = new Scanner(link.getInputStream());
			PrintWriter output = new PrintWriter(link.getOutputStream(), true);
			Scanner userEntry = new Scanner(System.in);
			String message;
			
			do{
				System.out.println("Enter Message:");
				message = userEntry.nextLine();
				output.println(message);
				System.out.println("\nMessage: " + message);
			}
			
			while(!message.equals("***CLOSE***"));
		}
		catch(IOException ioEx){
			ioEx.printStackTrace();
		}
		finally{
			try{
				System.out.println("Closing connection...");
				link.close();
			}
			catch(IOException ioEx){
				System.out.println("Unable to close connection...");
				System.exit(1);
			}
		}
	}
}
