package demo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

public class SequenceStreamDemo implements IO {

	/**
	 * 序列流
	 * 对多个流进行合并
	 * 序列流值负责源(硬盘->内存)输入
	 */
	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();
		//demo3();		
		//demo4();
	}
	public void demo1() throws IOException{
		/*
		 * SequenceInputStream 表示其他输入流的逻辑串联。字节流不一定能合并文本还能合并其他格式文件
		 * 参数只能是2个字节流或字节流的子类   或者 字节流或字节流的子类的枚举
		 * 因为要用枚举所以只能用vector存输入流
		 * 需求：将1.txt,2.txt,3.txt的数据合并到一个文件中
		 */
		Vector<FileInputStream> v = new Vector<FileInputStream>();
		v.add(new FileInputStream("E:\\Eclipse\\IO\\Sequence\\1.txt"));
		v.add(new FileInputStream("E:\\Eclipse\\IO\\Sequence\\2.txt"));
		v.add(new FileInputStream("E:\\Eclipse\\IO\\Sequence\\3.txt"));
		Enumeration<FileInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);//InputStream的子类
		File demo1 = new File("E:\\Eclipse\\IO\\Sequence\\demo1.txt");
		//FileOutputStream fos = new FileOutputStream(demo1);
		BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream(demo1));
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = sis.read(buf))!=-1){
			bos.write(buf, 0, len);
			bos.flush();
		}
		bos.close();
		sis.close();
	}
	public void demo2() throws IOException{
		/*
		 * 需求：将1.txt,2.txt,3.txt的数据合并到一个文件中。
		 * 然而Vector效率低，慎用。所以用ArrayList。 然后用迭代器代替枚举。
		 */
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		for(int i = 1 ; i<=3 ;i++){
			al.add(new FileInputStream("E:\\Eclipse\\IO\\Sequence\\"+i+".txt"));
		}
		Enumeration<FileInputStream> en = Collections.enumeration(al);//下面的注释为原理
		
		SequenceInputStream sis = new SequenceInputStream(en);
		
		BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("E:\\Eclipse\\IO\\Sequence\\demo2.txt"));
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = sis.read(buf)) != -1){
			bw.write(buf, 0, len);
			bw.flush();
		}
		sis.close();
		bw.close();
		//final Iterator<FileInputStream> it = al.iterator();//因为匿名内部类所以要加final
		/*
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>(){//匿名内部类

			@Override
			public boolean hasMoreElements() {
				// TODO Auto-generated method stub
				return it.hasNext();
			}

			@Override
			public FileInputStream nextElement() {
				// TODO Auto-generated method stub
				return it.next();
			}
		};//内部类后面有分号
		*/
	}
	public void demo3() throws IOException{			//文件切割
		File file = new File("E:\\Eclipse\\IO\\Sequence\\倉木麻衣-SAFEST PLACE.wma");
		File dir = new File("E:\\Eclipse\\IO\\Sequence");
		int n = 1;
		splitFile(file , dir, n);
	}
	public void splitFile(File file,File dir,int n) throws IOException {
		//用读取流关联源文件
		BufferedInputStream  bis = new BufferedInputStream(new FileInputStream(file));
		//定义缓冲区大小
		final int SIZE = n*1048576;//1024*1024 = 1MB
		byte[] buf = new byte[SIZE];
		
		//创建目的
		File destdir = new File(dir.getAbsolutePath()+"\\splitFile");//在指定目录下建立文件夹,把分割文件存到文件夹中
		if(!destdir.exists())
			destdir.mkdir();
		//记录配置信息
		FileOutputStream propfos = new FileOutputStream(new File(destdir,"Properties.properties"));
		Properties prop = new Properties();
		prop.setProperty("filename", file.getName());
		//切割
		FileOutputStream fos = null;
		int len;
		int count = 1;
		while((len = bis.read(buf))!= -1){
			//碎片文件被切割后一般不能直接阅读,除了文本。自己定义拓展名
			//可以写死也可以作为函数的参数, new fos(new File(dir,(count++)+".part");
			fos = new FileOutputStream(new File(destdir,"splitFile"+count+".part"));
			prop.setProperty("part"+count, "splitFile"+count+".part");
			count++;
			fos.write(buf, 0, len);
		}
		count --;
		Integer c = Integer.valueOf(count);
		prop.setProperty("partcount",c.toString());
		prop.store(propfos, "save file info");
		propfos.close();
		fos.close();
		bis.close();
	}
	public void demo4() throws IOException{		//被切割文件的合并
		File dir = new File("E:\\Eclipse\\IO\\Sequence\\splitFile");
		mergeFile(dir);
	}
	public void mergeFile(File dir) throws IOException{
		/*
		 * 应该每个功能独立为一个函数
		 * 1.读取配置信息
		 * 2.获取碎片文件,放入list集合中
		 * 3.合并成时序流
		 * 4.写合并后文件
		 */
		//读取配置信息
		File properties = new File(dir,"Properties.properties");
		if(!properties.exists()){
			System.out.println(dir+",该目录下没有配置文件");
			throw new RuntimeException();	//自定义子类异常也可以
		}
		FileReader fr  = new FileReader(properties); 
		Properties prop = new Properties();
		prop.load(fr);
		//
		//File[] files = dir.listFiles();
		List<FileInputStream> list = new ArrayList<FileInputStream>();//类型FileInputStream不是File
		/*
		for(File file : files){
			if(file.getName().endsWith(".part"))//创建过滤器实现filenameFilter也可以
			list.add(new FileInputStream(file));
		}*/
		//获取碎片文件
		int count = Integer.valueOf(prop.getProperty("partcount"));
		//健壮性判断
		File[] parts = dir.listFiles(new SuffixFilter(".part"));//前面写的后缀名过滤器
		if(parts.length!=count){
			System.out.println("碎片文件数目与配置文件信息不匹配,应该是"+count+"个");
			throw new RuntimeException();
		}
		for(int i = 1 ; i<=count;i++){
			list.add(new FileInputStream(new File(dir,prop.getProperty("part"+i))));
		}
		Enumeration<FileInputStream> en = Collections.enumeration(list);//参数列表
		SequenceInputStream sis = new SequenceInputStream(en);//参数枚举
		//创建输出流
		FileOutputStream fos = new FileOutputStream(new File(dir.getParent(),"merge_"+prop.getProperty("filename")));
		byte[] buf = new byte[1024];
		int len = 0;
		while((len = sis.read(buf))!= -1){
			fos.write(buf, 0, len);
		}
		sis.close();
		fos.close();
	}
}
