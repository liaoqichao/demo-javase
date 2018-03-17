package demo.networkProgramming;

public class TCPDemo implements NetwokrProgrammingDemo {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2：文本转换(小写字母变大写)
		//demo3：上传文本文件(字符流)
		//demo4：上传媒体文件(字节流+多线程)
		//demo5：自定义服务器(MyTomcat)
		//demo6:自定义浏览器(MyIE)
	}
	public void demo1(){	//服务器端和客户端
		
		/*
		 * Socket		客户端套接字
		 * ServerSocket	服务器端套接字
		 * 
		 * TCP传输分客户端和服务器端 
		 */
		
		/*
		 * Socket();创建未连接的套接字,然后可以用connect(SocketAddress s);
		 * SocketAddress类就是把IP和端口封装,所以InetAddress是它的子类
		 * Socket(InetAddress ip,int port);指定IP和端口
		 * Socket(String host,int port);host = "192.168.1.100"形式
		 */
		
		/*
		 * tcp的客户端和服务器端很容易出现双方等待的情况
		 */
		
		
	}

}
