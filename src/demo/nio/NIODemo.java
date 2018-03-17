package demo.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import demo.DemoInterface;

/**
 * NIO
 * @author LQC
 * 2017年5月1日07:25:53
 */
public class NIODemo implements DemoInterface {

	/**
	 * nio是jdk1.4提供的api，有以下特性：
	 * 1. 为所有的原始类型提供(Buffer)缓存支持。
	 * 2. 提供字符集编码解码解决方案。
	 * 3. Channel：一个新的原始I/O抽象。
	 * 4. 支持锁和内存映射文件的文件访问接口。
	 * 5. 提供多路(non-blocking)非阻塞式的高伸缩性网络I/O。
	 * 
	 * NIO将最耗时的IO操作(填充和提取缓冲区)转移回操作系统，因而极大地提高速度。
	 * 原始的IO以流的方式处理，NIO以块的方式处理。
	 */
	
	public void demo() throws Exception {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo5();
//		demo6();
//		demo7();
//		demo8();
//		demo9();
//		demo10();
//		demo11();
	}

	/**
	 * 缓冲区
	 * 1. 缓冲区是一个定义在类里面的基本数据元素数组。Buffer类比简单数组的优点是除了包含数据外还
	 * 		包含了一些信息。
	 * 2. 所有缓冲区都有四个属性：
	 * 		- 容量(Capacity)：缓冲区能够容纳数据元素的最大数量，缓冲区创建时被设定，并且永远不能更改。
	 * 		- 上界(Limit)：缓冲区的第一个不能被读或写的元素，也就是缓冲区中现存元素的计数。
	 * 		- 位置(Position)：下一个要被读或写的元素的索引，位置会自动由相应的get()和put()函数更新。
	 * 		- 标记(Mark)：一个备忘位置。调用mark()来设定mark = position。调用reset()设定position = mark。
	 * 			标记在设定前是未定义的。
	 * 
	 * 缓冲区分类
	 * 1. 字节缓冲区：ByteBuffer
	 * 2. 字符缓冲区：CharBuffer
	 * 3. 双精度浮点型缓冲区：DoubleBuffer
	 * 4. 单精度浮点型缓冲区：FloatBuffer
	 * 5. 整形缓冲区：IntBuffer
	 * 6. 长整形缓冲区：LongBuffer
	 * 7. 短整型缓冲区：ShortBuffer
	 * - 以上类都有存、取方法put、get，这些类都是抽象类，都包含静态工厂方法创建相应实例。
	 * 
	 * Buffer的equals方法
	 * 充要条件：
	 * 1. 2个buffer的对象类型相同
	 * 2. 两个对象都剩余同样数量的元素（Buffer的容量不需要相同，而且缓冲区中剩余数据的索引也不必相同；
	 * 	但每个缓冲区中剩余元素的数目(从位置到上界)必须相同）
	 * 3. 在每个缓冲区中应被get()函数返回的剩余数据元素序列必须一致
	 * 
	 * Buffer的compareTo方法
	 * CompareTo是针对每个缓冲区内剩余数据进行的，与它们在equals()中的方式相同，直到不相等的元素被发现或者到达缓冲区的上界。
	 * 如果一个缓冲区在不相等元素发现前已经被耗尽，较短的缓冲区被认为是小于较长的缓冲区。
	 */
	
