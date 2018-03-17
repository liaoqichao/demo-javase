package demo.io.coding;

import java.io.UnsupportedEncodingException;

public class EncodeDemo implements Coding {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		//demo1();
		//demo2();//联通问题
		//demo3();
	}
	public void demo1() throws UnsupportedEncodingException{
		/*
		 * "你好"的GBK编码 ：	-60-29-70-61
		 * "你好"的UTF-8编码：	-28-67-96-27-91-67
		 * 
		 * 如果编码错了解不出来。如果编对了,解错了,有可能有救。
		 */
		String s = "你好";
		byte[] buf = s.getBytes("GBK");
		printBytes(buf);
		byte[] buf1 = s.getBytes("utf-8");
		printBytes(buf1);
	}
	public void demo2(){		//联通问题
		
		String s = "联通";
		byte[] buf = s.getBytes();//GBK编码
		printBytesBinary(buf);
		/*
		 * 11000001 10101010 11001101 10101000 
		 * 110 10		110	10
		 * 刚好符合UTF-8中2个字节的规范,所以TXT会把它认为是UTF-8编码,从而解析错误
		 */
	}
	public void demo3() throws UnsupportedEncodingException{
		/*
		 * java中,字符串"ab你好"与字符串"abcd"字符长度是一样,字节长度不一样。
		 * 定义一个方法,按照最大字节来取字串。
		 * 对于"ab你好",如果取3个,"你"的一般就被取走了,那么半个就要舍弃。即取4个字节"ab你"，取5个字节还是"ab你"
		 * 这里假设字母都是正的,汉字都是负的(但是GBK中有些汉字是正的，例如"琲"bei -84 105  不是都是负数这个方法就),但是到UTF-8就是3个负
		 */

		String s = "ab你好CD谢谢";
		int len = s.getBytes("GBK").length;
		System.out.println(len);
		for(int i = 0;i<len;i++){
			
			String subs = cutStringByBytesByGBK(s,i+1);
			System.out.println("截取"+(i+1)+"个字节的结果 : "+subs);
		}
		
		int len1 = s.getBytes("utf-8").length;
		for(int i = 0;i<len1;i++){
			
			String subs = cutStringByBytesByU8(s,i+1);
			System.out.println("截取"+(i+1)+"个字节的结果 : "+subs);
		}
	}
	private String cutStringByBytesByU8(String s, int len) throws UnsupportedEncodingException {
		byte[] buf = s.getBytes("UTF-8");
		int count = 0;
		for(int i = len-1 ; i>=0 ; i--){
			if(buf[i]<0)
				count++;
			else
				break;
		}
		if(count%3==0)
			return new String(buf,0,len,"UTF-8");
		else if(count%3==1)
			return new String(buf,0,len-1,"UTF-8");
		else
			return new String(buf,0,len-2,"UTF-8");
	}
	public String cutStringByBytesByGBK(String s,int len) throws UnsupportedEncodingException {

		byte[] buf = s.getBytes("GBK");
		int count = 0;
		for(int i = len-1 ; i>=0 ; i--){
			if(buf[i]<0)
				count++;
			else
				break;
		}
		if(count%2==0)
			return new String(buf,0,len,"GBK");
		return new String(buf,0,len-1,"GBK");
	}
	public static void printBytes(byte[] buf) {
		for(byte b : buf){
			System.out.print(b);
		}
		System.out.println();
	}
	public static void printBytesBinary(byte[] buf){
		for(byte b : buf){
			System.out.print(Integer.toBinaryString(b&255)+" ");//与255,求最后8个字节
		}
		System.out.println();
	}

}
