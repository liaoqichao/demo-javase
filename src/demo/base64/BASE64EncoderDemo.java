package demo.base64;

import java.io.IOException;

import demo.DemoInterface;
import sun.misc.BASE64Decoder;//这个包需要手动导入，不能CTRL+SHIFT+O
import sun.misc.BASE64Encoder;//这个包需要手动导入，不能CTRL+SHIFT+O


/**
 * 	sun包是底层的包，java包和javax包都依赖它，一般不给调用，默认是禁止的。
 *	Windows->Preference->java->Compiler->errors/warning->XXXAPI -> forbidden把error给成ignore
 */
public class BASE64EncoderDemo implements DemoInterface {

	@Override
	public void demo() throws Exception {
		// TODO Auto-generated method stub
		demo1();
	}

	public void demo1() throws IOException {	//BASE64编码和解码
		
		String s = "Username";
		
		//BASE64编码
		BASE64Encoder encoder = new  BASE64Encoder();//这个类没有提示，不能AIL+/
		s = encoder.encode(s.getBytes("UTF-8")); //BASE64编码
		System.out.println(s);
		
		//BASE64解码
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer(s);
		System.out.println(new String(bytes,"UTF-8"));
	}

}
