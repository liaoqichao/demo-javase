package demo.networkProgramming.tcp.uploadText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadServer {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1.
		ServerSocket ss = new ServerSocket(10005);
		
		//2.
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+" is connected");
		
		//3.
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\Eclipse\\IO\\tcp\\Server\\upload.txt"));
		String line = null;
		while((line = bufIn.readLine())!= null){	//双方等待,这个循环结束不了。(阻塞是方法缺少结束标记)
//			虽然读完数据,但是socket流不知道结束的标识,所以bufIn.readLine()在等待(阻塞式)，
//			读完后读到-1,但是没有写出去(写"上传成功"出去),所以客户端in.readLine()在等待
//			导致客户端和服务器端双方都在等待对方
//			if(line.equals("over"))	//接收到客户端发送过来的结束标记,满足则结束
//				break;
			bw.write(line);
			bw.newLine();
			bw.flush();//这里不刷新,双方等待,Server\\upload.txt也有数据,但最多8K(缓冲区大小默认8K)，满8K就刷新一次,第二次没满8K就没刷新
		}
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("上传成功");
		
		bw.close();
		s.close();
		ss.close();
	}

}
