import java.io.IOException;
import java.util.LinkedList;

public class BenchmarkClient {
	
	private static final int NUM_CLIENTS = 8;

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("Starting benchmark testing");
		
		LinkedList<ClientThread> threads = new LinkedList<ClientThread>();
		
		long startTime = System.currentTimeMillis();
		
		// start NUM_CLIENTS client threads at the same time 
		for(int i = 0; i < NUM_CLIENTS; i++) {
			ClientThread ct = new ClientThread();
			threads.add(ct);
			ct.start();
		}
		
		// wait for each client thread to finish
		for(ClientThread ct : threads) {
			ct.join();
		}
		
		long totalTime = System.currentTimeMillis() - startTime;
		
		System.out.println("Total time to serve " + NUM_CLIENTS + " clients: " + totalTime + "ms");
	}

}
