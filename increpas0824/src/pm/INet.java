package pm;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class INet {
	
	public static void main(String[] args) throws MalformedURLException, UnknownHostException {
		
		URL url = new URL("http://www.increpas.com/index.inc");
		
		String host = url.getHost();
		System.out.println("Host : " + host);
		
		int port = url.getPort();
		System.out.println("Port : " + port);
		System.out.println("=================================");
		
		InetAddress inet = InetAddress.getByName(host);
		String ip = inet.getHostAddress();
		System.out.println("Res 1 : "+host + " : " + ip);
		System.out.println("=================================");
		
		InetAddress[] inets = InetAddress.getAllByName(host);
		for(InetAddress i : inets) {
			String ip2 = i.getHostAddress();
			System.out.println("Res 2 : "+host + " : " + ip);
		}
		
	}

}
