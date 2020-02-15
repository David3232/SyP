package sockets1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServidorThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Arrancado el servidor");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha = new ServerSocket(9876);
		} catch (IOException e) {
			System.out.println("No se pudo poner un socket " + "a escuchar en TCP 9876");
			return;
		}		
		while (true) {
			try {
				Socket conexion = socketEscucha.accept();
				System.out.println("Conexion recibida!");
				InputStream is = conexion.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader bf = new BufferedReader(isr);
				String peticion = bf.readLine();
				
				// Metodo que pasandole el Buffer Reader nos devuelve el primer numero, punto 2.
				int primerNumero = getFirstNumber(peticion);
				
				System.out.println("Primer numero: " + primerNumero);
				List<String> respuestas = new ArrayList<String>();
				while(!peticion.contentEquals(";")) {				
					System.out.println("Peticion recibida en servidor: " + peticion);
					respuestas.add(peticion);
					peticion = bf.readLine();
				}
				
				int resultado = getResult(respuestas);
				OutputStream os = conexion.getOutputStream();
				PrintWriter pw = new PrintWriter(os);
				pw.write("He recibido tu peticion. El resultado a sido: " + resultado + "\n");
				pw.flush();
				conexion.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}		
	}
	
	public int getFirstNumber(String num) throws NumberFormatException, IOException {
		int primerNumero = Integer.parseInt(num);

		System.out.println("primerNumero en el metodo: " + primerNumero);
		return primerNumero;
	}
	
	public int getResult(List<String> respuestas) {
		int pNum = Integer.parseInt(respuestas.get(0));
		String operando = respuestas.get(1);
		int sNum = Integer.parseInt(respuestas.get(2));
		int res;
		
		if (operando.equals("+")) {
			res =  pNum + sNum;
		} else {
			res =  pNum - sNum;
		}
		
		return res;
	}
}
