package miniproject;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler extends Thread {

	private Socket client;
	private Scanner input;
	private PrintWriter output;

	public ClientHandler(Socket socket){
		client = socket;
		try{
			input = new Scanner(client.getInputStream());
			output = new PrintWriter(client.getOutputStream(),true);
			
			
		}
		catch(IOException ioEx){
			ioEx.printStackTrace();
		}
	}

	public void run(){
		String receivedArray[] = new String[10];
		String received,process,result;

			//Catches the string send by the client
			received = input.nextLine();
			process = received.replaceAll("[\\p{P}\\p{S}]", "");
			result = process.toLowerCase();
			receivedArray = result.split("[\\W]");
			for (String s:receivedArray){
				output.println("Echo: " + s);
				System.out.println(s);
			}
			
			//Print out "Echo: (What ever was sent)"

			//Will do so until QUIT is received
		 while(!received.equals("QUIT"));
		try{
			//Trying to close the connection
			if(client!=null){
				System.out.println("Closing connection");
				client.close();
			}
		}
		catch(IOException ioEx){
			System.out.println("Unable to disconnect!");
		}
	}
}