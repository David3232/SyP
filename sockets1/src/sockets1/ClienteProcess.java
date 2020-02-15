package sockets1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClienteProcess {

	public static void main(String[] args) {
		InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
		Socket socket = new Socket();		
		try {
			//socket.setReuseAddress(true);
			socket.connect(direccion);
			InputStreamReader isr = new InputStreamReader(socket.getInputStream());
			BufferedReader bfr = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			List<String> operacion = generarOperacion();
			
			pw.println(operacion.get(0));
			pw.println(operacion.get(1));
			pw.println(operacion.get(2));
			pw.println(";");
			pw.flush();
			String resultado = bfr.readLine();
			System.out.println("El resultado fue:" + resultado);			
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}		
	}
	
	public static List<String> generarOperacion() {
		List<String> operacion = new ArrayList<String>();

        Random rd = new Random();
		operacion.add("" + rd.nextInt(100) + 1);
		
		if (rd.nextInt(100) + 1 <= 50) {
			operacion.add("+");
		} else {
			operacion.add("-");
		}
		

		operacion.add("" + rd.nextInt(100) + 1);
		
		return operacion;
	}

}
