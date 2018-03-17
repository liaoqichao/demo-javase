package demo.networkProgramming.tcp.myTomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTomcat {		//自定义服务器 
	//没有Tomcat要安装IIS才能打开localhost
	//IIS在控制面板\所有控制面板项\管理工具 中的IIS(不是6.0)
	//分类按成小图标就有管理工具,不然找不到
	//为什么360不可以打开localhost而IE可以打开localhost
	
	//MyBrowser看视频源代码

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1.创建服务器监听接口，并与特定。
		/*
		 * 操作系统不允许服务器使用1~1023。操作系统可能会需要用到1~1023，所以留给操作系统用
		 * 如果端口为0表示由操作系统来为服务器分配一个任意可用的端口.由操作系统分配的端口也称为匿名端口. 
		 * 对于多数服务器, 会使用明确的端口, 而不会使用匿名端口。 
		 */
		ServerSocket ss = new ServerSocket(9090);
		
		/*
		 * 2.从连接请求队列中取出一个客户的连接请求
		 * 如果队列中没有连接请求, accept() 方法就会一直等待, 直到接收到了连接请求才返回
		 */
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+" is connected");
		
		//3.
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		String text = new String(buf,0,len);
		System.out.print(text);
		
		
		//4.给客户端反馈信息
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("<font color ='red' size='7'>欢迎光临</font>");//可以发送内存信息,文件信息,网站等
		s.close();
		ss.close();
	}

}
//127.0.0.1 is connected

//百度HTTP协议的客户端(浏览器)的请求行,请求消息头,请求正文
//			 服务器端发回给客户端的的应答行,应答消息头,应答正文(页面)
//HTTP协议由请求行,消息报头,请求正文组成	
//-----HTTP协议(请求篇)的请求行
//GET / HTTP/1.1				<---请求行 请求方式  请求的资源路径http协议版本
//---↓请求消息头,属性名：属性值(Properties)
//Accept: text/html, application/xhtml+xml, */*		//允许什么应用程序来解析?
//Accept-Language: zh-CN							//支持语言
//User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0)	//用户代理
//UA-CPU: AMD64
//Accept-Encoding: gzip, deflate					//支持的压缩方式(服务器端将网络数据压缩,不然打开一个很大的网页要打开半天,发送给客户端解压缩)
//Host: localhost:9090
//Connection: Keep-Alive			Keep-Alive意思是连接一会儿。因为HTTP是无状态协议。如果立刻断开的话,有请求又要重新连接。
//									因为页面是一个请求,页面里的图片也是单独的一个请求,打开一个网页其实是有若干次请求的,如果都立刻断开就很浪费。
//									用Keep-Alive就可以一个连接可以响应多个请求。
									//HTTP协议是无状态协议。协议的状态是指下一次传输可以“记住”这次传输信息的能力。
//									http是不会为了下一次连接而维护这次连接所传输的信息,为了保证服务器内存。
//									连接一个网站后,HTTP协议就断开了,不会一直连接浪费流量。拔掉网线页面也不会消失
//									简单的说：无状态就是请求，响应完就断开。有状态就是一直跟踪着,第一个请求和第二个请求都知道是你发的。FTP协议就是有状态的。

//空行
//---请求体(请求行和请求体要有空行)
