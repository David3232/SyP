package examen;

public class Lanzador {
	
	public static void main(String[] args) throws InterruptedException {
		int nSillas = Integer.parseInt(args[0]);
		Restaurante restaurante = new Restaurante(nSillas);
		Cocina cocina = new Cocina();
		Thread threadCocina = new Thread(cocina);
		threadCocina.start();
		while(true) {
			Cliente cliente = new Cliente(restaurante, cocina);
			Thread threadCliente = new Thread(cliente);
			threadCliente.start();
			Thread.sleep(1750);
		}
	}
}
