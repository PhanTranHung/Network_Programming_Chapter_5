package exercise3;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TimeClient {
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		Socket socket = new Socket("localhost", 7000);
		DataInputStream din = new DataInputStream(socket.getInputStream());
		DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
		
		System.out.println(din.readUTF());
		dout.writeInt(sc.nextInt());
		
		while(true) {
			dout.writeUTF("get time");
			String time = din.readUTF();
			System.out.println(time);
			Thread.sleep(1000);
		}
	}	
}