package lecture07;

import java.net.*;

public class MyLocalIP {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address.toString());
		}
		catch (UnknownHostException uhEx){
			System.out.println("Could not find local address");
		}

	}

}
