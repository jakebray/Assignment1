import java.io.IOException;
import java.net.Socket;


public class BenchmarkClient {
	
	static final String HOST = "localhost";
	static final int PORT = 5555;
	
	static final int NUM_Tests = 1000;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Starting benchmark testing");
		
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < NUM_Tests; i++) {
			Socket s = new Socket(HOST, PORT);
			System.out.println("Client is connected to the server");
			new ClientThread(s).start();
		}
		
		long endTime = System.currentTimeMillis();
		
		// wait for threads to finish so that times will be printed after the rest of the output
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total time: " + (endTime - startTime) + "ms");
		System.out.println("Average time per client: " + (double) (endTime - startTime) / NUM_Tests + "ms");
	}

}
