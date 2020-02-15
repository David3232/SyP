package floridaMarket;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Tienda {
	int televisionesStock;
	int portatilesStock;
	int movilesStock;
	
	public static BlockingQueue<Integer> estanteriaTelevisiones;
	public static BlockingQueue<Integer> estanteriaPortatiles;
	public static BlockingQueue<Integer> estanteriaMoviles;
	
	public Tienda(int televisiones, int portatiles, int moviles) throws InterruptedException {
		this.televisionesStock = televisiones;
		this.portatilesStock = portatiles;
		this.movilesStock = moviles;
		
		Tienda.estanteriaTelevisiones = new LinkedBlockingDeque<Integer>();
		Tienda.estanteriaPortatiles = new LinkedBlockingDeque<Integer>();
		Tienda.estanteriaMoviles = new LinkedBlockingDeque<Integer>();
		
		for (int i = 0; i < 10; i++) {
			Tienda.estanteriaTelevisiones.put(i);
			Tienda.estanteriaPortatiles.put(i);
			Tienda.estanteriaMoviles.put(i);
		}
		
		this.hacerTrabajar();
	}
	
	public void hacerTrabajar() throws InterruptedException {

		Reponedor reponedor1 = new Reponedor(televisionesStock, estanteriaTelevisiones);
		Reponedor reponedor2 = new Reponedor(portatilesStock, estanteriaPortatiles);
		Reponedor reponedor3 = new Reponedor(movilesStock, estanteriaMoviles);
		
		
		Thread threadReponedor1 = new Thread(reponedor1);
		Thread threadReponedor2 = new Thread(reponedor2);
		Thread threadReponedor3 = new Thread(reponedor3);
		threadReponedor1.start();
		threadReponedor2.start();
		threadReponedor3.start();
	}
}
