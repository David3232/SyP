package sockets2;

public class ClienteServidorProxy {

	public static void main(String[] args) throws InterruptedException {
		Proxy proxy = new Proxy();
		Thread threadProxy = new Thread(proxy);
		threadProxy.start();
		while(true) {
			ClienteProxy cliente1 = new ClienteProxy();
			Thread threadCliente1 = new Thread(cliente1);
			threadCliente1.start();
			ClienteProxy cliente2 = new ClienteProxy();
			Thread threadCliente2 = new Thread(cliente2);
			threadCliente2.start();
			ClienteProxy cliente3 = new ClienteProxy();
			Thread threadCliente3 = new Thread(cliente3);
			threadCliente3.start();
			ClienteProxy cliente4 = new ClienteProxy();
			Thread threadCliente4 = new Thread(cliente4);
			threadCliente4.start();
			ClienteProxy cliente5 = new ClienteProxy();
			Thread threadCliente5 = new Thread(cliente5);
			threadCliente5.start();
			ClienteProxy cliente6 = new ClienteProxy();
			Thread threadCliente6 = new Thread(cliente6);
			threadCliente6.start();
			ClienteProxy cliente7 = new ClienteProxy();
			Thread threadCliente7 = new Thread(cliente7);
			threadCliente7.start();
			ClienteProxy cliente8 = new ClienteProxy();
			Thread threadCliente8 = new Thread(cliente8);
			threadCliente8.start();
			ClienteProxy cliente9 = new ClienteProxy();
			Thread threadCliente9 = new Thread(cliente9);
			threadCliente9.start();
			ClienteProxy cliente10 = new ClienteProxy();
			Thread threadCliente10 = new Thread(cliente10);
			threadCliente10.start();
			ClienteProxy cliente11 = new ClienteProxy();
			Thread threadCliente11 = new Thread(cliente11);
			threadCliente11.start();
			ClienteProxy cliente12 = new ClienteProxy();
			Thread threadCliente12 = new Thread(cliente12);
			threadCliente12.start();
			ClienteProxy cliente13 = new ClienteProxy();
			Thread threadCliente13 = new Thread(cliente13);
			threadCliente13.start();
			ClienteProxy cliente14 = new ClienteProxy();
			Thread threadCliente14 = new Thread(cliente14);
			threadCliente14.start();
			ClienteProxy cliente15 = new ClienteProxy();
			Thread threadCliente15 = new Thread(cliente15);
			threadCliente15.start();
			
			threadCliente1.join();
			threadCliente2.join();
			threadCliente3.join();
			threadCliente4.join();
			threadCliente5.join();
			threadCliente6.join();
			threadCliente7.join();
			threadCliente8.join();
			threadCliente9.join();
			threadCliente10.join();
			threadCliente11.join();
			threadCliente12.join();
			threadCliente13.join();
			threadCliente14.join();
			threadCliente15.join();
			System.out.println("Acaban los 15 hilos");
			Thread.sleep(1000);
		}
	}

}
