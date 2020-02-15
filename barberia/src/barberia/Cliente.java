package barberia;

public class Cliente implements Runnable {
	Barberia barberia;
	public boolean afeitado = false;
	
	public Cliente (Barberia b) {barberia = b;}
	
	@Override
	public void run() {
		int indiceSilla = barberia.CogerSillaLibre(this);
		if(indiceSilla != -1) {
			System.out.print("Cojo silla");
			while(!afeitado) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			barberia.LiberarSilla(indiceSilla);
			System.out.print("Ya estoy afeitado, me voy.");
		} else {
			System.out.print("No consigo coger silla");
		}
			
		
	}

}
