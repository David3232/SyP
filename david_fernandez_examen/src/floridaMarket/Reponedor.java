package floridaMarket;

import java.util.concurrent.BlockingQueue;

public class Reponedor implements Runnable{
	private BlockingQueue<Integer> estanteria;
	int stockAlmacen;
	
	public Reponedor(int stock, BlockingQueue<Integer> estanteria) throws InterruptedException {
		this.estanteria = estanteria;
		this.stockAlmacen = stock;
	}
	
	public void observarEstanteria() throws InterruptedException  {
		Thread.sleep(100);
	}

	@Override
	public void run() {
		while(true) {
			//System.out.println("Comprobar estanteria");
			if (this.estanteria.size() < 2) {
				try {
					this.llenarEstanteria();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					System.out.println("Estanteria llena");
					this.observarEstanteria();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void llenarEstanteria() throws InterruptedException {
		//System.out.println("Llenar estanteria");
		if (this.stockAlmacen > 0 && this.stockAlmacen < 5) {
			for (int i = 0; i < this.stockAlmacen; i++) {
				this.estanteria.put(i);
			}
			
			this.stockAlmacen = 0;
		} else if (this.stockAlmacen > 0) {
			for (int i = 0; i < 5; i++) {
				this.estanteria.put(i);
			}
			
			this.stockAlmacen = this.stockAlmacen - 5;
		} else {
			//System.out.println("Stock vacio");
		}
		
		Thread.sleep(1000);
	}
}
