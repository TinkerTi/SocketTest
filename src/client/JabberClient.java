package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import server.JabberServer;

public class JabberClient {
	public static void main(String[] args){
		Socket socket = null;
		try{
			InetAddress addr=InetAddress.getByName(null);
			System.out.println(addr);
			socket=new Socket(addr,JabberServer.PORT);
			System.out.println("socket:"+socket);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			for(int i=0;i<10;i++){
				out.println("hello:"+i);
				String str=in.readLine();
//				System.out.println(str);
			}
			out.println("END");
			out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				System.out.println("closing....");
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
