package barberia;

public class Barbero implements Runnable {
	Barberia barberia;
	public Barbero (Barberia b) {barberia = b;}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			Silla sillaAtendida = barberia.AtenderClientes();
			if (sillaAtendida != null) {
				System.out.print("Vamos a afeitar");
				try {
					afeitar(sillaAtendida);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					descansar();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void afeitar(Silla silla) throws InterruptedException {
		Thread.sleep((long) (Math.random() * 1000));
		silla.cliente.afeitado = true;
	}
	
	private void descansar() throws InterruptedException {
		Thread.sleep((long) (Math.random() * 2000));
	}
	

}
