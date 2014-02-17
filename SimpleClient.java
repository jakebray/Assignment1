import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;


public class SimpleClient {
	
	static final String HOST = "localhost";
	static final int PORT = 5555;
	static final String MESSAGE = "hello";
	
	public static void main(String[] args) {
		try (
			Socket s = new Socket(HOST, PORT);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out = new PrintStream(s.getOutputStream());
		) {
			out.println(MESSAGE);
			System.out.println(in.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
