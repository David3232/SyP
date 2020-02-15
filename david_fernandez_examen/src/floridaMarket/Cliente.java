package floridaMarket;

import java.util.concurrent.BlockingQueue;

public class Cliente implements Runnable {
	Tienda tienda;
	
	public Cliente(Tienda t) {this.tienda = t;}

	@Override
	public void run() {
		BlockingQueue<Integer> productoBuscado;
		double productoAleatorio = Math.random();
		
		if(productoAleatorio < 0.33) {
			productoBuscado = Tienda.estanteriaTelevisiones;
		} else if (productoAleatorio < 0.66){
			productoBuscado = Tienda.estanteriaPortatiles;
		} else {
			productoBuscado = Tienda.estanteriaMoviles;
		}
		
		try {
			productoBuscado.take();

			//System.out.println("Cojo producto");
			//System.out.println(productoBuscado);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
