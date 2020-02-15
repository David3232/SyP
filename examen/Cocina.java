package examen;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Cocina implements Runnable{
	private BlockingQueue<Integer> colaPedidos;
	private BlockingQueue<Integer> colaMcGrasa;
	private BlockingQueue<Integer> colaMcColesterol;
		
	public Cocina() {
		colaPedidos = new LinkedBlockingDeque<Integer>();
		colaMcGrasa = new LinkedBlockingDeque<Integer>();
		colaMcColesterol = new LinkedBlockingDeque<Integer>();
	}
	
	public void recibirPedido(int tipoHamburguesa) throws InterruptedException {
		this.colaPedidos.put(tipoHamburguesa);
	}

	@Override
	public void run() {
		while(true) {
			try {
				int pedidoACocinar = this.colaPedidos.take();
				this.cocinarPedido(pedidoACocinar);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
	}
	
	private void cocinarPedido(int tipoHamburguesa) throws InterruptedException {
		if(tipoHamburguesa == Restaurante.MC_COLESTEROL) {
			Thread.sleep(1000);
			this.colaMcColesterol.put(tipoHamburguesa);
		} else {
			Thread.sleep(500);			
			this.colaMcGrasa.put(tipoHamburguesa);
		}		
	}
	
	public int recogerPedido(int tipoHamburguesa) throws InterruptedException {
		if(tipoHamburguesa == Restaurante.MC_COLESTEROL) {
			return this.colaMcColesterol.take();
		}
		return this.colaMcGrasa.take();
	}

}
