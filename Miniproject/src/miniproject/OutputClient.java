package miniproject;

import java.io.*;
import java.net.*;

public class OutputClient extends Thread {
	private static InetAddress host;
	private static final int PORT = 1234;
	
	private PrintWriter output;
		
	private String outMessage;
	private String[] wordList;

	public void run(){
		
		Socket socket = null;

		try {
			socket = new Socket(host, PORT);
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
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
				if(socket != null) {
					System.out.println("Closing connection ...");
					socket.close();
				}
			}
			catch (IOException ioEx) {
				System.out.println("Unable to disconnect!");
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