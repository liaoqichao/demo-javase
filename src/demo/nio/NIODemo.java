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
 * 2017��5��1��07:25:53
 */
public class NIODemo implements DemoInterface {

	/**
	 * nio��jdk1.4�ṩ��api�����������ԣ�
	 * 1. Ϊ���е�ԭʼ�����ṩ(Buffer)����֧�֡�
	 * 2. �ṩ�ַ������������������
	 * 3. Channel��һ���µ�ԭʼI/O����
	 * 4. ֧�������ڴ�ӳ���ļ����ļ����ʽӿڡ�
	 * 5. �ṩ��·(non-blocking)������ʽ�ĸ�����������I/O��
	 * 
	 * NIO�����ʱ��IO����(������ȡ������)ת�ƻز���ϵͳ��������������ٶȡ�
	 * ԭʼ��IO�����ķ�ʽ����NIO�Կ�ķ�ʽ����
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
	 * ������
	 * 1. ��������һ��������������Ļ�������Ԫ�����顣Buffer��ȼ�������ŵ��ǳ��˰��������⻹
	 * 		������һЩ��Ϣ��
	 * 2. ���л����������ĸ����ԣ�
	 * 		- ����(Capacity)���������ܹ���������Ԫ�ص��������������������ʱ���趨��������Զ���ܸ��ġ�
	 * 		- �Ͻ�(Limit)���������ĵ�һ�����ܱ�����д��Ԫ�أ�Ҳ���ǻ��������ִ�Ԫ�صļ�����
	 * 		- λ��(Position)����һ��Ҫ������д��Ԫ�ص�������λ�û��Զ�����Ӧ��get()��put()�������¡�
	 * 		- ���(Mark)��һ������λ�á�����mark()���趨mark = position������reset()�趨position = mark��
	 * 			������趨ǰ��δ����ġ�
	 * 
	 * ����������
	 * 1. �ֽڻ�������ByteBuffer
	 * 2. �ַ���������CharBuffer
	 * 3. ˫���ȸ����ͻ�������DoubleBuffer
	 * 4. �����ȸ����ͻ�������FloatBuffer
	 * 5. ���λ�������IntBuffer
	 * 6. �����λ�������LongBuffer
	 * 7. �����ͻ�������ShortBuffer
	 * - �����඼�д桢ȡ����put��get����Щ�඼�ǳ����࣬��������̬��������������Ӧʵ����
	 * 
	 * Buffer��equals����
	 * ��Ҫ������
	 * 1. 2��buffer�Ķ���������ͬ
	 * 2. ��������ʣ��ͬ��������Ԫ�أ�Buffer����������Ҫ��ͬ�����һ�������ʣ�����ݵ�����Ҳ������ͬ��
	 * 	��ÿ����������ʣ��Ԫ�ص���Ŀ(��λ�õ��Ͻ�)������ͬ��
	 * 3. ��ÿ����������Ӧ��get()�������ص�ʣ������Ԫ�����б���һ��
	 * 
	 * Buffer��compareTo����
	 * CompareTo�����ÿ����������ʣ�����ݽ��еģ���������equals()�еķ�ʽ��ͬ��ֱ������ȵ�Ԫ�ر����ֻ��ߵ��ﻺ�������Ͻ硣
	 * ���һ���������ڲ����Ԫ�ط���ǰ�Ѿ����ľ����϶̵Ļ���������Ϊ��С�ڽϳ��Ļ�������
	 */
	
