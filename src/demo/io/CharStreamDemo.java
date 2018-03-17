package demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class CharStreamDemo implements IO {

	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	/**
	 * 
	 */
	@Override
	public void demo() throws Exception {			
		// TODO Auto-generated method stub
		/*
		 * 输入(读)：硬盘、打印机->内存
		 * 输出(写)：内存->硬盘、打印机
		 * 字节流：能处理字节的流对象。以字节为单位的二进制传输。能处理所有数据。字节流处理单元为1个字节， 操作字节和字节数组
		 * 字符流：字符流处理的单元为2个字节的Unicode字符，分别操作字符、字符数组或字符串。简单地说：字节流+编码表
		 * 
		 * 字节流的抽象基类(顶层父类)：InputStream、OutputStream
		 * 字符流的抽象基类(顶层父类)：Reader(输入流)、Writer(输出流).如果处理文字数据,优先考虑字符流
		 * 
		 */
		//demo1_CharStream();
		//demo2_CharStream();
		//demo3_CharStream();		//以字符为单位一次读取多个字符(字符数组)
		//demo4_CharStream();		//以字符为单位一次读取一个字符
		//以字节为单位一次读取一个字节
		//以字节为单位一次读取多个字节
		//demo5_CharStream();		//文件复制,就是读写过程
		//demo6_CharStream();		//BufferedWriter
		//demo7_CharStream();		//BufferedReader
		//demo8_CharStream();		//缓冲区文件复制
		//demo9_CharStream();		//字符流缓冲区,装饰设计模式	
	}


	public void demo1_CharStream()  {			//控制台的输入输出
		// TODO Auto-generated method stub
		int  a ,total ,counta = 0 ,countb = 0;
		Scanner in =new Scanner(System.in);
		System.out.println("请输入学生总数： ");
		total =in.nextInt();
		for(int i=0;i<total;i++){
			System.out.println("请输入第"+(i+1)+"个学生的成绩");
			if(in.hasNextInt()){	//
				a = in.nextInt();	//要在hasNextInt()里面，不然 第一个成绩要输入两个整数才会到输入第二个学生的成绩
				if(a>=60 && a<=100)
					counta++;
				else if(a>=0 && a<60)
					countb++;
				else{
					System.out.println("输入错误"); break;}
			}	
		}
		System.out.println("及格人数"+counta+"人");
		System.out.println("不及格人数"+countb+"人");
		in.close();
		
	}
	public void demo2_CharStream()  {			//写入的换行和续写和IO异常处理
	
		//硬盘的数据的基本体现是文件：文件输出流FileWriter：java.lang.io->Writer->OutputStreamWriter->FileWriter
		FileWriter writer = null;
		try {
			 writer = new FileWriter("E:\\Eclipse\\IO\\CharStream\\CharStream\\demo2.txt",true);
			//没有则创建/在Input.txt里面输入数据						//  Windows中"/r/n"换行
			writer.write("续写"+System.getProperty("line.separator"));
			for(int i = 0 ; i<3;i++){
				writer.write("abcdef准备换行"+System.getProperty("line.separator")+"换行完毕"+System.getProperty("line.separator"));
				writer.flush();
			}
		} catch (IOException e) {
			System.out.println("写入出现异常");
		}finally{
			if(writer != null)				//不然会有空指针异常
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("流关闭异常");
				}
		}

		/*
		 * 调用write(String str)方法时其实是写入到临时存储缓冲区中。
		 * flush();进行刷新直接将数据写入到目的地中，相当于txt里面的保存。没有flush和close的话，相当于写了之后没有保存
		 * close()相当于关闭记事本的时候提示是否要保存,然后选择保存。关闭记事本后就不能再记事本写
		 */
		
	}
	public void demo3_CharStream() throws IOException	{			//以字符为单位一次读取多个字符
		
		//java.lang.io->Reader->InputStreamReader->FileReader
		FileReader fr = new FileReader("E:\\Eclipse\\IO\\CharStream\\demo3.txt");//文件要已存在，不然会抛出文件找不到异常
		char[] buf = new char[7];//数组长度要1024的整数倍
		int len = 0;
		while((len=fr.read(buf))!=-1){
			System.out.print(new String(buf,0,len));//不要println,读换行符
		}
		fr.close();
	}
	public void demo4_CharStream() throws IOException {				//以字符为单位一次读取一个字符
		
		FileReader fr = new FileReader("E:\\Eclipse\\IO\\CharStream\\demo4.txt");
		char c;							//临时字符
		int len = 0;					//获取字符对应的ASCII码,并且用来判断文件时候读完
		while((len = fr.read())!= -1 ){
			c = (char)len;
			System.out.print(c);
		}
		fr.close();
		
	}
	public void demo5_CharStream() throws IOException{
		
		FileReader fr = new FileReader("E:\\Eclipse\\IO\\CharStream\\demo5_Read.txt");//名字别写错 .[文件和数据流关联]
		FileWriter fw = new FileWriter("E:\\Eclipse\\IO\\CharStream\\demo5_Write.txt");//[文件和数据流关联，暂时这2个流没有关系]
		//一次读取多个字符
		
		char[] buf = new char[1024];//[联系2个流的中转站(两个流和中转站还没关联)]
		//定义一个变量记录读取到的字符数,(其实就是往数组里面装的字符个数)
		int len = 0;
		while((len=fr.read(buf))!=-1){		//read(char [])返回读取到的字符数，如果读完返回-1。[fr流和中转站建立联系]
			fw.write(new String(buf,0,len));//[fw流和中转站建立联系]
		}
		//一次读取一个字符
		/*
		int len = 0;
		while((len=fr.read())!=-1){
			char c = (char)len;	//[char c 和 int len 联系2个流的中转站]
			fw.write(c);
		}
		*/
		fr.close();
		fw.close();
		//复制完后删除原文件则为剪切,粘贴
		//File file = new File("E:\\Eclipse\\IO\\CharStream\\demo5_CharStreamRead.txt");
		//file.delete();
	}
	public void demo6_CharStream() throws IOException{				//BufferedWriter
		/*
		 * //字符流的缓冲区,就是前面的char[] buf或int len;	
		 * BufferedReader、BufferedWriter   Buffered 记住有ed 作用：提高效率
		 * 缓冲区要结合流才可以使用
		 * 缓冲区实际例子：超市的手推车 . 买N件商品,拿1个去结账1次。买N件商品,暂时放在手推车,一起拿去结账.
		 * 缓冲区优化实际例子：手推车的框可以拿出来,不用1件1件拿出来结账(这样服务员读rfid都比从手推车拿东西出来快)。
		 * 优化：设计优化（重构代码,让代码具有拓展性和复用性,通常加入设计模式来完成代码的构建）、性能优化（最常见手段之一：缓冲区）
		 * 
		 * 没有被缓冲的流就没有缓冲区域
		 */
		
		FileWriter fw = new FileWriter("E:\\Eclipse\\IO\\CharStream\\demo6.txt");
		//为了提高效率,使用BufferedWriter
		//创建缓冲区,并和被缓冲的fw流相关联
		BufferedWriter bw = new BufferedWriter(fw);//下面就只用缓冲区的对象
		//使用缓冲区的写入方法
		bw.write("abcdef"+LINE_SEPARATOR+"GGGG");
		bw.newLine();
		bw.flush();
		
		bw.write("abcdef");
		bw.newLine();//调用System.getPorperty("line.separator");
		bw.write("GGGGGG");
		//使用缓冲区的flush方法,将数据写入到fw中
		//bw.flush();
		//关闭缓冲区,其实是调用fw.close()。因为bw只有提高效率作用,读写还是用fw对象
		bw.close();
	}
	public void demo7_CharStream() throws IOException{				//BufferedReader
		
		//read(),read(ch[],int off,int len)重写了,read(ch[])没有重写,但是都是空都返回-1
		//read()和read(ch[],int off,int len)是从缓冲区(内存)读不是从原文件(硬盘)读
		
		FileReader fr = new FileReader("E:\\Eclipse\\IO\\CharStream\\demo7.txt");
		BufferedReader br = new BufferedReader(fr);
		//一次读一行
		
		String str = null;
		while((str = br.readLine())!=null){
			System.out.println(str);//readLine()只判断回车,不读回车,所以这里要println
		}
	
		//一次读全部
		/*
		char[] cbuf = new char[1024];
		int len = 0;
		while((len = br.read(cbuf, 0, cbuf.length))!=-1){
		//因为br.read(cbuf)这个方法没用重写,读的是原文件的数据不是缓冲区的数据,所以用这个方法读缓冲区的数据提高效率
			System.out.print(new String(cbuf,0,len));
		}
		*/
		br.close();
		
	}
	public void demo8_CharStream() throws IOException{				//缓冲区文件复制
		
		FileReader fr = new FileReader("E:\\Eclipse\\IO\\CharStream\\demo8_Read.txt");
		FileWriter fw = new FileWriter("E:\\Eclipse\\IO\\CharStream\\demo8_Write.txt");
		BufferedReader br = new BufferedReader(fr);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String sbuf = null;
		while((sbuf = br.readLine())!=null){	//用readLine()的话,写完一行一定要newLine()换行
			bw.write(sbuf);
			bw.newLine();
			bw.flush();
		}
		//整个字符数组读
		/*
		char[] cbuf = new char[1024];
		int len = 0;
		while((len = br.read(cbuf, 0, cbuf.length))!=-1){
			bw.write(new String(cbuf,0,len));
			bw.flush();
		}*/
		//不用len, while(br.read(cbuf,0,cbuf.length)!=-1){bw.write(cbuf);bw.flush();}也可以,为什么 要用len?
		br.close();
		bw.close();
	}
	public void demo9_CharStream()	{			//装饰设计模式
		
		/*
		 * 装饰设计模式：对一组对象的功能进行增强时,就可以使用装饰设计模式解决问题
		 * BufferedReader和BufferWriter使用了装饰设计模式
		 * 装饰模式和继承都能实现功能拓展和增强.
		 * 			Writer
		 * 				|-TextWriter
		 * 					|-BufferedTextWriter
		 * 				|- MediaWriter
		 * 					|-BufferedMediaWriter
		 * 如果只为了增强一点功能就进行继承,导致集成体系臃肿
		 * 如果那像上面一样继承,不如把Buffer单独封装成一个类,需要哪种Writer就和哪种Writer关联
		 * class BufferedWriter extends Writer{//高效写也是写,所以继承写
		 * 		BufferedWriter(Writer w){} Writer和它的子类都能作为参数
		 * }
		 * 体系变成这样：想用就用，不想用就不用,不用产生关系(一旦产生关系就能脱离关系)
		 * 			Writer
		 * 				|-TextWriter
		 * 				|- MediaWriter
		 * 				|-BufferedWriter
		 * 特点：装饰类和被装饰类都所属于同一个接口或者父类,装饰类和被装饰类通常所属于同一体系中
		 * 
		 * 接口：一件事,但是方法不确定,而实现它的类知道用什么方法做这件事.或者一个新来的类,要实现这个功能,可以实现这个接口,用自己的方法做出这件事。
		 * 		总的来说,做这件事的方法不确定,但实现了这个接口就意味着这个类可以完成这件事(从上而下)
		 * 		接口是一种角色。少年是学生，也是父母的孩子。少年实现学生，孩子接口。而不是少年继承学生，孩子
		 * 		Writer：
		 * 继承：子类不断提取相同点。方便向上转型,消除差异
		 * 		写文本,写媒体,在缓冲区写的相同点都是写,所以继承了写
		 * 装饰设计模式：功能的增强但本质不变
		 * 
		 */
		Person p = new Person("张三",15);
		p.chifan();//吃饭
		NewPerson np = new NewPerson(p);//外观改变用np对象,实质没变(调用p对象的方法,然后加一些修饰)
		np.chifan();//开胃酒,吃饭,甜点
		
	}
}
