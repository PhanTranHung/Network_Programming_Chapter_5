package exercise3;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Date;
public class TimeServer extends Thread{
	
	Socket socket;
	DataInputStream input;
	DataOutputStream output;
	
	String country = "";
	int GMT = 0;
	
	
	public TimeServer(Socket socket) {
		this.socket = socket;
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
		
		String options = "Select your country\n 1: Ha Noi\n 2: Hai Phong\n 3: Phu Yen";
		try {
			output.writeUTF(options);

			switch (input.readInt()) {
				case 1:
					country = "Ha Noi";
					GMT = 7;
					break;
				case 2:
					country = "Hai Phong";
					GMT = 7;
					break;
				case 3:
					country = "Phu Yen";
					GMT = 7;
					break;
				default:
					break;
			}
			
			while(true) {
				input.readUTF();
//				System.out.println(input.readUTF() + "*");
				String time = new Date().toString();
				output.writeUTF("Server tra lai ngay gio cua " + country + ": " + time);
			}
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
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
	}
}