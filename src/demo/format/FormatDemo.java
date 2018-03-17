package demo.format;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import demo.DemoInterface;

public class FormatDemo implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		demo1();
		demo2();
		demo3();
	}
	
	public void demo1(){	//���ڸ�ʽ��
		//DateFormat,SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));//2015-11-23 13:57:41
	}
	
	public void demo2() throws UnsupportedEncodingException{	//���ָ�ʽ��
		//���ָ�ʽ����Ҫ�����Ǹ�����ǰ����ϣ�����$���ŵ�
		double number = 3.1415926;
		String s = NumberFormat.getPercentInstance().format(number);
		System.out.println(s);//314%
		s = NumberFormat.getIntegerInstance().format(number);
		System.out.println(s);//3
		
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumIntegerDigits(3);//����������С����λ��
		format.setMaximumIntegerDigits(10);//���������������λ��
		format.setMinimumFractionDigits(2);//С��������С����λ��
		format.setMaximumFractionDigits(4);//С�������������λ��
		System.out.println(format.format(number));//003.1416
		
		s = NumberFormat.getCurrencyInstance().format(number);
		System.out.println(s);//��3.14
		s = NumberFormat.getCurrencyInstance(Locale.UK).format(number);
		System.out.println(s);//?3.14  Ӣ�������ų�������
	}
	
	public void demo3(){	//��Ϣ��ʽ��
		/*
		 * MessageFormat.format("ģ��","����");
		 * ģ�壺����ռλ�����ַ�������ģ��.{0},{1},{2}...0��1��2��ʾ�±�
		 * ģ�������ж��ٸ�ռλ�������������Ҫ�����ٸ��������ɱ������Ҫָ����ռλ����ֵ
		 */
		String s = MessageFormat.format("{0}��{1}����", "�û���","����");//ģ����2��ռλ������Ҫ��2������
		System.out.println(s);//�û������������
	}

}
