package demo.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamDemo implements IO {

	/**
	 * DataInpuStream 和 DataOutputStream 都是装饰类 ,强化基本数据类型读写的功能
	 * 操作基本数据类型的流对象
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
	}
	public void demo1() throws IOException{
		File file = new File("E:\\Eclipse\\IO\\DataStream\\demo1.txt");
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeInt(97);
		dos.writeInt(609);
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		byte[] buf = new byte[4];
		int len = dis.readInt();//97
		int len1 = dis.read(buf);//4
		System.out.println("len = "+len+" ,len1 = "+len1);
		dis.close();
	}
	public void demo2() throws IOException{
		File file = new File("E:\\Eclipse\\IO\\DataStream\\demo2.txt");
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
		dos.writeUTF("喵了个咪");// 喵了个咪  空格和♀是UTF编码的表头   UTF修改版  只能用DataInputStream来读取
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		String s = dis.readUTF();
		System.out.println("s = "+s);
		dis.close();
	}

}
