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
		//InetAddressû�й��캯��
		//��ȡ������ַip����
		InetAddress ip = InetAddress.getLocalHost();
		
		//��ȡ����ip���� 2
		//ip = InetAddress.getByName("192.168.1.102");//ip = InetAddress.getByName("LiaoQichao");
		
		//��ȡ���˵�ip����
		//ip = InetAddress.getByName("192.168.1.100");//192.168.1.100 : 192.168.1.100
		//�ڽ���������,����Ҫ5,6���Ŵ�ӡ��ַ�� Ϊʲô�豸���Ʋ���Galaxy S6 Edge ?? ��Ϊû��������  �����������ɹ�
		//C:\Windows\System32\drivers\etc\\host������Ӷ�Ӧ��ϵ#192.168.1.100 Galaxy_S6_Edge
		//360���ζ�����վҲ����������� 127.0.0.1	 ������վ����
		ip = InetAddress.getByName("Galaxy_S6_Edge");
		//�Ƚ��������ļ�,û������DNS	
		//ip = InetAddress.getByName("www.baidu.com");//www.baidu.com : 119.75.218.70 ������������������
		System.out.println(ip.getHostAddress()+" : "+ip.getHostName());//LiaoQichao : 192.168.1.102
		
	}

}
