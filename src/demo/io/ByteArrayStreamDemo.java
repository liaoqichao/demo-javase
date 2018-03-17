package demo.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo implements IO {

	/**
	 * ByteArrayInputStream	ByteArrayOutputStream
	 * 用来操作源和目的都是内存的类
	 * byte数组长度可变
	 * 可以使用toByteArray,toString 获取数据
	 * 关闭ByteArrayOutpuStream/InputStream无效.关闭后还可以继续使用.因为只在内存操作数据没有调用底层资源(如硬盘的资源),不抛IO异常
	 * 
	 * ByteArrayInputStream(byte[],int off,int len);后面2个参数可以省略.因为源是内存,所以参数是数组不是输入流,文件,路径
	 * 
	 * CharArrayReader		CharArrayWriter和StringReader		StringWriter
	 * 和ByteArrayInputStream	ByteArrayOutputStream一样,就是存储的数组类型不一样
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
	}
	public void demo1() throws IOException{
		byte[] buf = "abcdef".getBytes();
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int ch = 0;
		while((ch = bis.read())!=-1){
			bos.write(ch);
		}
		System.out.println(bos.toString());//abcdef
		
		FileOutputStream fos = new FileOutputStream("E:\\Eclipse\\IO\\ByteArrayStream\\demo1.txt");
		bos.writeTo(fos);
		fos.close();
		//关闭资源无效
		
		
	}

}
