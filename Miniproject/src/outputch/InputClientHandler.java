package outputch;

import java.io.*;
import java.net.*;
import java.util.*;

public class InputClientHandler extends Thread {

	private Socket client;
	private Scanner clientStringFromServer;
	private ObjectOutputStream serverOutputStream;

	public InputClientHandler(Socket socket){
		client = socket;
		try{
			clientStringFromServer = new Scanner(client.getInputStream());
			serverOutputStream = new ObjectOutputStream(client.getOutputStream());
			System.out.println("InputClientHandler started.");
			
		}
		catch(IOException ioEx){
			ioEx.printStackTrace();
		}
	}

	public void run(){
		String inputStreamArray[], sortedInputStreamArray[];
		String rawInputStream, noSpecialInputStream, lowerCaseInputStream;

		do {
			//Catches the string send by the client
			System.out.println("Thread iteration in InputClientHandler");
			rawInputStream = clientStringFromServer.nextLine();
			System.out.println("Line recieved in InputClientHandler");
			noSpecialInputStream = rawInputStream.replaceAll("[\\p{P}\\p{S}]", "");
			lowerCaseInputStream = noSpecialInputStream.toLowerCase();
			inputStreamArray = lowerCaseInputStream.split("[\\W]");
			for (String s:inputStreamArray){
				MultihreadEchoServer.addToGlobalStringList(s);
			}
			sortedInputStreamArray = MultihreadEchoServer.getGlobalStringArray();
			
			try {
				System.out.println("Writing to OutputStream");
				serverOutputStream.writeObject(sortedInputStreamArray);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//Will do so until QUIT is received}
		while(!rawInputStream.equals("QUIT"));
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