package sockets2;

public class ClienteServidor {

	public static void main(String[] args) throws InterruptedException {
		Servidor servidor = new Servidor();
		Thread threadServidor = new Thread(servidor);
		threadServidor.start();
		int contCliente = 0;
		while(true) {
			Cliente cliente = new Cliente();
			Thread threadCliente = new Thread(cliente);
			threadCliente.setName("" + contCliente);
			threadCliente.start();
			contCliente++;
			Cliente cliente2 = new Cliente();
			Thread threadCliente2 = new Thread(cliente2);
			threadCliente2.setName("" + contCliente);
			threadCliente2.start();
			
			threadCliente.join();
			threadCliente2.join();
			System.out.println("Acaban los dos hilos");
			Thread.sleep(1000);
			contCliente++;
		}
	}

}
