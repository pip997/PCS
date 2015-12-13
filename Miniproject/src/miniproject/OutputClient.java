package miniproject;

import java.io.*;
import java.net.*;

public class OutputClient extends Thread {
	private static Socket link;
	private static ObjectInputStream input;
	private static PrintWriter output;
	private static String outMessage;
	private static String[] wordList;
	
	OutputClient(Socket s){
		link = s;
		try {
			input = new ObjectInputStream(link.getInputStream());
			output = new PrintWriter(System.out, true);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			do {
				
				Object object = input.readObject();
	            wordList =  (String[]) object;
				outMessage = "";
				
				for (int i = 0; i < wordList.length; i++) {
					outMessage = outMessage + wordList[i] + ", ";
				}
				output.println(outMessage);
			}
			
		 while(!link.isClosed());}
			catch(IOException ioEx) {
				System.out.println("I/O error in OutputClient");
				ioEx.printStackTrace();
			}
		catch (ClassNotFoundException cnfEx) {
			output.println("Could not receive word list from server");
		}
		finally {
			try {
				if(link != null) {
					System.out.println("Closing connection ...");
					link.close();
				}
			}
			catch (IOException ioEx) {
				System.out.println("Unable to disconnect!");
				System.exit(1);
			}	
		}
	}

}