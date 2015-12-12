package miniproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;

public class OutputClient extends Thread {
	private static InetAddress host;
	private static final int PORT = 1234;
	private String outMessage;
	private List<String> wordList;
	
	

	public void run(){
		
		Socket socket = null;
		try {
			socket = new Socket(host, PORT);
			Scanner input = new Scanner(socket.getInputStream());
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
		}
		catch(IOException ioEx) {
			ioEx.printStackTrace();
		}
		
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
	}
}