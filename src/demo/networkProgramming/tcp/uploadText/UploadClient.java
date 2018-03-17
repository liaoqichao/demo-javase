package demo.networkProgramming.tcp.uploadText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadClient {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		//1.
		Socket socket = new Socket("192.168.1.104",10005);
		
		//2.
		BufferedReader br = new BufferedReader(new FileReader("E:\\Eclipse\\IO\\tcp\\Client\\upload.txt"));
		
		//3.
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		String line = null;
		while((line = br.readLine())!= null){	//这个循环可以结束,读的是本地文件
			out.println(line);
		}
//		out.println("over");//设置结束标记,在服务器端判断结束标记,跳出循环就可以避免双方等待
//		但是这样文件不能有单独一行over.所以用时间戳
		//告诉服务器端,客户单写完了
		socket.shutdownOutput();
		//4.
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String str = null;
		str = in.readLine();//阻塞式
		System.out.println(str);
		
		br.close();
		socket.close();
	}

}
