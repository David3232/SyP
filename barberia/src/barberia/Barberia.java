package barberia;

public class Barberia {
	Silla[] sillas;
	
	public Barberia(int numSillas) {
		sillas = new Silla[numSillas];
		
		for (int i = 0; i < numSillas; i++) {
			sillas[i] = new Silla();
		}
	}
	
	public synchronized int CogerSillaLibre(Cliente cliente) {
		for (int i = 0; i < sillas.length; i++) {
			if(!sillas[i].ocupada) {
				sillas[i].ocupada = true;
				sillas[i].cliente = cliente;
				return i;
			}
		} 
		
		return -1;
		
	}
	
	public synchronized Silla AtenderClientes() {
		for (int i = 0; i < sillas.length; i++) {
			if(sillas[i].ocupada && !sillas[i].atendida) {
				sillas[i].atendida = true;
				return sillas[i];
			}
		} 
		
		return null;
		
	}
	
	public synchronized void LiberarSilla(int i) {
		
		sillas[i].atendida = false;
		sillas[i].cliente = null;
		sillas[i].ocupada = false;
		
	}
}