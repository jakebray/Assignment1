import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class WorkerThread extends Thread {

	Socket cs;

	public WorkerThread(Socket cs) {
		this.cs = cs;
	}

	@Override
	public void run() {
		try (
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
