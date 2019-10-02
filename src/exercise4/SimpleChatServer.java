package exercise4;

import java.io.*;
import java.util.*;
import java.net.*;
/*Chuong trinh chat don gian
Server nhan message tu Client
*/
public class SimpleChatServer {
	public static void main(String[] args) throws Exception
	{
		ServerSocket server = new ServerSocket(7000);
		System.out.println("Server is started");
		Socket socket = server.accept();
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream din = new DataInputStream(socket.getInputStream());
		//nhap chuoi de gui den client
		Scanner kb = new Scanner(System.in);
		while(true) {
			//nhan du lieu tu client
			String st = din.readUTF();
			System.out.println(st);
			System.out.print("Server: ");
			String msg=kb.nextLine();
			
			dos.writeUTF("Server: "+msg);
			dos.flush();
			kb=kb.reset();
		}
		//socket.close();
	}
}