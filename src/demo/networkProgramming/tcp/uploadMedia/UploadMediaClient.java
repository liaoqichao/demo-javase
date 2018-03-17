package demo.networkProgramming.tcp.uploadMedia;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class UploadMediaClient {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub

		//1.
		Socket socket = new Socket("192.168.1.104",10006);
		
		//2.
		File file = new File("E:\\Eclipse\\IO\\tcp\\Client\\倉木麻衣-SAFEST PLACE.wma");
		BufferedInputStream bis = 
				new BufferedInputStream(new FileInputStream(file));
		
		//3.
		//上传文件名字(后缀)
		
		String filename = file.getName();
		BufferedWriter out1 = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		out1.write(filename);
		out1.flush();
		out1.close();
		
		BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = bis.read(buf))!=-1){
			out.write(buf, 0, len);
			out.flush();	//忘记flush,文件大小就不同啦。
		}
		//告诉服务器端输出(相对于客户端)结束
		socket.shutdownOutput();
		
		//4.
		InputStream in = socket.getInputStream();
		byte[] bufIn = new byte[1024];
		int lenIn = 0;
		while((lenIn = in.read(bufIn))!= -1){
			String text = new String(bufIn,0,lenIn);
			System.out.println(text);
		}
		
		//5.
		bis.close();
		socket.close();
	}

}
