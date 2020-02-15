package ejercicio1;

import java.io.*;

public class ProcesosFicheros {

	/**
	 *
	 * @param file file
	 * @return int
	 * @throws IOException e
	 */
	private int sumador(String file) throws IOException {
		int count = 0;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String currLine;
		while((currLine = reader.readLine()) != null) {
			count += Integer.parseInt(currLine);
		}
		reader.close();

		return count;
	}

	/**
	 * @param args file1 file2 output
	 * @throws IOException e
	 * @throws NullPointerException e
	 */
	public static void main(String[] args) throws IOException, NullPointerException {
		ProcesosFicheros sumadorFichero = new ProcesosFicheros();
		String file1 = args[0];
		String file2 = args[1];
		String output = args[2];
		int count = 0;

		count += sumadorFichero.sumador(file1);
		count += sumadorFichero.sumador(file2);

		FileWriter fileWriter = new FileWriter(output);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(count);
		printWriter.close();
		File lockFile = new File("cuentaVocales.lock");
		lockFile.delete();
	}
}