	/**
	 * 创建缓冲区实例
	 * @throws Exception
	 */
	public void demo1(){
		/*
		 * 1. 通过allocate方法创建没有数据的缓冲区实例
		 * 2. 通过wrap方法把已有数组放到缓冲区，返回缓冲区实例
		 * 		缓冲区中数据的修改时，原数组的数据也会被修改。
		 */
		
		// 1. 创建没有放数据的实例。分配一个容量为5的char变量CharBuffer
		CharBuffer cb1 = CharBuffer.allocate(5);
		cb1.put('D');
		cb1.put('E');
		System.out.println("limit : "+cb1.limit() +" - capacity : "+cb1.array().length); // 5,5
		for(int i = 0 ; i < cb1.capacity() ; i++ ){
			System.out.print(cb1.array()[i]+" "); // 输出D,E和3个空格
		}
		
		// 2. 把已经有数据的数组放到缓冲区
		char[] charArr = {'A','a','B','b','C','c'};
		CharBuffer cb2 = CharBuffer.wrap(charArr);
		System.out.println(cb2.array().length); // 6
		for(int i = 0 ; i < cb2.capacity() ; i++ ){
			System.out.print(cb2.array()[i]+" ");
		}
		System.out.println();
		
		// 缓冲区中数据修改会影响到原数据
		cb2.put(0, 'Z');
		for (char c : charArr) {
			System.out.print(c+" "); //Z a B b C c
		}
		System.out.println();
		
		// 反转此缓冲区。首先对当前位置设置限制，然后将该位置设置为零。如果已定义了标记，则丢弃该标记。
		// flip()方法的意义：将pos清零，方便后续对缓冲区的操作。
		System.out.println(cb2.position()+" - "+cb2.limit()+" - "+cb2.hasRemaining()); // 0 - 6 - true
//		cb2.flip(); // limit = pos; pos = 0; 将写模式换为读模式
//		cb2.clear(); // pos = 0; 用于写模式
		cb2.rewind();// rewind()在读写模式下都可用，它单纯的将当前位置置0，同时取消mark标记
		System.out.println(cb2.position()+" - "+cb2.limit()+" - "+cb2.hasRemaining()); // 0 - 0 - false
		while(cb2.hasRemaining()){ // position和limit之间是否有元素
			char i = cb2.get();
			System.out.print(i+" ");
		}
	}
	
	
	/**
	 * mark()、reset()。记录当前postion的position和回到记录的postion
	 */
	public void demo2(){
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o'); // 写入hello
		
		buffer.flip(); // 反转
		
		buffer.mark(); // 当前位置是'H'的位置0，记录他
		
		buffer.position(1); // 手动设置当前位置为1.
		
		// 读数据
		while(buffer.hasRemaining()){
			System.out.print(buffer.get()+" ");
		}
		System.out.println();
		
		buffer.reset(); // position回到mark所记录的位置
		
		// 读数据
		while(buffer.hasRemaining()){
			System.out.print(buffer.get()+" ");
		}
		System.out.println();
	}
	
	/**
	 * 压缩
	 *  如果从Buffer中读取了一部分数据之后仍有部分未读的数据，且后续还需要这些数据，但是此时想要先再写些数据，那么使用压缩
	 */
	public void demo3(){
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o'); // 写入hello
		
		buffer.flip();
		
		buffer.position(2); // 从llo开始
		
		buffer.compact(); // 进行压缩，自动反转为写模式
		
		buffer.put((byte)'s'); // 在剩下的后面填充
		
		buffer.flip();
		
		// 读数据
		while(buffer.hasRemaining()){
			System.out.print((char)buffer.get()+" "); // l l o s
		}
		System.out.println();
		
		/*
		 * 压缩前：
		 * 	0	1	2	3	4	5	6	7	8	9
		 *  H	e	l	l	o
		 *  
		 *  压缩后：
		 *  0	1	2	3	4	5	6	7	8	9
		 *  l	l	o
		 *  
		 *  填充：
		 *  0	1	2	3	4	5	6	7	8	9
		 *  l	l	o	s
		 */
	}
	
