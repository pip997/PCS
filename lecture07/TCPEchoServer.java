package lecture07;
import java.net.*;
import java.io.*;
import java.util.*;

public class TCPEchoServer {
	private static String string = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅabcdefghijklmnopqrstuvwxyzæøå";
	private static int count[] = new int[string.length()];
	private static ServerSocket serverSocket;
	private static final int PORT = 1239;

	public static void main(String[] args) {
		System.out.println("Opening port .. \n");
		try {
			serverSocket = new ServerSocket(PORT);
		}
		catch (IOException ioEx)
		{
			System.out.println("Unable to attach to bla");
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
			
			int numMessages = 0;
			
			String message = input.nextLine();
			
			while(!message.equals("***CLOSE***"))
			{
				System.out.println("Message received.");
				numMessages++;
				int messageLength = message.length();
				String newMessage = "";
				int charcount = 0;
				//String[] newMessage = null;
				for (int i = 0; i < messageLength; i++)
				{
					if (charcount < 2)
					{
					charcount = countChars(message, message.charAt(i)); //This loops through the whole message and counts for the char at string[i]
					newMessage += "" + message.charAt(i) + charcount + ", ";
					}
					
					//newMessage[i] = "" + message.charAt(i) + charcount + ", ";
				}
				/*String finalMessage = "";
				for (int i = 0; i < newMessage.length; i++) {
					finalMessage += newMessage[i];
				}*/
				output.println("Message " + numMessages + ": " + newMessage);
				message = input.nextLine();
			}
			output.println(numMessages + " messages received");
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
	
	private static int countChars(String message, char ch) 
	{
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
