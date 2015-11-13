package markisbeautifuldad;

import java.net.*;
import java.io.*;
import java.util.*;

public class TCPEchoServer {
	private static String allChars = "0123456789abcdefghijklmnopqrstuvwxyzæøå";
	private static int count[] = new int[allChars.length()];
	private static ServerSocket serverSocket;
	private static final int PORT = 1239;

	public static void main(String[] args) {
		System.out.println("Opening port ... \n");
		Arrays.fill(count, 0);				

		try {
			serverSocket = new ServerSocket(PORT);
		}
		catch (IOException ioEx)
		{
			System.out.println("Unable to attach to socket");
			System.exit(1);
		}
		
		do {
			handleClient();
		} while (true);

	}

	private static void handleClient() {
		Socket link = null;
		try {
			link = serverSocket.accept();
			Scanner input = new Scanner (link.getInputStream());
			PrintWriter output = new PrintWriter(link.getOutputStream(), true);			
			String message = input.nextLine();
			
			while(!message.equals("***CLOSE***"))
			{
				message = message.toLowerCase();
				String outMessage = countMessage(message);
				
				output.println(outMessage);
				message = input.nextLine();
			}
			
		}
		catch (IOException ioEx)
		{
			ioEx.printStackTrace();
		}
		finally {
			try {
				System.out.println("\nClosing connection ...");
				link.close();
			}
			catch (IOException ioEx) {
				System.out.println("Unable to disconnect!");
				System.exit(1);
			}
		}
		
	}
	
	private static String countMessage(String message) {
		message = message.toLowerCase();
		String outMessage = "";
		
		for (int i = 0; i < allChars.length(); i++) {
			int charCount = countChars(message, allChars.charAt(i));
			count[i] += charCount;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				outMessage = outMessage + allChars.charAt(i) + count[i] + ", ";
			}
			else {
				continue;
			}
		}
		return outMessage;
	}
	
	private static int countChars(String message, char ch) {
		int count = 0;
		int i;
		int length = message.length();
		char string[] = message.toCharArray();
		
		for (i = 0; i < length; i++)
		{
			if (string[i] == ch)
			{
				count++;
			}
		}
	
		return count;
	}

}