	/**
	 * ����������ʵ��
	 * @throws Exception
	 */
	public void demo1(){
		/*
		 * 1. ͨ��allocate��������û�����ݵĻ�����ʵ��
		 * 2. ͨ��wrap��������������ŵ������������ػ�����ʵ��
		 * 		�����������ݵ��޸�ʱ��ԭ���������Ҳ�ᱻ�޸ġ�
		 */
		
		// 1. ����û�з����ݵ�ʵ��������һ������Ϊ5��char����CharBuffer
		CharBuffer cb1 = CharBuffer.allocate(5);
		cb1.put('D');
		cb1.put('E');
		System.out.println("limit : "+cb1.limit() +" - capacity : "+cb1.array().length); // 5,5
		for(int i = 0 ; i < cb1.capacity() ; i++ ){
			System.out.print(cb1.array()[i]+" "); // ���D,E��3���ո�
		}
		
		// 2. ���Ѿ������ݵ�����ŵ�������
		char[] charArr = {'A','a','B','b','C','c'};
		CharBuffer cb2 = CharBuffer.wrap(charArr);
		System.out.println(cb2.array().length); // 6
		for(int i = 0 ; i < cb2.capacity() ; i++ ){
			System.out.print(cb2.array()[i]+" ");
		}
		System.out.println();
		
		// �������������޸Ļ�Ӱ�쵽ԭ����
		cb2.put(0, 'Z');
		for (char c : charArr) {
			System.out.print(c+" "); //Z a B b C c
		}
		System.out.println();
		
		// ��ת�˻����������ȶԵ�ǰλ���������ƣ�Ȼ�󽫸�λ������Ϊ�㡣����Ѷ����˱�ǣ������ñ�ǡ�
		// flip()���������壺��pos���㣬��������Ի������Ĳ�����
		System.out.println(cb2.position()+" - "+cb2.limit()+" - "+cb2.hasRemaining()); // 0 - 6 - true
//		cb2.flip(); // limit = pos; pos = 0; ��дģʽ��Ϊ��ģʽ
//		cb2.clear(); // pos = 0; ����дģʽ
		cb2.rewind();// rewind()�ڶ�дģʽ�¶����ã��������Ľ���ǰλ����0��ͬʱȡ��mark���
		System.out.println(cb2.position()+" - "+cb2.limit()+" - "+cb2.hasRemaining()); // 0 - 0 - false
		while(cb2.hasRemaining()){ // position��limit֮���Ƿ���Ԫ��
			char i = cb2.get();
			System.out.print(i+" ");
		}
	}
	
	
	/**
	 * mark()��reset()����¼��ǰpostion��position�ͻص���¼��postion
	 */
	public void demo2(){
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o'); // д��hello
		
		buffer.flip(); // ��ת
		
		buffer.mark(); // ��ǰλ����'H'��λ��0����¼��
		
		buffer.position(1); // �ֶ����õ�ǰλ��Ϊ1.
		
		// ������
		while(buffer.hasRemaining()){
			System.out.print(buffer.get()+" ");
		}
		System.out.println();
		
		buffer.reset(); // position�ص�mark����¼��λ��
		
		// ������
		while(buffer.hasRemaining()){
			System.out.print(buffer.get()+" ");
		}
		System.out.println();
	}
	
	/**
	 * ѹ��
	 *  �����Buffer�ж�ȡ��һ��������֮�����в���δ�������ݣ��Һ�������Ҫ��Щ���ݣ����Ǵ�ʱ��Ҫ����дЩ���ݣ���ôʹ��ѹ��
	 */
	public void demo3(){
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.put((byte)'H').put((byte)'e').put((byte)'l').put((byte)'l').put((byte)'o'); // д��hello
		
		buffer.flip();
		
		buffer.position(2); // ��llo��ʼ
		
		buffer.compact(); // ����ѹ�����Զ���תΪдģʽ
		
		buffer.put((byte)'s'); // ��ʣ�µĺ������
		
		buffer.flip();
		
		// ������
		while(buffer.hasRemaining()){
			System.out.print((char)buffer.get()+" "); // l l o s
		}
		System.out.println();
		
		/*
		 * ѹ��ǰ��
		 * 	0	1	2	3	4	5	6	7	8	9
		 *  H	e	l	l	o
		 *  
		 *  ѹ����
		 *  0	1	2	3	4	5	6	7	8	9
		 *  l	l	o
		 *  
		 *  ��䣺
		 *  0	1	2	3	4	5	6	7	8	9
		 *  l	l	o	s
		 */
	}
	
