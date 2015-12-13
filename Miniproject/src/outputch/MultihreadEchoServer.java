package outputch;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultihreadEchoServer {
	//defining the port and the socket
	private static ServerSocket serverSocket;
	private static final int PORT = 1234;
	private static List<String> globalStringList = new ArrayList<String>();

	
	
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
			
			System.out.println("\nNew client accepted: "+ client.toString() + "\n");
			System.out.println("");
			
			//System.out.println("Before input client: " + input.nextLine());			
			
			
			InputClientHandler handler = new InputClientHandler(client); //THIS IS JUST PLACEHOLDER FOR POTENTIAL CLIENT HANDLING  
			handler.start();
			//System.out.println("After input client: " + input.nextLine());
			
		} 
		//Infinite loop, in order to make the server keep waiting and checking for clients
		while (true); 

	}
	
	public static String[] getGlobalStringArray()
	{
		String[] globalHistogram;
		BinaryTree binaryTree = new BinaryTree(globalStringList);
		globalHistogram = binaryTree.getHistogram();
		
		
		return globalHistogram;
		
	}
	
	public static void addToGlobalStringList(String s)
	{
		globalStringList.add(s);
	}
	

}
