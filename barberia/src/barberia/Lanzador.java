package barberia;

public class Lanzador {
	final static int N_BARBERO = 5;
	final static int N_SILLAS = 6; 
	public static void main(String[] args) throws InterruptedException {
		Barberia barberia = new Barberia(N_SILLAS);
		Thread[] hilosBarberos = new Thread[N_BARBERO];
		for (int i = 0; i < N_BARBERO; i++) {
			Barbero barbero = new Barbero(barberia);
			Thread hilo = new Thread(barbero);
			hilosBarberos[i] = hilo;
			hilo.start();
		} 
		
		while(true) {
			Cliente cliente = new Cliente(barberia);
			Thread threadCliente = new Thread(cliente);
			threadCliente.start();
			Thread.sleep(1000);
		}
	}
}