	/**
	 * 缓冲区复制
	 */
	public void demo4() {
		int[] arr = {1,3,5};
		IntBuffer intBuffer = IntBuffer.wrap(arr);
		for (int i : intBuffer.array()) { // 1, 3, 5
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(intBuffer); // java.nio.HeapIntBuffer[pos=0 lim=3 cap=3]
		
		// 复制缓冲区
		IntBuffer ib = intBuffer.duplicate();
		for (int i : ib.array()) { // 1, 3, 5
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(ib); //java.nio.HeapIntBuffer[pos=0 lim=3 cap=3]
		
		// 修改原缓冲区，复制的缓冲区数据会改变
		intBuffer.put(0, 110);
		for (int i : ib.array()) { // 110, 3, 5
			System.out.print(i+" ");
		}
		System.out.println();
		
		// 修改新缓冲区，原缓冲区数据会改变
		ib.put(1,300);
		for (int i : intBuffer.array()) { // 1, 3, 5
			System.out.print(i+" ");
		}
		System.out.println();
		
	}
	
	/**
	 * 分割缓冲区
	 * slice方法返回切割出来的Charbuffer。分割出来的数据被修改，原缓冲区的数据也被修改。
	 */
	public void demo5() {
		// 准备数据
		CharBuffer buffer = CharBuffer.allocate(8);
		buffer.put("abcdefgh"); // charbuffer可以直接put字符串
		
		// 设置属性
		buffer.position(2).limit(5);
		
		// 分割
		CharBuffer sliceBuffer = buffer.slice();
		
		// 输出
		while(sliceBuffer.hasRemaining()){
			System.out.print(sliceBuffer.get()+" "); // c d e
		}
		System.out.println();
		
		// 切割
		sliceBuffer.put(0,'z');
		
		// 反转
		sliceBuffer.flip();
		
		// 输出
		while(sliceBuffer.hasRemaining()){
			System.out.print(sliceBuffer.get()+" "); // z d e
		}
		System.out.println();
		
		// 原缓冲区数据也被修改
		buffer.position(0).limit(8);
		while(buffer.hasRemaining()){
			System.out.print(buffer.get()+" "); // a b z d e f g h 
		}
		System.out.println();
		
	}
	
	/**
	 * 通道Channel
	 * 通过通道可以用最小的总开销来访问操作系统本身的IO。缓冲区则是通道内部发送或接收数据的端点。
	 * 
	 * Channel是用来连接字节缓冲区和文件/套接字，因此有文件通道、套接字通道：
	 * FileChannel
	 * SokcetChannel
	 * ServerSocketChannel
	 * DatagramChannel
	 * 
	 * Socket通道可以使用Socket通道的工厂创建。但是FileChannel只能通过在一个已打开的
	 * RandomAccessFile、FileInputStream、FileOutputStream的getChannel()方法获取。
	 * 
	 * 通道可能是单向(只实现ReadableByteChannel接口或者只实现WritableByteChannel接口)
	 * 也可能是双向的(两个接口都实现)。
	 * 
	 * 通道可以以阻塞和非阻塞模式运行，非阻塞模式的通道永远不会让调用线程休眠。只有面向流的通道
	 * 才能使用非阻塞模式。
	 * 
	 * 通过调用通道的close方法关闭通道，但是可能会导致关闭底层IO服务时发生阻塞（阻塞、非阻塞都一样）
	 * 通过isOpen方法判断通道是否打开，打开了就可以使用。
	 * 
	 * 文件通道 FileChannel类
	 * 文件通道总是阻塞式的。因为非阻塞的文件IO意义不大，文件IO强大之处在于异步IO，一个进程可以从操作系统
	 * 请求多个IO操作，而不必等待这些操作完成。
	 * FileChannel是线程安全的
	 * 
	 * 
	 */
	
	/**
	 * 文件通道
	 * 使用NIO读取文件
	 * @throws IOException 
	 */
	public void demo6() throws IOException{
		/*
		 * 1. 从FileInputStream中获取Channel
		 * 2. 创建Buffer
		 * 3. 从Channel读数据读到Buffer
		 * 4. 修改buffer的位置，设为0（读使用flip）
		 */
		
		// 1. 获取通道
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/demo/nio/demo3.txt");
		FileChannel channel = fis.getChannel();
		
		// 2. 创建Buffer
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		// 3. 将数据读到Buffer
		channel.read(buffer);
		
		// 4. 把buffer的pos设为0
		buffer.flip();
		
		// 5. 读
		while(buffer.hasRemaining()){
			byte b = buffer.get();
			System.out.print((char)b);
		}
		
		// 6. 关闭fis
		fis.close();
		
		// 输出
//		Hello NIO Demo3 !
//		2017??5??1??09:33:27
	}
	
	/**
	 * 文件通道
	 * 使用NIO读取文件，解决编码问题，使用jdk1.7的Files和Paths
	 * @throws IOException 
	 */
	public void demo7() throws IOException{
		List<String> lines = Files.readAllLines(
				Paths.get(System.getProperty("user.dir")+"/src/demo/nio/demo3.txt"),
				Charset.forName("GBK"));
		lines.forEach((line) -> System.out.println(line));
		
//		Hello NIO Demo3 !
//		2017年5月1日09:33:27
	}
	
	/**
	 * 文件通道
	 * 使用NIO写文件
	 * @throws IOException 
	 */
	public void demo8() throws IOException{
		// 1. 获取要写入的内容
		File file = new File("F:/music/高品质/Safest Place.mp3");
		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		FileChannel inChannel = fis.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		// 2. 创建目标文件
		File output = new File("C:/Users/13670/Desktop",file.getName());
		if(!output.exists()){
			output.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(output);
		FileChannel outChannel = fos.getChannel();
		
		// 3. 传输
		while(inChannel.read(buffer) != -1){
			buffer.clear(); // 开始写模式（position = 0，limit = capacity）
			outChannel.write(buffer);
			buffer.flip(); // 转写为读（limit = posistion， position = 0）
//			buffer.flip();
		}
		
		// 4. 关闭资源
		inChannel.close();
		outChannel.close();
		fis.close();
		fos.close();
	}
	
	/**
	 * Channel-to-Channel传输
	 * @throws IOException 
	 */
	public void demo9() throws IOException {
		// 1. 获取要写入的内容
		File file = new File("F:/music/高品质/Safest Place.mp3");
		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		FileChannel fromChannel = fis.getChannel();
		
		// 2. 创建目标文件
		File output = new File("C:/Users/13670/Desktop",file.getName());
		if(!output.exists()){
			output.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(output);
		FileChannel toChannel = fos.getChannel();
		
		// 3. transferTo或transferFrom
		/*
		 * transferTo(pos,length,targetChannel);
		 * pos：inChannel开始读的位置
		 * count：inChannel读的长度
		 * 如果pos + count的值大于fromChannel的size,会传输到fromChannel的结束位置
		 */
		fromChannel.transferTo(0, fromChannel.size(), toChannel);
		
		fis.close();
		fos.close();
	}
	
	/**
	 * 文件截取
	 * @throws IOException 
	 */
	public void demo10() throws IOException{
		RandomAccessFile file = new RandomAccessFile("demo10.txt","rw");//"r", "rw", "rws", or "rwd"
		FileChannel channel = file.getChannel();
		
		// 截取文件前40byte
		channel.truncate(10);
		
		ByteBuffer buffer = ByteBuffer.allocate(10);
		channel.read(buffer);
		
		channel.close();
		file.close();
	}
	
	/**
	 * 文件追加写.不能用FileOutputStream，只能使用RandomAccessFile
	 * @throws IOException 
	 */
	public void demo11() throws IOException{
		File file = new File(System.getProperty("user.dir")+"/src/demo/nio/demo3.txt");
		
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		FileChannel channel = raf.getChannel();
		
		// 追加内容
		String line = "\r\ndemo10!!";
		
		// 把channel的position最后，即可追加写入
		channel.position(channel.size());
		
		// 创建Buffer存数据 
		ByteBuffer buffer = ByteBuffer.wrap(line.getBytes("GBK"));
		
		// 把buffer数据写到文件
		channel.write(buffer);
		
		channel.close();
		raf.close();
		
	}
	
	
	/**
	 * ServerSocketChannel
	 * ServerSocketChannelDemo
	 * @throws Exception
	 */
	public void demo12() throws Exception{
		
	}
	
	/**
	 * SocketChannel  
	 * SocketChannelDemo
	 * @throws Exception
	 */
	public void demo13() throws Exception{
	}
	
	/**
	 * DatagramChennel
	 * DatagramChennelDemo
	 * @throws Exception
	 */
	public void demo14() throws Exception{
		
	}
	
}