	/**
	 * ����������
	 */
	public void demo4() {
		int[] arr = {1,3,5};
		IntBuffer intBuffer = IntBuffer.wrap(arr);
		for (int i : intBuffer.array()) { // 1, 3, 5
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(intBuffer); // java.nio.HeapIntBuffer[pos=0 lim=3 cap=3]
		
		// ���ƻ�����
		IntBuffer ib = intBuffer.duplicate();
		for (int i : ib.array()) { // 1, 3, 5
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(ib); //java.nio.HeapIntBuffer[pos=0 lim=3 cap=3]
		
		// �޸�ԭ�����������ƵĻ��������ݻ�ı�
		intBuffer.put(0, 110);
		for (int i : ib.array()) { // 110, 3, 5
			System.out.print(i+" ");
		}
		System.out.println();
		
		// �޸��»�������ԭ���������ݻ�ı�
		ib.put(1,300);
		for (int i : intBuffer.array()) { // 1, 3, 5
			System.out.print(i+" ");
		}
		System.out.println();
		
	}
	
	/**
	 * �ָ����
	 * slice���������и������Charbuffer���ָ���������ݱ��޸ģ�ԭ������������Ҳ���޸ġ�
	 */
	public void demo5() {
		// ׼������
		CharBuffer buffer = CharBuffer.allocate(8);
		buffer.put("abcdefgh"); // charbuffer����ֱ��put�ַ���
		
		// ��������
		buffer.position(2).limit(5);
		
		// �ָ�
		CharBuffer sliceBuffer = buffer.slice();
		
		// ���
		while(sliceBuffer.hasRemaining()){
			System.out.print(sliceBuffer.get()+" "); // c d e
		}
		System.out.println();
		
		// �и�
		sliceBuffer.put(0,'z');
		
		// ��ת
		sliceBuffer.flip();
		
		// ���
		while(sliceBuffer.hasRemaining()){
			System.out.print(sliceBuffer.get()+" "); // z d e
		}
		System.out.println();
		
		// ԭ����������Ҳ���޸�
		buffer.position(0).limit(8);
		while(buffer.hasRemaining()){
			System.out.print(buffer.get()+" "); // a b z d e f g h 
		}
		System.out.println();
		
	}
	
	/**
	 * ͨ��Channel
	 * ͨ��ͨ����������С���ܿ��������ʲ���ϵͳ�����IO������������ͨ���ڲ����ͻ�������ݵĶ˵㡣
	 * 
	 * Channel�����������ֽڻ��������ļ�/�׽��֣�������ļ�ͨ�����׽���ͨ����
	 * FileChannel
	 * SokcetChannel
	 * ServerSocketChannel
	 * DatagramChannel
	 * 
	 * Socketͨ������ʹ��Socketͨ���Ĺ�������������FileChannelֻ��ͨ����һ���Ѵ򿪵�
	 * RandomAccessFile��FileInputStream��FileOutputStream��getChannel()������ȡ��
	 * 
	 * ͨ�������ǵ���(ֻʵ��ReadableByteChannel�ӿڻ���ֻʵ��WritableByteChannel�ӿ�)
	 * Ҳ������˫���(�����ӿڶ�ʵ��)��
	 * 
	 * ͨ�������������ͷ�����ģʽ���У�������ģʽ��ͨ����Զ�����õ����߳����ߡ�ֻ����������ͨ��
	 * ����ʹ�÷�����ģʽ��
	 * 
	 * ͨ������ͨ����close�����ر�ͨ�������ǿ��ܻᵼ�¹رյײ�IO����ʱ������������������������һ����
	 * ͨ��isOpen�����ж�ͨ���Ƿ�򿪣����˾Ϳ���ʹ�á�
	 * 
	 * �ļ�ͨ�� FileChannel��
	 * �ļ�ͨ����������ʽ�ġ���Ϊ���������ļ�IO���岻���ļ�IOǿ��֮�������첽IO��һ�����̿��ԴӲ���ϵͳ
	 * ������IO�����������صȴ���Щ������ɡ�
	 * FileChannel���̰߳�ȫ��
	 * 
	 * 
	 */
	
	/**
	 * �ļ�ͨ��
	 * ʹ��NIO��ȡ�ļ�
	 * @throws IOException 
	 */
	public void demo6() throws IOException{
		/*
		 * 1. ��FileInputStream�л�ȡChannel
		 * 2. ����Buffer
		 * 3. ��Channel�����ݶ���Buffer
		 * 4. �޸�buffer��λ�ã���Ϊ0����ʹ��flip��
		 */
		
		// 1. ��ȡͨ��
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/demo/nio/demo3.txt");
		FileChannel channel = fis.getChannel();
		
		// 2. ����Buffer
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		// 3. �����ݶ���Buffer
		channel.read(buffer);
		
		// 4. ��buffer��pos��Ϊ0
		buffer.flip();
		
		// 5. ��
		while(buffer.hasRemaining()){
			byte b = buffer.get();
			System.out.print((char)b);
		}
		
		// 6. �ر�fis
		fis.close();
		
		// ���
//		Hello NIO Demo3 !
//		2017??5??1??09:33:27
	}
	
	/**
	 * �ļ�ͨ��
	 * ʹ��NIO��ȡ�ļ�������������⣬ʹ��jdk1.7��Files��Paths
	 * @throws IOException 
	 */
	public void demo7() throws IOException{
		List<String> lines = Files.readAllLines(
				Paths.get(System.getProperty("user.dir")+"/src/demo/nio/demo3.txt"),
				Charset.forName("GBK"));
		lines.forEach((line) -> System.out.println(line));
		
//		Hello NIO Demo3 !
//		2017��5��1��09:33:27
	}
	
	/**
	 * �ļ�ͨ��
	 * ʹ��NIOд�ļ�
	 * @throws IOException 
	 */
	public void demo8() throws IOException{
		// 1. ��ȡҪд�������
		File file = new File("F:/music/��Ʒ��/Safest Place.mp3");
		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		FileChannel inChannel = fis.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		// 2. ����Ŀ���ļ�
		File output = new File("C:/Users/13670/Desktop",file.getName());
		if(!output.exists()){
			output.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(output);
		FileChannel outChannel = fos.getChannel();
		
		// 3. ����
		while(inChannel.read(buffer) != -1){
			buffer.clear(); // ��ʼдģʽ��position = 0��limit = capacity��
			outChannel.write(buffer);
			buffer.flip(); // תдΪ����limit = posistion�� position = 0��
//			buffer.flip();
		}
		
		// 4. �ر���Դ
		inChannel.close();
		outChannel.close();
		fis.close();
		fos.close();
	}
	
	/**
	 * Channel-to-Channel����
	 * @throws IOException 
	 */
	public void demo9() throws IOException {
		// 1. ��ȡҪд�������
		File file = new File("F:/music/��Ʒ��/Safest Place.mp3");
		FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		FileChannel fromChannel = fis.getChannel();
		
		// 2. ����Ŀ���ļ�
		File output = new File("C:/Users/13670/Desktop",file.getName());
		if(!output.exists()){
			output.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(output);
		FileChannel toChannel = fos.getChannel();
		
		// 3. transferTo��transferFrom
		/*
		 * transferTo(pos,length,targetChannel);
		 * pos��inChannel��ʼ����λ��
		 * count��inChannel���ĳ���
		 * ���pos + count��ֵ����fromChannel��size,�ᴫ�䵽fromChannel�Ľ���λ��
		 */
		fromChannel.transferTo(0, fromChannel.size(), toChannel);
		
		fis.close();
		fos.close();
	}
	
	/**
	 * �ļ���ȡ
	 * @throws IOException 
	 */
	public void demo10() throws IOException{
		RandomAccessFile file = new RandomAccessFile("demo10.txt","rw");//"r", "rw", "rws", or "rwd"
		FileChannel channel = file.getChannel();
		
		// ��ȡ�ļ�ǰ40byte
		channel.truncate(10);
		
		ByteBuffer buffer = ByteBuffer.allocate(10);
		channel.read(buffer);
		
		channel.close();
		file.close();
	}
	
	/**
	 * �ļ�׷��д.������FileOutputStream��ֻ��ʹ��RandomAccessFile
	 * @throws IOException 
	 */
	public void demo11() throws IOException{
		File file = new File(System.getProperty("user.dir")+"/src/demo/nio/demo3.txt");
		
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		FileChannel channel = raf.getChannel();
		
		// ׷������
		String line = "\r\ndemo10!!";
		
		// ��channel��position��󣬼���׷��д��
		channel.position(channel.size());
		
		// ����Buffer������ 
		ByteBuffer buffer = ByteBuffer.wrap(line.getBytes("GBK"));
		
		// ��buffer����д���ļ�
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

