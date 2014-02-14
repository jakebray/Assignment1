import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class ClientThread extends Thread {
	
	static final String MESSAGE = "hello";
	
	Socket s;
	
	public ClientThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try (
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out = new PrintStream(s.getOutputStream());
		) {
			out.println(MESSAGE);
			System.out.println("Sent: " + MESSAGE);
			System.out.println("Server sent back: " + in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
