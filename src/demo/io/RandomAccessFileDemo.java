package demo.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo implements IO {

	/**
	 * RandomAccessFile
	 * 特点：
	 * 1. 既能读又能写
	 * 2. 该对象内部维护了一个byte数组,并通过指针(下标)可以操作数组中的元素.该数组可以延长
	 * 3. 可以通过getFilePointer方法获取指针的位置,和通过seek方法设置指针的位置
	 * 4. 其实就是将字节输入流和字节输出流封装成对象
	 * 
	 * 构造方法
	 * RandomAccessFile(File file,String mode)
	 * RandomAccessFile(String 路径,String mode)
	 * mode 打开文件的访问模式
	 * "r"		只读打开,对对象进行write会抛出IOException
	 * "rw"		可以读可以写,文件不在还会自己创建
	 * "rws"	可以读写,还对文件的内容或元数据的每个更新同步写入到底层设备
	 * "rwd"	可以读写,还对文件的内容的每个更新同步写到底层设备
	 * 元数据：关于数据的数据,例如Properties记录的数据
	 * 
	 * 通常用于多线程写入
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		demo3();
	}
	public void demo1() throws IOException {
		File file = new File("E:\\Eclipse\\IO\\RandomAccessFile\\demo1.txt");
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		raf.write("张三".getBytes());
		raf.writeInt(97);			//   a   3个空格1个a一共4个字节,但是不会只取最低8位
		//raf.write("97".getBytes());//输入97记事本会解析成a
		//raf.write("609".getBytes());//输入609记事本会解析成a,只取其最低8位其他抛弃,最低8位还是97
		//raf.writeInt(609);			//  a   2个空格1个奇葩负号1个a一共4个字节
		raf.write("小强".getBytes());	
		raf.writeInt(99);	
		//实际数字并没有改变97还是97..只是记事本把97解析成a
		raf.close();
	}
	public void demo2() throws IOException{		//读取,随机读取
		/*
		 * 随机访问：想从哪读就从哪读。 通过seek()设置指针
		 * 用随机访问文件一般数据都有规律.不然张三李四都是4个字节，诸葛亮要6个字节就不知道怎么取
		 * 如果名字最多8个汉字16个字节,如果张三4个字节,前面12个字节拿空字节补,年龄4个字节固定.
		 * 这样每个人的姓名+年龄一共20个字节,每次取20个字节就能取1组数据。这样写数据方便读取
		 */
		File file = new File("E:\\Eclipse\\IO\\RandomAccessFile\\demo1.txt");
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		byte[] buf = new byte[4];// 姓名是4个字节  张三  李四。。。
		raf.read(buf);
		String name = new String(buf);
		System.out.println("name = "+name);//name = 张三
		int age  = raf.readInt();
		System.out.println("age = "+age);//age = 97
		//int stringage = raf.readInt();
		//System.out.println("stringage = "+stringage);//stringage = 959919664 字符串"97"对应的整数
		System.out.println("pos : "+raf.getFilePointer());//pos : 8;
		//通过seek设置指针位置,随机读取
		raf.seek(0);
		raf.read(buf);
		String name1 =new String(buf);
		System.out.println("name = "+name1);//name = 张三
		raf.seek(8);//第一组4个字节 张三, 第二组4个字节97  指针指向8,再读就是小强
		raf.read(buf);
		String name2 =new String(buf);
		System.out.println("name = "+name2);//name = 小强

		raf.close();
	}
	public void demo3() throws IOException{		//写入,随机写入
		/*
		 * 如果知道文件大小(400字节)
		 * 可以建立4个线程同时写,T1：0-100,T2:101-200;T3:201-300;T4:301-400
		 */
		File file = new File("E:\\Eclipse\\IO\\RandomAccessFile\\demo1.txt");
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		//随机写入(指定位置写入)
		raf.seek(16);//没有指定位置就会从0角标开始写
		//如果raf.seek(24);的话  第3组8个字节没有数据,记事本会解析成4个空格
		raf.write("王五".getBytes());
		raf.writeInt(102);
		raf.write("赵七".getBytes());
		raf.writeInt(111);
		raf.close();
	}

}
