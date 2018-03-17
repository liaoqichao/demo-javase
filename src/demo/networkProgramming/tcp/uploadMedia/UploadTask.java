package demo.networkProgramming.tcp.uploadMedia;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class UploadTask implements Runnable {

	private Socket socket;
	public UploadTask(Socket socket){
		this.socket = socket;	
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		String ip = socket.getInetAddress().getHostAddress();//得到ip
		System.out.println(ip+" is connected");
		try{
			int count = 0;
			//3.
			//获取文件名(后缀)
			BufferedReader in1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String filename = in1.readLine();
			System.out.println(filename);
			
			BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
			
			//4.读取的数据存储到文件当中
			File dir = new File("E:\\Eclipse\\IO\\tcp\\Server");
			if(!dir.exists()){
				dir.mkdir();
			}
			File file = new File(dir,ip+filename);
			while(file.exists()){
				file = new File(dir,ip+"("+(count++)+")"+filename);
			}
			FileOutputStream fos = new FileOutputStream(file);
			
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = in.read(buf))!= -1){
				fos.write(buf,0,len);
			}
			
			//5.给客户端返回上传成功信息
			OutputStream out = socket.getOutputStream();
			out.write("上传成功".getBytes());
			
			//6.
			fos.close();
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("多线程异常");
		}
	}

}
