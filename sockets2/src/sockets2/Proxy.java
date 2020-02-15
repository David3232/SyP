package sockets2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Proxy implements Runnable{
private ExecutorService executor = Executors.newFixedThreadPool(10); 
	
	@Override
	public void run() {
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(9877);
			System.out.println("Proxy escuchando.");
		} catch (IOException e) {
			System.out.println("Falló la creación del socket de escucha.");
			return;
		}
		while(true) {
			try {
				Socket conexion = socketEscucha.accept();	
				System.out.println("Conexión recibida!");
				WorkerProxy worker = new WorkerProxy(conexion);
				executor.execute(worker);				
			} catch (Exception e) {
				try {
					socketEscucha.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(e);
			}
		}		
	}
	
	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		servidor.run();
	}
}
