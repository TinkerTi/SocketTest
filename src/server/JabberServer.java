package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class JabberServer {
	public static final int PORT=8080;
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket=new ServerSocket(PORT);
		Socket socket=null;
		try {
			
			System.out.println("Started:"+serverSocket);
			socket=serverSocket.accept();
			try{
				System.out.println("connection accepted"+socket);
				BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
				BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/tiankui/Downloads/BrowserDownload/log.txt")));
				while(true){
					String str=in.readLine();
					if(str.equals("END")){
						break;
					}
					System.out.println("echo:"+str);
					out.write(str);
					printWriter.println(str);
				}
				out.flush();
				out.close();
			}finally{
			
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}catch(Exception e){
			
		}finally{	
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
		}
	}
}
