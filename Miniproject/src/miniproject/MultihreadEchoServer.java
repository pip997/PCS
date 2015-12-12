package miniproject;

import java.io.*;
import java.net.*;

public class MultihreadEchoServer {
	//defining the port and the socket
	private static ServerSocket serverSocket;
	private static final int PORT = 1234;
	
	
	//The main function is from the get-go able to throw IOException
	public static void main(String[] args) throws IOException{
		//Trying to connect with port
		try{
			serverSocket = new ServerSocket (PORT);
		}
		//If connection with port is not established, 
		//an IOException thrown from the main function and caught here.
		//The console then prints and the program shuts down.
		catch(IOException ioEx){
			System.out.println("\nCannot set up port!");
			System.exit(1);
		}
		//If connection with port is established, the system accepts the socket and the console prints
		do{
			Socket client = serverSocket.accept();
			System.out.println("\nNew client accepted.\n");
			
			ClientHandler handler = new ClientHandler(client); //THIS IS JUST PLACEHOLDER FOR POTENTIAL CLIENT HANDLING  
			handler.start();
		} 
		//Infinite loop, in order to make the server keep waiting and checking for clients
		while (true); 

	}

}
