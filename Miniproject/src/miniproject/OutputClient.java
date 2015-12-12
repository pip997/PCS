package miniproject;

import java.io.*;
import java.net.*;

public class OutputClient extends Thread {
	private static InetAddress host;
	private static final int PORT = 1234;
	
	private static PrintWriter output;
		
	private static String outMessage;
	private static String[] wordList;
	
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

	public static void accessServer(){
		
		Socket link = null;

		try {
			link = new Socket(host, PORT);
			ObjectInputStream input = new ObjectInputStream(link.getInputStream());
			PrintWriter output = new PrintWriter(link.getOutputStream(), true);
			Object object = input.readObject();
            wordList =  (String[]) object;
			outMessage = "";
			
			for (int i = 0; i < wordList.length; i += 2) {
				outMessage += wordList[i] + " " + wordList[i + 1] + ", ";
			}
			output.println(outMessage);
		}
		catch(IOException ioEx) {
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
		
		
		/*
		outMessage = "";
		String tempWord = wordList.get(0);
		int wordCount = 0;
		
		for (int i = 0; i < wordList.size(); i++) {
			String currentWord = wordList.get(i);
			if (currentWord == tempWord) {
				wordCount++;
			}
			else {
				outMessage += tempWord + " " + wordCount + ", ";
				tempWord = currentWord;
				wordCount = 1;
			}
		}
		outMessage += tempWord + " " + wordCount + ", ";
		*/
	}
}