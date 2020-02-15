package ejercicio1;

import java.io.File;
import java.io.IOException;

public class LanzadorProcesosVocales {
	
	// método para lanzar cuenta vocales
	public void lanzarCuentaVocales (String file) {
		ProcessBuilder pb;
		try {
			pb = new ProcessBuilder("java", "-cp", "bin", "ejercicio1.CuentaVocales" ,file);
			pb.redirectOutput(new File("salida_cuenta_vocales.txt"));
			pb.redirectError(new File("error_cuenta_vocales.txt"));
			pb.start();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ejercicio2(String file) throws IOException, InterruptedException {
		File file1 = new File("cuentaVocales.lock");
		file1.createNewFile();
		
		this.lanzarCuentaVocales(file);

		while(file1.isFile()) {
			System.out.println("Esperando a que terminen los procesos");
			Thread.sleep(200);
		}
		System.out.println("Procesos terminados.");			
				
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		LanzadorProcesosVocales l = new LanzadorProcesosVocales();
		l.ejercicio2("texto.txt");
	}
}