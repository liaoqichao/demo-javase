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
	
	public void demo1(){	//日期格式化
		//DateFormat,SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		System.out.println(sdf.format(date));//2015-11-23 13:57:41
	}
	
	public void demo2() throws UnsupportedEncodingException{	//数字格式化
		//数字格式化主要作用是给数字前面加上￥或者$符号等
		double number = 3.1415926;
		String s = NumberFormat.getPercentInstance().format(number);
		System.out.println(s);//314%
		s = NumberFormat.getIntegerInstance().format(number);
		System.out.println(s);//3
		
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumIntegerDigits(3);//整数部分最小允许位数
		format.setMaximumIntegerDigits(10);//整数部分最大允许位数
		format.setMinimumFractionDigits(2);//小数部分最小允许位数
		format.setMaximumFractionDigits(4);//小数部分最大允许位数
		System.out.println(format.format(number));//003.1416
		
		s = NumberFormat.getCurrencyInstance().format(number);
		System.out.println(s);//￥3.14
		s = NumberFormat.getCurrencyInstance(Locale.UK).format(number);
		System.out.println(s);//?3.14  英镑，符号出现乱码
	}
	
	public void demo3(){	//信息格式化
		/*
		 * MessageFormat.format("模板","参数");
		 * 模板：包含占位符的字符串就是模板.{0},{1},{2}...0，1，2表示下标
		 * 模板里面有多少个占位符，参数里面就要给多少个参数，可变参数需要指定出占位符的值
		 */
		String s = MessageFormat.format("{0}或{1}错误", "用户名","密码");//模板有2个占位符，需要给2个参数
		System.out.println(s);//用户名或密码错误
	}

}
