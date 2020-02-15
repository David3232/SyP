package ejercicio1;

public class Main {
	
		// Contructor
        public static void main(String[] args) {
                int N_FILOSOFOS = 80;
                Filosofo filosofos[] = new Filosofo[N_FILOSOFOS];
                GestorCubiertos gestor;
                gestor = new GestorCubiertos(N_FILOSOFOS);
                Thread hilos[] = new Thread[N_FILOSOFOS];
                for (int i = 1; i < N_FILOSOFOS; i++){
                        filosofos[i] = new Filosofo(gestor, i, i - 1);
                        hilos[i] = new Thread(filosofos[i]);
                        hilos[i].start();
                }
        }
}
