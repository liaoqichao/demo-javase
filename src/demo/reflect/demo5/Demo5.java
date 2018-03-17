package demo.reflect.demo5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Demo5 {

	/**
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws ReflectiveOperationException 
	 */
	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		MainBoard mb = new MainBoard();
		mb.run();
		//直接获取class文件,内部实现创建动作
		//不用修改源代码,只用修改配置文件
		File config = new File(
				"E:\\Eclipse\\workspace\\Demo\\bin\\demo\\reflect\\demo5\\PCI.properties");
		Properties prop = new Properties();
		FileReader fr = new FileReader(config);
		prop.load(fr);
		
		if(prop.size() == 0)
			return;
		for(int i = 0; i<prop.size(); i++){
			String pciName = prop.getProperty("pci"+(i+1));
			Class<?> clazz = Class.forName(pciName);
			Object object = clazz.newInstance();//这个类是空参构造函数
			PCI p = (PCI)object;//百分百是PCI的子类
			mb.UsePCI(p);
		}
		
		fr.close();
	}

}
