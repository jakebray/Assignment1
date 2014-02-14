import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SimpleServer {
	
	static final int PORT = 5555;
	
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server Socket created");
		
		while(true) {
			try (
				Socket cs = ss.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
				PrintStream out = new PrintStream(cs.getOutputStream());
			) {
				String line;
				while((line = in.readLine()) != null) {
					out.println(line.toUpperCase());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
