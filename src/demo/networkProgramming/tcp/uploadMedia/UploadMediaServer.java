package demo.networkProgramming.tcp.uploadMedia;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadMediaServer {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//1.
		@SuppressWarnings("resource")
		ServerSocket ss = new ServerSocket(10006);
		
		while(true){	//实现多线程
			//2.
			Socket s = ss.accept();
//			String ip = s.getInetAddress().getHostAddress();
//			System.out.println(ip+" is connected");
			
			
			new Thread(new UploadTask(s)).start();
			//重复的内容放到UploadTask里面的run方法里面
			
		}
		//去掉while循环和新建线程就是单线程
//		//3.
//		BufferedInputStream in = new BufferedInputStream(s.getInputStream());
//		
//		//4.读取的数据存储到文件当中
//		
//		FileOutputStream fos = new FileOutputStream(
//				"E:\\Eclipse\\IO\\tcp\\Server\\"+ip+"倉木麻衣-SAFEST PLACE.wma");
//		
//		byte[] buf = new byte[1024];
//		int len = 0;
//		while((len = in.read(buf))!= -1){
//			fos.write(buf,0,len);
//		}
//		
//		//5.给客户端返回上传成功信息
//		OutputStream out = s.getOutputStream();
//		out.write("上传成功".getBytes());
//		
//		//6.
//		fos.close();
//		s.close();
//		ss.close();
		
	}

}
