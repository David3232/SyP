package ejercicio2;

public class animal implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		// Creamos objetos que implementan la interfaz runnable
		animal Liebre = new animal();
		animal Tortuga = new animal();
		animal Guepardo = new animal();
		
		// Creamos hilos y les asignamos un objeto que implemente la interfaz Runnable
		Thread hilo1 = new Thread(Liebre);
		Thread hilo2 = new Thread(Tortuga);
		Thread hilo3 = new Thread(Guepardo);
		
		// Damos nombre a los hilos
		hilo1.setName("Liebre");
		hilo2.setName("Tortuga");
		hilo3.setName("Guepardo");
		
		hilo1.setPriority(5);
		hilo2.setPriority(1);
		hilo3.setPriority(10);
		
		// Arrancamos los hilos
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		// Podemos esperar a que acaben los otros hilos
		hilo1.join();
		hilo2.join();
		hilo3.join();	

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String nombreAnimal = Thread.currentThread().getName();
		
		for(int i = 0; i < 5; i++) {
			System.out.println(nombreAnimal + " estoy en etapa " + i);
			if (nombreAnimal == "Tortuga") {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (nombreAnimal == "Liebre") {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
			
		System.out.println("Soy " + nombreAnimal + " acabo las etapas.");
	}
}
