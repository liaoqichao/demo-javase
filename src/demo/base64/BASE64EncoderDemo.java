package demo.base64;

import java.io.IOException;

import demo.DemoInterface;
import sun.misc.BASE64Decoder;//�������Ҫ�ֶ����룬����CTRL+SHIFT+O
import sun.misc.BASE64Encoder;//�������Ҫ�ֶ����룬����CTRL+SHIFT+O


/**
 * 	sun���ǵײ�İ���java����javax������������һ�㲻�����ã�Ĭ���ǽ�ֹ�ġ�
 *	Windows->Preference->java->Compiler->errors/warning->XXXAPI -> forbidden��error����ignore
 */
public class BASE64EncoderDemo implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		demo1();
	}

	public void demo1() throws IOException {	//BASE64����ͽ���
		
		String s = "Username";
		
		//BASE64����
		BASE64Encoder encoder = new  BASE64Encoder();//�����û����ʾ������AIL+/
		s = encoder.encode(s.getBytes("UTF-8")); //BASE64����
		System.out.println(s);
		
		//BASE64����
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer(s);
		System.out.println(new String(bytes,"UTF-8"));
	}

}
