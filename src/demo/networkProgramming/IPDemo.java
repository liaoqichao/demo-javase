package demo.networkProgramming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo implements NetwokrProgrammingDemo {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
	}
	public void demo1() throws UnknownHostException{
		//InetAddress没有构造函数
		//获取主机地址ip对象
		InetAddress ip = InetAddress.getLocalHost();
		
		//获取主机ip对象 2
		//ip = InetAddress.getByName("192.168.1.102");//ip = InetAddress.getByName("LiaoQichao");
		
		//获取别人的ip对象
		//ip = InetAddress.getByName("192.168.1.100");//192.168.1.100 : 192.168.1.100
		//在解析主机名,所以要5,6秒后才打印地址。 为什么设备名称不是Galaxy S6 Edge ?? 因为没解析出来  域名解析不成功
		//C:\Windows\System32\drivers\etc\\host里面添加对应关系#192.168.1.100 Galaxy_S6_Edge
		//360屏蔽恶意网站也是用这个方法 127.0.0.1	 恶意网站域名
		ip = InetAddress.getByName("Galaxy_S6_Edge");
		//先解析本地文件,没有再找DNS	
		//ip = InetAddress.getByName("www.baidu.com");//www.baidu.com : 119.75.218.70 把主机名解析出来了
		System.out.println(ip.getHostAddress()+" : "+ip.getHostName());//LiaoQichao : 192.168.1.102
		
	}

}
