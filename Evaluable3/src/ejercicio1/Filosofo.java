package ejercicio1;

public class Filosofo implements Runnable{

	GestorCubiertos gestor;
	int CubiertoIzq;
	int CubiertoDer;
	
	/*
	 * Bucle infinito.
	 */
	@Override
	public void run() {
		System.out.println("comer");
		 while (true){
			 
             boolean cubiertosObtenidos;
             cubiertosObtenidos = gestor.cogerCubiertos(CubiertoIzq, CubiertoDer);
             if (cubiertosObtenidos){
                     comer();
                     gestor.liberarCubiertos(CubiertoIzq, CubiertoDer);
                     pensar();
             }
     }
	}
	
	public Filosofo(GestorCubiertos gestor, int CubiertoIzq, int CubiertoDer){
        this.CubiertoIzq = CubiertoIzq;
        this.CubiertoDer = CubiertoDer;
        this.gestor = gestor;
	}
	
	public static void comer () {
		try {
			Thread.sleep((int)(Math.random() * ((5000 - 1000) + 1)) + 1000);
			System.out.println("Filósofo" + Thread.currentThread().getName() + " comiendo nyam nyam.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void pensar () {
		try {
			Thread.sleep((int)(Math.random() * ((5000 - 1000) + 1)) + 1000);
			System.out.println("Filósofo" + Thread.currentThread().getName() + " pensando mmh mmh.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
