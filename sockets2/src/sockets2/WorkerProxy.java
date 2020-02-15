package sockets2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class WorkerProxy implements Runnable {

	private Socket conexion;

	public WorkerProxy(Socket c) {
		this.conexion = c;
	}

	@Override
	public void run() {
		try {
			System.out.println("Entra al worker");
			InputStream is = conexion.getInputStream();
			OutputStream os = conexion.getOutputStream();
			InputStreamReader isr = new InputStreamReader(is);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedReader bf = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(osw);
			String lineaPeticion = bf.readLine();
			String destino = lineaPeticion;
			int puertoDestino = 80;
			Socket socket = new Socket();
			InetSocketAddress direccion = new InetSocketAddress(destino, puertoDestino);
			try {
				socket.connect(direccion);
				// si llegamos aquí, la conexión funcionó
				InputStream is1 = socket.getInputStream();
				OutputStream os1 = socket.getOutputStream();
				InputStreamReader isr1 = new InputStreamReader(is1);
				OutputStreamWriter osw1 = new OutputStreamWriter(os1);
				BufferedReader bReader = new BufferedReader(isr1);
				PrintWriter pWriter = new PrintWriter(osw1);
				
				pWriter.println("GET /index.html");
				pWriter.flush();
				String linea;
				while((linea = bReader.readLine())!= null) {
					pw.println(linea);
				}

				pw.flush();
				pWriter.close();
				bReader.close();
				isr1.close();
				osw1.close();
				is1.close();
				os1.close();
				socket.close();
				
			} catch (IOException e) {
				System.out.println("Conexión fallida");
			}
			conexion.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
