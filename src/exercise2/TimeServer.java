package exercise2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Date;
public class TimeServer extends Thread{
	
	DataInputStream input;
	DataOutputStream output;
	
	
	public TimeServer(Socket socket) {
		try {
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Override
	public void run() {
		System.out.println("Server provided services");
		while(true) {
			try {
//				System.out.println(input.readUTF() + "*");
				
				String time = new Date().toString();
				output.writeUTF("Server tra lai ngay gio="+time);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}




	public static void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(7000);
		System.out.println("Server is started");
		while(true) {
			new TimeServer(server.accept()).start();
			System.out.println("Client connected");
			
		}
//			socket.close();
	}
}