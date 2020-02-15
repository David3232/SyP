package floridaMarket;

public class LanzadorTienda {
	public static void main(String[] args) throws InterruptedException {
		int nTelevisores = Integer.parseInt(args[0]);
		int nPortatiles = Integer.parseInt(args[1]);
		int nMoviles = Integer.parseInt(args[2]);
		Tienda tienda = new Tienda(nTelevisores, nPortatiles, nMoviles);
		
		while(true) {
			Cliente cliente = new Cliente(tienda);
			Thread threadCliente = new Thread(cliente);
			threadCliente.start();
			Thread.sleep(200);
			//System.out.println("Ha llegado un cliente");
		}
	}
}
