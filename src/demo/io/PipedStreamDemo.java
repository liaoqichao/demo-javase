package demo.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo implements IO {
	/**
	 * PipedInputStream PipedOutputStream
	 * 其他的输入和输出流没有直接联系,需要一个byte[] buf = new byte[1024]或字符数组，int len或char ch建立联系
	 * 管道输入流应该链接管道输出流,管道输入流提供管道输出流的所有数据。如果输入流没数据给它read()就会进入阻塞状态.所以建议多线程。
	 * 1个读线程进入阻塞状态,另外一个线程写了后,就有数据可以读,线程回到正常状态
	 */

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
	}
	public void demo1() throws IOException{
		
		PipedOutputStream pos = new PipedOutputStream();
		PipedInputStream pis = new PipedInputStream();//new PipedInputStream(pos);也可以产生联系,不需要用connect
		//两个流暂时没关系
		pis.connect(pos);//产生联系
		
		//建立线程
		Thread t1 = new Thread(new Input(pis));
		Thread t2 = new Thread(new Output(pos));
		t1.start();
		t2.start();
		
		/*
		 * s = hi!,管道来了!
		 * 
		 * 输入流读到了输出流数据
		 */
	}

}
class Input implements Runnable{

	private PipedInputStream in;
	Input(PipedInputStream in){
		this.in = in;
	}
	public void run() {
		try {
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			String s = new String(buf,0,len);
			System.out.println("s = "+s);
		} catch (Exception e) {
			// TODO: handle exception
		} finally{
			if(in!=null)
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}

class Output implements Runnable{
	
	private PipedOutputStream out;
	Output(PipedOutputStream out){
		this.out = out ;
		
	}
	public void run(){
		try {
			Thread.sleep(5000);//输出流sleep5秒,这是输入流没有数据给他输入,进入阻塞状态.所以5秒什么都没反应
			out.write("hi!,管道来了!".getBytes());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
