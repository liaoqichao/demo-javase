package demo.io;

import demo.DemoInterface;

public interface IO extends DemoInterface {
	/**
	 * 部分没列
	 * 																					IO
	 * 								|--------------------------------------------------------------------------------------------------------|
	 * 	  							字节流																									字符流
	 * 			|-------------------------------------------------------------|												  |------------------------------------------------|
	 * 		InputStream													OutputStream										Reader											Writer
	 * 	|-------|---------|--------|----|----------|			|-------|------|-------|-------|				|--------|-----------|----------|		 	|------------------|--------|-------------|
	 * File-   Filter-	Object-	Piped- Sequence-  ByteArray-	File- Filter- Object- Piped-  ByteArray-	Buffered-	CharArray- String-	InputStream-	Buffered-	OutputStream-   CharArray-   String-   
	 * 			|														|										|															|
	 * 		|----------|									 |----------|-------|							 	|															|
	 * 	Buffered-	Data-									Buffered- Data-	PrintStream						FileReader													FileWriter
	 * 
	 * IO包内,IO体系外的类
	 * RandomAcessFile	只继承Object类,通常用于多线程写入
	 * 
	 * 应该用哪个类?
	 * 1.明确源和目的(汇) 是输入(读)还是输出(写)?
	 * 		源：Reader,InputStream		目的:Writer,OutputStream
	 * 2.明确数据是否是纯文本数据
	 * 		纯文本数据：Reader,Writer		非纯文本数据：InputStream,OutputStream
	 * 3.明确具体设备(数据都是来自设备)[数据源]	
	 * 		源设备:
	 * 			硬盘：File
	 * 			键盘：System.in
	 * 			内存：数组
	 * 			网络：Socket流
	 * 		目的设备：
	 * 			硬盘：File
	 * 			控制台：System.out
	 * 			内存：数组
	 * 			网络：Socket流
	 * 4.是否需要其他额外功能
	 * 		1.是否需要高效(缓冲区)	是：加上buffered
	 * 		2.
	 *
	 */
}
