package ejercicio1;

import java.io.*;

public class CuentaVocales {

	/**
	 *
	 * Recorremos la linea en busca de en este caso, las vocales
	 *
	 * @param string String
	 * 
	 * 
	 * return count = Total de vocales localizadas.
	 */
	private int contador(String string) {
		
		int count = 0;

		for(int i = 0; i < string.length(); i++) {
			if ((Character.toLowerCase(string.charAt(i))=='a') || (Character.toLowerCase(string.charAt(i))=='e') || (Character.toLowerCase(string.charAt(i))=='i') || (Character.toLowerCase(string.charAt(i))=='o') || (Character.toLowerCase(string.charAt(i))=='u')){
				count++;
			}
		}
		return count;
	}

	/**
	 * @throws IOException e
	 */
	public static void main(String[] args) throws IOException {
		CuentaVocales cuentaVocales = new CuentaVocales();
		int count = 0;

		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		String currentLine = "";
		while((currentLine = reader.readLine()) != null) {
			count += cuentaVocales.contador(currentLine);
		}
		reader.close();

		FileWriter fileWriter = new FileWriter("salida_cuenta_vocales.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(count);
		printWriter.close();
		File lockFile = new File("cuentaVocales.lock");
		lockFile.delete();
		
		
	}
}