package generalServerCodeMT;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InputClient {

	private static InetAddress host;
	private static final int PORT = 1234;
	
	public static void main(String[] args) {
		try{
			host = InetAddress.getLocalHost();
		}
		catch (UnknownHostException uhEx){
			System.out.println("Host ID was not found...");
			System.exit(-1);
		}
		accessServer();
	}
	
	private static void accessServer(){
		Socket link = null;
		try{
			link = new Socket(host,PORT);
			Scanner input = new Scanner(link.getInputStream());
			PrintWriter output = new PrintWriter(link.getOutputStream());
			Scanner userEntry = new Scanner(System.in);
			String message, process, result;
			
			do{
				System.out.println("Enter Message:");
				message = userEntry.nextLine();
				process = message.replaceAll("[\\p{P}\\p{S}]", "");
				result = process.toLowerCase();
				System.out.println("\nMessage: " + result);
			}
			
			while(!message.equals("***CLOSE***"));
		}
		catch(IOException ioEx){
			ioEx.printStackTrace();
		}
		finally{
			try{
				System.out.println("Closing connection...");
				link.close();
			}
			catch(IOException ioEx){
				System.out.println("Unable to close connection...");
				System.exit(-1);
			}
		}
	}
}
