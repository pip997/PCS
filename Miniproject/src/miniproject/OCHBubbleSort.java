package miniproject;


import java.io.*;
import java.net.*;
import java.util.*;



public class OCHBubbleSort extends Thread{
	private Socket client;
	private Scanner input;
	private PrintWriter output;
	public OCHBubbleSort(Socket socket){
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
		String received;
		do{
			received = input.nextLine();
			output.println("ECHO: " + received);
		}while(!received.equals("QUIT"));
		
		try{
			if(client!=null){
				System.out.println("Closing connection...");
				client.close();
			}
		}
		catch (IOException ioEx){
			System.out.println("\nUnable to disconnect.");
	}
	}
}
