package sockets1;

import java.io.File;
import java.io.IOException;

public class LanzadorDeProcesos {

	public static void main(String[] args) {
		ProcessBuilder pb1;
		ProcessBuilder pb2;
		try {
			pb1 = new ProcessBuilder("java", "-cp", "bin", "sockets1.ServidorProcess");
			pb1.redirectError(new File("errorServidor.txt"));
			pb1.redirectOutput(new File("salidaServidor.txt"));

			pb2 = new ProcessBuilder("java", "-cp", "bin", "sockets1.ClienteProcess");
			pb2.redirectError(new File("errorCliente.txt"));
			pb2.redirectOutput(new File("salidaCliente.txt"));
			pb1.start();
			pb2.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
