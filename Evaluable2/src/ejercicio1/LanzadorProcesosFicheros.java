package ejercicio1;

import java.io.*;

public class LanzadorProcesosFicheros {

	private void lanzarProcesosFicheros(String file1, String file2, String output) {
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", "-cp", "bin", "ejercicio1.ProcesosFicheros", file1 ,file2, output);
			pb.redirectError(new File("error_procesos_ficheros.txt"));
			pb.redirectOutput(new File("salida_procesos_ficheros.txt"));
			pb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ejercicio3() throws InterruptedException, IOException {
		File file1 = new File("cuentaVocales.lock");
		file1.createNewFile();

		this.lanzarProcesosFicheros("ficheroEntrada1.txt", "ficheroEntrada2.txt", "ficheroSalida.txt");

		while(file1.isFile()) {
			System.out.println("Esperando a que terminen los procesos");
			Thread.sleep(200);
		}
		System.out.println("Procesos terminados.");
	}

	/**
	 * @param args null
	 * @throws InterruptedException e
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		LanzadorProcesosFicheros l = new LanzadorProcesosFicheros();
		l.ejercicio3();
	}
}