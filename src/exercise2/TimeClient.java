package exercise2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class TimeClient {
	public static void main(String[] args) throws Exception
	{
		Socket socket = new Socket("localhost", 7000);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		
		
		while(true) {
			dout.writeUTF("aaa");
			String time = din.readUTF();
			System.out.println(time);
			Thread.sleep(1000);
		}
	}	
}