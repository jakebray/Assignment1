import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientThread extends Thread {

	static final String MESSAGE = "hello";
	
	static final int NUM_CONNECTIONS = 10;
	
	static final String HOST = "localhost";
	static final int PORT = 5555;

	@Override
	public void run() {
		// make each client connect NUM_CONNECTIONS times
		for(int i = 0; i < NUM_CONNECTIONS; i++) {
			try (
				Socket s = new Socket(HOST, PORT);
				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintStream out = new PrintStream(s.getOutputStream());
			) {
				// send and read MESSAGE multiple times
				for(int j = 0; j < 100; j++) {
					out.println(MESSAGE);
					in.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
