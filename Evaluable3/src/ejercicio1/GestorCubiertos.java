package ejercicio1;

public class GestorCubiertos {
	
	boolean Cubiertos[];

	// Constructor
	public GestorCubiertos (int n_FILOSOFOS) {
		
		/*
		 * De forma aleatoria asignamos a los cubiertos su estado.
		 * true = libre
		 * false = ocupado
		 */
		this.Cubiertos = new boolean[n_FILOSOFOS];
		
		for (int i = 0; i < n_FILOSOFOS; i++){
			this.Cubiertos[i] = false;
            if (((int)(Math.random() * ((10 - 1) + 1)) + 1) < 5) {
            	this.Cubiertos[i] = true;
            }
		}
	}
	
	/*
	 *  Intentamos obtener los cubiertos y si es asi los marcamos como ocupados.
	 *  
	 *  return boolean.
	 */
	public boolean cogerCubiertos(int pos1, int pos2) {
		if (this.Cubiertos[pos1] == true && this.Cubiertos[pos2] == true) {
			this.Cubiertos[pos1] = false;
			this.Cubiertos[pos2] = false;
			return true;
		}
		return false;
	}
	
	/*
	 * Liberamos los cubiertos indicados por parametros.
	 */
	public void liberarCubiertos(int pos1, int pos2) {
		this.Cubiertos[pos1] = true;
		this.Cubiertos[pos2] = true;
	}
	
}
