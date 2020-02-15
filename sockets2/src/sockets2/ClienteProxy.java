package sockets2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteProxy implements Runnable{

	@Override
	public void run() {
		System.out.println("Entra al cliente");
		InetSocketAddress direccion = new InetSocketAddress("localhost", 9877);
		Socket socket = new Socket();
		try {
			socket.setReuseAddress(true);
			socket.connect(direccion);
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader bfr = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println("www.google.es");
			pw.flush();
			String linea;
			while((linea = bfr.readLine())!= null) {
				System.out.println(linea);
			}
			bfr.close();
			pw.close();
			isr.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		Cliente cliente	= new Cliente();
		cliente.run();
	}
}
