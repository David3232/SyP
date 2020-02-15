package examen;

import java.io.IOException;

public class Cadena {
	
	public static void launch(String nSillas) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "examen.Lanzador", nSillas);		
		pb.start();
	}

	public static void main(String[] args) throws IOException {
		int nRestaurantes = Integer.parseInt(args[0]);
		String nSillas = args[1];
		for(int i = 0; i < nRestaurantes; i++) {
			launch(nSillas);
		}				
	}
}
