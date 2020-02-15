package examen;

public class Cliente implements Runnable{
	
	Restaurante restaurante;
	Cocina cocina;
	
	public Cliente(Restaurante r, Cocina c) {this.cocina = c; this.restaurante = r;}

	@Override
	public void run() {
		int tipoHamburguesa;
		if(Math.random() < 0.5) {
			tipoHamburguesa = Restaurante.MC_COLESTEROL;
		} else {
			tipoHamburguesa = Restaurante.MC_GRASA;
		}
		try {
			// hacer el pedido (pasar notita a cocina)
			cocina.recibirPedido(tipoHamburguesa);
			// me voy a la cinta a esperar que salga mi hamburguesa
			cocina.recogerPedido(tipoHamburguesa);
			int silla = restaurante.cogerSillaLibre();
			while(silla == -1) {
				Thread.sleep(5);
				silla = restaurante.cogerSillaLibre();
			}
			// comemos hamburguesa
			comer();
			restaurante.liberarSilla(silla);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	private void comer() throws InterruptedException {
		Thread.sleep(1000);
	}
	
}
