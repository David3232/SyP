package examen;

public class Restaurante {
	boolean[] sillas;
	
	public static int MC_COLESTEROL = 0;
	public static int MC_GRASA = 1;
	public Restaurante(int n_sillas) {
		this.sillas = new boolean[n_sillas];
		for(int i = 0; i < n_sillas; i++) {
			this.sillas[i] = true;
		}
	}
	
	public synchronized int cogerSillaLibre() {
		for(int i = 0; i < sillas.length; i++) {
			if(sillas[i]) {
				System.out.println("Silla " + i + " libre");
				sillas[i] = false;				
				return i;
			}
		}
		System.out.println("No hay sillas libres");
		return -1;
	}
	
	public synchronized void liberarSilla(int i) {
		sillas[i] = true;
	}
}
